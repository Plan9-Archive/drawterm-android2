# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

include_directories(BEFORE src/main/drawterm/include/ src/main/drawterm/ src/main/drawterm/kern/ )

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library(native-lib SHARED
                        src/main/cpp/native-lib.c
                        src/main/cpp/android.c
                        src/main/cpp/dtmain.c
                        src/main/cpp/flushimage.c
                        src/main/cpp/devandroid.c

                        src/main/drawterm/cpu.c
                        src/main/drawterm/aan.c
                        src/main/drawterm/posix-factotum.c
                        src/main/drawterm/secstore.c
                        src/main/drawterm/latin1.c

                        src/main/drawterm/kern/alloc.c
                        src/main/drawterm/kern/allocb.c
                        src/main/drawterm/kern/chan.c
                        src/main/drawterm/kern/data.c
                        src/main/drawterm/kern/dev.c
                        src/main/drawterm/kern/devaudio-none.c
                        src/main/drawterm/kern/devaudio.c
                        src/main/drawterm/kern/devcons.c
                        src/main/drawterm/kern/devdraw.c
                        src/main/drawterm/kern/devfs-posix.c
                        src/main/drawterm/kern/devip-posix.c
                        src/main/drawterm/kern/devip.c
                        src/main/drawterm/kern/devkbd.c
                        src/main/drawterm/kern/devlfd.c
                        src/main/drawterm/kern/devmnt.c
                        src/main/drawterm/kern/devmouse.c
                        src/main/drawterm/kern/devpipe.c
                        src/main/drawterm/kern/devroot.c
                        src/main/drawterm/kern/devssl.c
                        src/main/drawterm/kern/devtab.c
                        src/main/drawterm/kern/devtls.c
                        src/main/drawterm/kern/error.c
                        src/main/drawterm/kern/parse.c
                        src/main/drawterm/kern/pgrp.c
                        src/main/drawterm/kern/posix.c
                        src/main/drawterm/kern/procinit.c
                        src/main/drawterm/kern/qio.c
                        src/main/drawterm/kern/qlock.c
                        src/main/drawterm/kern/rendez.c
                        src/main/drawterm/kern/rwlock.c
                        #src/main/drawterm/kern/sleep.c
                        src/main/drawterm/kern/stub.c
                        src/main/drawterm/kern/sysfile.c
                        src/main/drawterm/kern/term.c
                        src/main/drawterm/kern/waserror.c

						src/main/drawterm/libc/atexit.c
						src/main/drawterm/libc/charstod.c
						src/main/drawterm/libc/cleanname.c
						src/main/drawterm/libc/convD2M.c
						src/main/drawterm/libc/convM2D.c
						src/main/drawterm/libc/convM2S.c
						src/main/drawterm/libc/convS2M.c
						src/main/drawterm/libc/ctime.c
						src/main/drawterm/libc/dial.c
						src/main/drawterm/libc/dirmodefmt.c
						src/main/drawterm/libc/dofmt.c
						src/main/drawterm/libc/dorfmt.c
						src/main/drawterm/libc/encodefmt.c
						src/main/drawterm/libc/fcallfmt.c
						src/main/drawterm/libc/fltfmt.c
						src/main/drawterm/libc/fmt.c
						src/main/drawterm/libc/fmtfd.c
						src/main/drawterm/libc/fmtfdflush.c
						src/main/drawterm/libc/fmtlock.c
						src/main/drawterm/libc/fmtquote.c
						src/main/drawterm/libc/fmtrune.c
						src/main/drawterm/libc/fmtstr.c
						src/main/drawterm/libc/fmtvprint.c
						src/main/drawterm/libc/fprint.c
						src/main/drawterm/libc/frand.c
						src/main/drawterm/libc/getfields.c
						src/main/drawterm/libc/getpid.c
						src/main/drawterm/libc/lnrand.c
						src/main/drawterm/libc/lock.c
						src/main/drawterm/libc/lrand.c
						src/main/drawterm/libc/mallocz.c
    					src/main/drawterm/libc/nan64.c
						src/main/drawterm/libc/netmkaddr.c
						src/main/drawterm/libc/nrand.c
						src/main/drawterm/libc/nsec.c
						src/main/drawterm/libc/pow10.c
						#src/main/drawterm/libc/print.c
						src/main/drawterm/libc/pushssl.c
						src/main/drawterm/libc/pushtls.c
						src/main/drawterm/libc/readn.c
						src/main/drawterm/libc/rune.c
						src/main/drawterm/libc/runefmtstr.c
						src/main/drawterm/libc/runeseprint.c
						src/main/drawterm/libc/runesmprint.c
						src/main/drawterm/libc/runesnprint.c
						src/main/drawterm/libc/runesprint.c
						src/main/drawterm/libc/runestrcat.c
						src/main/drawterm/libc/runestrchr.c
						src/main/drawterm/libc/runestrcmp.c
						src/main/drawterm/libc/runestrcpy.c
						src/main/drawterm/libc/runestrdup.c
						src/main/drawterm/libc/runestrecpy.c
						src/main/drawterm/libc/runestrlen.c
						src/main/drawterm/libc/runestrncat.c
						src/main/drawterm/libc/runestrncmp.c
						src/main/drawterm/libc/runestrncpy.c
						src/main/drawterm/libc/runestrrchr.c
						src/main/drawterm/libc/runestrstr.c
						src/main/drawterm/libc/runetype.c
						src/main/drawterm/libc/runevseprint.c
						src/main/drawterm/libc/runevsmprint.c
						src/main/drawterm/libc/runevsnprint.c
						src/main/drawterm/libc/seprint.c
						src/main/drawterm/libc/smprint.c
    					src/main/drawterm/libc/snprint.c
						src/main/drawterm/libc/sprint.c
						src/main/drawterm/libc/strecpy.c
						src/main/drawterm/libc/strtod.c
						src/main/drawterm/libc/strtoll.c
						src/main/drawterm/libc/sysfatal.c
						src/main/drawterm/libc/time.c
						src/main/drawterm/libc/tokenize.c
						src/main/drawterm/libc/u16.c
						src/main/drawterm/libc/u32.c
						src/main/drawterm/libc/u64.c
						src/main/drawterm/libc/utfecpy.c
    					src/main/drawterm/libc/utflen.c
						src/main/drawterm/libc/utfnlen.c
						src/main/drawterm/libc/utfrrune.c
						src/main/drawterm/libc/utfrune.c
						src/main/drawterm/libc/utfutf.c
						src/main/drawterm/libc/vfprint.c
						src/main/drawterm/libc/vseprint.c
						src/main/drawterm/libc/vsmprint.c
						src/main/drawterm/libc/vsnprint.c
                        src/main/drawterm/libc/read9pmsg.c
                        src/main/drawterm/libc/dirstat.c
                        src/main/drawterm/libc/dirfstat.c
                        src/main/drawterm/libc/dirfwstat.c
                        src/main/drawterm/libc/dirwstat.c

                        src/main/drawterm/exportfs/exportfs.c
                        src/main/drawterm/exportfs/exportsrv.c

                        src/main/drawterm/libsec/aes.c src/main/drawterm/libsec/aesCBC.c src/main/drawterm/libsec/aesCFB.c src/main/drawterm/libsec/aesOFB.c src/main/drawterm/libsec/aes_gcm.c src/main/drawterm/libsec/aes_xts.c src/main/drawterm/libsec/aesni.c src/main/drawterm/libsec/blowfish.c src/main/drawterm/libsec/ccpoly.c src/main/drawterm/libsec/chacha.c src/main/drawterm/libsec/chachablock.c src/main/drawterm/libsec/curve25519.c src/main/drawterm/libsec/curve25519_dh.c src/main/drawterm/libsec/decodepem.c src/main/drawterm/libsec/des.c src/main/drawterm/libsec/des3CBC.c src/main/drawterm/libsec/des3ECB.c src/main/drawterm/libsec/desCBC.c src/main/drawterm/libsec/desECB.c src/main/drawterm/libsec/desmodes.c src/main/drawterm/libsec/dh.c src/main/drawterm/libsec/dsaalloc.c src/main/drawterm/libsec/dsagen.c src/main/drawterm/libsec/dsaprimes.c src/main/drawterm/libsec/dsaprivtopub.c src/main/drawterm/libsec/dsasign.c src/main/drawterm/libsec/dsaverify.c src/main/drawterm/libsec/ecc.c src/main/drawterm/libsec/egalloc.c src/main/drawterm/libsec/egdecrypt.c src/main/drawterm/libsec/egencrypt.c src/main/drawterm/libsec/eggen.c src/main/drawterm/libsec/egprivtopub.c src/main/drawterm/libsec/egsign.c src/main/drawterm/libsec/egverify.c src/main/drawterm/libsec/fastrand.c src/main/drawterm/libsec/genprime.c src/main/drawterm/libsec/genrandom.c src/main/drawterm/libsec/gensafeprime.c src/main/drawterm/libsec/genstrongprime.c src/main/drawterm/libsec/hkdf.c src/main/drawterm/libsec/hmac.c src/main/drawterm/libsec/jacobian.c src/main/drawterm/libsec/md4.c src/main/drawterm/libsec/md5.c src/main/drawterm/libsec/md5block.c src/main/drawterm/libsec/md5pickle.c src/main/drawterm/libsec/nfastrand.c src/main/drawterm/libsec/pbkdf2.c src/main/drawterm/libsec/poly1305.c src/main/drawterm/libsec/prng.c src/main/drawterm/libsec/probably_prime.c src/main/drawterm/libsec/rc4.c src/main/drawterm/libsec/readcert.c src/main/drawterm/libsec/ripemd.c src/main/drawterm/libsec/rsaalloc.c src/main/drawterm/libsec/rsadecrypt.c src/main/drawterm/libsec/rsaencrypt.c src/main/drawterm/libsec/rsafill.c src/main/drawterm/libsec/rsagen.c src/main/drawterm/libsec/rsaprivtopub.c src/main/drawterm/libsec/salsa.c src/main/drawterm/libsec/scrypt.c src/main/drawterm/libsec/secp256k1.c src/main/drawterm/libsec/secp256r1.c src/main/drawterm/libsec/secp384r1.c src/main/drawterm/libsec/sha1.c src/main/drawterm/libsec/sha1block.c src/main/drawterm/libsec/sha1pickle.c src/main/drawterm/libsec/sha2_128.c src/main/drawterm/libsec/sha2_64.c src/main/drawterm/libsec/sha2block128.c
                        src/main/drawterm/libsec/sha2block64.c
                        src/main/drawterm/libsec/smallprimes.c
                        src/main/drawterm/libsec/smallprimetest.c
                        src/main/drawterm/libsec/tlshand.c
                        src/main/drawterm/libsec/tsmemcmp.c
                        src/main/drawterm/libsec/x509.c
                        src/main/drawterm/libc/truerand.c

                        src/main/drawterm/libauth/attr.c src/main/drawterm/libauth/auth_attr.c src/main/drawterm/libauth/auth_proxy.c src/main/drawterm/libauth/auth_rpc.c

                        src/main/drawterm/libmp/betomp.c src/main/drawterm/libmp/cnfield.c src/main/drawterm/libmp/crt.c src/main/drawterm/libmp/crttest.c src/main/drawterm/libmp/gmfield.c src/main/drawterm/libmp/letomp.c src/main/drawterm/libmp/mpadd.c src/main/drawterm/libmp/mpaux.c src/main/drawterm/libmp/mpcmp.c src/main/drawterm/libmp/mpdigdiv.c src/main/drawterm/libmp/mpdiv.c src/main/drawterm/libmp/mpexp.c src/main/drawterm/libmp/mpextendedgcd.c src/main/drawterm/libmp/mpfactorial.c src/main/drawterm/libmp/mpfield.c src/main/drawterm/libmp/mpfmt.c src/main/drawterm/libmp/mpinvert.c src/main/drawterm/libmp/mpleft.c src/main/drawterm/libmp/mplogic.c src/main/drawterm/libmp/mpmod.c src/main/drawterm/libmp/mpmodop.c src/main/drawterm/libmp/mpmul.c src/main/drawterm/libmp/mpnrand.c src/main/drawterm/libmp/mprand.c src/main/drawterm/libmp/mpright.c src/main/drawterm/libmp/mpsub.c src/main/drawterm/libmp/mptobe.c src/main/drawterm/libmp/mptober.c src/main/drawterm/libmp/mptoi.c src/main/drawterm/libmp/mptole.c src/main/drawterm/libmp/mptolel.c src/main/drawterm/libmp/mptoui.c src/main/drawterm/libmp/mptouv.c src/main/drawterm/libmp/mptov.c src/main/drawterm/libmp/mpvecadd.c src/main/drawterm/libmp/mpveccmp.c src/main/drawterm/libmp/mpvecdigmuladd.c src/main/drawterm/libmp/mpvecsub.c src/main/drawterm/libmp/mpvectscmp.c src/main/drawterm/libmp/strtomp.c src/main/drawterm/libc/fmtprint.c

                        src/main/drawterm/libauthsrv/_asgetpakkey.c src/main/drawterm/libauthsrv/_asgetresp.c src/main/drawterm/libauthsrv/_asgetticket.c src/main/drawterm/libauthsrv/_asrdresp.c src/main/drawterm/libauthsrv/_asrequest.c src/main/drawterm/libauthsrv/authpak.c src/main/drawterm/libauthsrv/convA2M.c src/main/drawterm/libauthsrv/convM2A.c src/main/drawterm/libauthsrv/convM2PR.c src/main/drawterm/libauthsrv/convM2T.c src/main/drawterm/libauthsrv/convM2TR.c src/main/drawterm/libauthsrv/convPR2M.c src/main/drawterm/libauthsrv/convT2M.c src/main/drawterm/libauthsrv/convTR2M.c src/main/drawterm/libauthsrv/form1.c src/main/drawterm/libauthsrv/nvcsum.c src/main/drawterm/libauthsrv/passtokey.c src/main/drawterm/libauthsrv/readcons.c src/main/drawterm/libauthsrv/readnvram.c  src/main/drawterm/libmp/mpsel.c	src/main/drawterm/libc/crypt.c src/main/drawterm/libsec/pbkdf2.c

                        src/main/drawterm/posix-arm/getcallerpc.c
                        #src/main/drawterm/posix-arm/md5block.c
                        #src/main/drawterm/posix-arm/sha1block.c
                        src/main/drawterm/posix-arm/tas.c

                        src/main/drawterm/libip/bo.c src/main/drawterm/libip/classmask.c src/main/drawterm/libip/eipfmt.c src/main/drawterm/libip/ipaux.c src/main/drawterm/libip/parseip.c

                        src/main/drawterm/libmemdraw/alloc.c
                        src/main/drawterm/libmemdraw/arc.c
                        src/main/drawterm/libmemdraw/cmap.c
                        src/main/drawterm/libmemdraw/cread.c
                        src/main/drawterm/libmemdraw/defont.c
                        src/main/drawterm/libmemdraw/draw.c
                        src/main/drawterm/libmemdraw/ellipse.c
                        src/main/drawterm/libmemdraw/fillpoly.c
                        src/main/drawterm/libmemdraw/hwdraw.c
                        src/main/drawterm/libmemdraw/line.c
                        src/main/drawterm/libmemdraw/openmemsubfont.c
                        src/main/drawterm/libmemdraw/poly.c
                        src/main/drawterm/libmemdraw/read.c
                        src/main/drawterm/libmemdraw/string.c
                        src/main/drawterm/libmemdraw/subfont.c
                        src/main/drawterm/libmemdraw/write.c

                        src/main/cpp/computil.c

                        src/main/drawterm/libmemlayer/draw.c src/main/drawterm/libmemlayer/lalloc.c src/main/drawterm/libmemlayer/layerop.c src/main/drawterm/libmemlayer/ldelete.c src/main/drawterm/libmemlayer/lhide.c src/main/drawterm/libmemlayer/line.c src/main/drawterm/libmemlayer/load.c src/main/drawterm/libmemlayer/lorigin.c src/main/drawterm/libmemlayer/lsetrefresh.c src/main/drawterm/libmemlayer/ltofront.c src/main/drawterm/libmemlayer/ltorear.c src/main/drawterm/libmemlayer/unload.c src/main/drawterm/libmemdraw/cload.c src/main/drawterm/libmemdraw/load.c src/main/drawterm/libmemdraw/unload.c

                        src/main/drawterm/libdraw/alloc.c
                        src/main/drawterm/libdraw/arith.c
                        src/main/drawterm/libdraw/badrect.c
                        src/main/drawterm/libdraw/bytesperline.c
                        src/main/drawterm/libdraw/chan.c
#                        src/main/drawterm/libdraw/computil.c
                        src/main/drawterm/libdraw/defont.c
                        src/main/drawterm/libdraw/drawrepl.c
                        src/main/drawterm/libdraw/fmt.c
                        src/main/drawterm/libdraw/icossin.c
                        src/main/drawterm/libdraw/icossin2.c
#                        src/main/drawterm/libdraw/init.c
                        src/main/drawterm/libdraw/rectclip.c
                        src/main/drawterm/libdraw/rgb.c
)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

find_library( camera-lib camera2ndk )
find_library( media-lib mediandk )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries(native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}
                       ${camera-lib}
                       ${media-lib} )
