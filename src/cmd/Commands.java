package cmd;

import java.io.DataInputStream;

import com.rftx.util.Debugger;

public class Commands extends Thread{
    public DataInputStream consoleInput=new DataInputStream(System.in);
    static String buffer="";
    public void run(){
        int ch=0;
        try{
            while((ch=System.in.read())!=-1){
                //Debugger.say("type:"+ch);
                if((char)ch=='\n'){
                    CLIMain.processor.start(buffer);
                    buffer="";
                }else if((char)ch=='\r'){

                }else {
                    buffer=buffer+(char)ch;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
