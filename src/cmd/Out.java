package cmd;

public class Out {
    static String prompt="localhost";
    public static void sayln(String msg){
        // " + "我滴个颜什" + "\033[0m"
        sayThisLine("\033[0m\033[200D"+msg+"\n\033[32mRFTX @"+prompt+">");
    }
    public static void saySub(String sub,String msg){
        sayln("["+sub+"]"+msg);
    }
    public static void sayThisLine(String msg){
        System.out.print("\033[0m"+msg);
    }
}
