package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncServer implements AbstractFunc {

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
            Out.sayln("syntax error.");
            return;
        }
        switch(arg0[0]){
            case "start":{
                try{
                    if(arg0.length<2){
                        Out.sayln("usage:server start <port>");
                        break;
                    }
                    Out.sayln("starting server..");
                    CLIMain.host.initServer(Integer.parseInt(arg0[1]));
                    CLIMain.host.server.start();
                    Out.sayln("server started at port:"+arg0[1]);
                }catch(Exception e){
                    Out.sayln("failed to start server:\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
            case "stop":{
                try{
                    CLIMain.host.server.stop();
                    Out.sayln("server stopped.");
                }catch(Exception e){
                    Out.sayln("failed to stop server:\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
        }
    }
}
