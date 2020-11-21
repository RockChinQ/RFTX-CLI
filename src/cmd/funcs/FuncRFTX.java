package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncRFTX implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "rftx";
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
            //String peerName,String taskToken,String localFile,String remoteFile
            case "post":{
                if(arg0.length<5){
                    Out.sayln("usage:rftx post <nameOfTargetPeer> <taskToken> <localFilePath> <remoteFilePath>");
                    break;
                }
                try{
                    CLIMain.host.post(arg0[1], arg0[2], arg0[3],arg0[4]);
                    Out.sayln("req launched.");
                }catch(Exception e){
                    Out.sayln("failed to launch a post req:\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
            case "get":{
                if(arg0.length<5){
                    Out.sayln("usage:rftx get <nameOfTargetPeer> <taskToken> <localFilePath> <remoteFilePath>");
                    break;
                }
                try{
                    CLIMain.host.get(arg0[1], arg0[2], arg0[3],arg0[4]);
                    Out.sayln("req launched.");
                }catch(Exception e){
                    Out.sayln("failed to launch a get req:\n"+CLIMain.getErrorInfo(e));
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
