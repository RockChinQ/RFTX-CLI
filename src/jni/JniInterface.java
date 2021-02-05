package jni;

public class JniInterface {
    static {
        System.loadLibrary("RFTXJNI");
    }
    public static native char getch();
    public static native String getstr();
}
