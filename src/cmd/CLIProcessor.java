package cmd;

import cmd.funcs.*;

public class CLIProcessor extends AbstractProcessor {

    public CLIProcessor(){
        this.registerFunc(new FuncVer());
        this.registerFunc(new FuncExit());
        this.registerFunc(new FuncServer());

        this.setDefaultFunc(new FuncDefault());
    }
    @Override
    protected Command parse(String arg0) {
        // TODO Auto-generated method stub
        String[] spt=arg0.split(" ");
        Command cmd=new Command(spt[0],subArray(spt, 1, spt.length),arg0);
        return cmd;
    }
    public static String[] subArray(String[] array,int start,int end){
        String[] result=new String[end-start];
        for(int i=start;i<end;i++){
            result[i-start]=array[i];
        }
        return result;
    }
}
