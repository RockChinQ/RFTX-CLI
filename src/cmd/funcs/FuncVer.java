package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncVer implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "ver";
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "ver";
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
        Out.sayln("CLI version:"+CLIMain.VERSION_STRING);
        Out.sayln("RFTX version:"+CLIMain.RFTX_VERSION);
    }
    
}
