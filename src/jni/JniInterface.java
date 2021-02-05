package jni;

public class JniInterface {
    static {
        System.loadLibrary("RFTXJNI");
    }
    public static native String getstr();
    public static native void setDebugMode(boolean debugMode);
}
