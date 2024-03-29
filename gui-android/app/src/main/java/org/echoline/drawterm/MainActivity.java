package org.echoline.drawterm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<String, String> map;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseDT();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeDT();
    }

    public void myFancyMethod(View v) {
        setContentView(R.layout.server_main);
        serverButtons();

        String s = map.get(((TextView)v).getText().toString());
        String []a = s.split("\007");

        ((EditText)MainActivity.this.findViewById(R.id.cpuServer)).setText((String)a[0]);
        ((EditText)MainActivity.this.findViewById(R.id.authServer)).setText((String)a[1]);
        ((EditText)MainActivity.this.findViewById(R.id.userName)).setText((String)a[2]);
        ((EditText)MainActivity.this.findViewById(R.id.passWord)).setText((String)a[3]);
    }

    public void populateServers(Context context) {
        ListView ll = findViewById(R.id.servers);
        ArrayAdapter<String> la = new ArrayAdapter<String>(MainActivity.this, R.layout.item_main);
        SharedPreferences settings = getSharedPreferences("DrawtermPrefs", 0);
        map = (Map<String, String>)settings.getAll();
        String key;
        Object []keys = map.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            key = (String)keys[i];
            la.add(key);
        }
        ll.setAdapter(la);
    }

    public void serverButtons() {
        Button button = (Button)findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpu = ((EditText)MainActivity.this.findViewById(R.id.cpuServer)).getText().toString();
                String auth = ((EditText)MainActivity.this.findViewById(R.id.authServer)).getText().toString();
                String user = ((EditText)MainActivity.this.findViewById(R.id.userName)).getText().toString();
                String pass = ((EditText)MainActivity.this.findViewById(R.id.passWord)).getText().toString();

                SharedPreferences settings = getSharedPreferences("DrawtermPrefs", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(user + "@" + cpu + " (auth="  + auth + ")", cpu + "\007" + auth + "\007" + user + "\007" + pass);
                editor.commit();
            }
        });

        button = (Button) findViewById(R.id.connect);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String cpu = ((EditText)MainActivity.this.findViewById(R.id.cpuServer)).getText().toString();
                String auth = ((EditText)MainActivity.this.findViewById(R.id.authServer)).getText().toString();
                String user = ((EditText)MainActivity.this.findViewById(R.id.userName)).getText().toString();
                String pass = ((EditText)MainActivity.this.findViewById(R.id.passWord)).getText().toString();

                int wp = MainActivity.this.getWindow().getDecorView().getWidth();
                int hp = MainActivity.this.getWindow().getDecorView().getHeight();

                setContentView(R.layout.drawterm_main);

                WindowManager wm = (WindowManager)MainActivity.this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                if (wm != null) {
                    Display d = wm.getDefaultDisplay();
                    Point p = new Point();
                    d.getSize(p);
                    wp = p.x;
                    hp = p.y;
                    Resources res = MainActivity.this.getResources();
                    int rid = res.getIdentifier("navigation_bar_height", "dimen", "android");
                    if (rid > 0) {
                        hp -= res.getDimensionPixelSize(rid);
                    }
                    LinearLayout ll = findViewById(R.id.mouseButtons);
                    hp -= ll.getHeight();
                }

                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int w = (int)(wp * (160.0/dm.xdpi));
                int h = (int)(hp * (160.0/dm.ydpi));
                float ws = (float)wp/w;
                float hs = (float)hp/h;
                // only scale up
                if (ws < 1) {
                    ws = 1;
                    w = wp;
                }
                if (hs < 1) {
                    hs = 1;
                    h = hp;
                }

                MySurfaceView mView = new MySurfaceView(MainActivity.this, w, h, ws, hs);
                LinearLayout l = MainActivity.this.findViewById(R.id.dlayout);
                l.addView(mView, 1, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                DrawTermThread t = new DrawTermThread(cpu, auth, user, pass, MainActivity.this);
                t.start();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        File dir = Environment.getExternalStorageDirectory();
        Log.d("drawterm", dir.toString());
        Log.d("drawterm", Environment.getExternalStorageState());

        setContentView(R.layout.activity_main);
        populateServers(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.server_main);
                serverButtons();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void dtmain(Object[] args);
    public native void setPass(String arg);
    public native void setWidth(int arg);
    public native void setHeight(int arg);
    public native void setWidthScale(float arg);
    public native void setHeightScale(float arg);
    public native byte[] getScreenData();
    public native void setMouse(int[] args);
    public native String getSnarf();
    public native void setSnarf(String str);
    public native void pauseDT();
    public native void resumeDT();
}
