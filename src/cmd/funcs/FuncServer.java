package cmd.funcs;

import java.util.Date;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncServer implements AbstractFunc {
    public static boolean running=false;
    public static long startTime=0;
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "server";
    }

    @Override
    public int getMinParamsAmount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String[] getParamsModel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void run(String[] arg0, String arg1, AbstractProcessor arg2) {
        // TODO Auto-generated method stub
        if(arg0.length<1){
            CLIMain.cmdThr.syntaxErrorInfo();
            return;
        }
        switch(arg0[0]){
            case "start":{
                try{
                    if(running){
                        Out.sayln("server is already running.");
                        break;
                    }
                    if(arg0.length<2){
                        Out.sayln("usage:server start <port>");
                        break;
                    }
                    Out.sayln("starting server..");
                    CLIMain.host.initServer(Integer.parseInt(arg0[1]));
                    CLIMain.host.server.setServerConnListener(CLIMain.serverConn);
                    CLIMain.host.server.start();
                    Out.sayln("server started at port:"+arg0[1]);
                    running=true;
                    startTime=new Date().getTime();
                }catch(Exception e){
                    Out.sayln("failed to start server:\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
            case "stop":{
                try{
                    if(!running){
                        Out.sayln("server is not running.");
                        break;
                    }
                    CLIMain.host.server.stop();
                    Out.sayln("server stopped.");
                    running=false;
                }catch(Exception e){
                    Out.sayln("failed to stop server:\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
            default:{
                CLIMain.cmdThr.syntaxErrorInfo();
                break;
            }
        }
    }
}
