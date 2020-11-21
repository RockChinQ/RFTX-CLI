package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncToken implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "token";
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
            case "set":{
                if(arg0.length<2){
                    Out.sayln("usage:token set <tokenOfThisHost>");
                    break;
                }
                CLIMain.host.getAuthenticator().clientToken=arg0[1];
                Out.sayln("set client token to:"+CLIMain.host.getAuthenticator().clientToken);
                break;
            }
            case "add":{
                if(arg0.length<3){
                    Out.sayln("usage:token add <tokenName> <acceptableToken>");
                    break;
                }
                CLIMain.host.getAuthenticator().getAuthTokenMap().put(arg0[1], arg0[2]);
                Out.sayln("add valid token:"+arg0[1]+":"+arg0[2]);
                break;
            }
            case "ls":{
                Out.sayThisLine("host token:"+CLIMain.host.getAuthenticator().clientToken+"\n");
                // Out.sayThisLine("-----------\n");
                Out.sayThisLine("valid client token("+(CLIMain.host.getAuthenticator().getAuthTokenMap().size())+"):\n");
                for(var key:CLIMain.host.getAuthenticator().getAuthTokenMap().keySet()){
                    Out.sayThisLine(key+" "+CLIMain.host.getAuthenticator().getAuthTokenMap().get(key)+"\n");
                }
                Out.sayln("\ndone.                  ");
                break;
            }
            case "del":{
                if(arg0.length<2){
                    Out.sayln("usage:token del <tokenName>");
                    break;
                }
                if(CLIMain.host.getAuthenticator().getAuthTokenMap().containsKey(arg0[1])){
                    String delToken=CLIMain.host.getAuthenticator().getAuthTokenMap().remove(arg0[1]);
                    Out.sayln("token:\""+delToken+"\" is no longer acceptable.");
                }else{
                    Out.sayln("no such token name.");
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
