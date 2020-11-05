package cmd.funcs;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.Out;

public class FuncDefault implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return null;
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
        Out.sayln("cannot parse command:\n"+arg1);
    }
    
}
