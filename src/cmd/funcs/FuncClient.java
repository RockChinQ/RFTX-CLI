package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncClient implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "client";
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
                case "conn":{
                    try{
                        if(arg0.length<2){
                            Out.sayln("usage:client conn <addr:port>");
                        }
                        String[] targetHost=arg0[1].split(":");
                        CLIMain.host.client.connect(targetHost[0],Integer.parseInt(targetHost[1]), CLIMain.host.getAuthenticator().clientToken);
                    }catch(Exception e){
                        Out.sayln("cannot create conn:\n"+CLIMain.getErrorInfo(e));
                    }
                    break;
                }
                default:{
                    CLIMain.cmdThr.syntaxErrorInfo();
                    return;
                }
            }
    }
    
}
