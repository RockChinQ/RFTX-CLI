package cmd;

public class Out {
    static String prompt="localhost";
    public static void sayln(String msg){
        sayThisLine("\033[200D"+msg+"\nRFTX @"+prompt+">");
    }
    public static void saySub(String sub,String msg){
        sayln("["+sub+"]"+msg);
    }
    public static void sayThisLine(String msg){
        System.out.print(msg);
    }
}
