package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncExit implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "exit";
    }

    @Override
    public int getMinParamsAmount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String[] getParamsModel() {
        return null;
    }

    @Override
    public void run(String[] arg0, String arg1, AbstractProcessor arg2) {
        Out.sayThisLine("press ENTER to exit.\n");
        CLIMain.cmdThr.stop();
        try {
            CLIMain.host.exit();
        } catch (Exception e) {
            Out.sayln("failed to exit:\n"+CLIMain.getErrorInfo(e));
        }
    }
    
}
