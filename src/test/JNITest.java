package test;

import jni.JniInterface;

public class JNITest {
    public static void main(String[] args) {
        System.out.println("我:"+(int)('我')+"是:"+(int)('是')+"你:"+(int)'你'+"爸:"+(int)'爸');
        for (;;) {
            System.out.print("type:");
            String str=JniInterface.getstr();
//            if (outC >127){
//                char c2=JniInterface.getch();
//                outC= (char) ((char) (outC<<8)|c2);
//            }
//            System.out.print("\nyou typed:" + outC+"("+(int)outC+")"+"\n");
            System.out.println("typed:"+str);
        }
    }
}
