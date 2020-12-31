package cmd;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.rftx.util.Debugger;

public class Commands extends Thread{
    public DataInputStream consoleInput=new DataInputStream(System.in);
    static String buffer="";
    public void run(){
        BufferedReader typeReader = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));//键盘的reader
        readMsg:while (true) {
            try {
                String typeCmd = typeReader.readLine();
                CLIMain.processor.start(typeCmd);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void syntaxErrorInfo(){
        Out.sayln("syntax error.");
    }
}
