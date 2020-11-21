package cmd.funcs;

import com.rftx.conn.ControlConn;
import com.rftx.conn.DefaultConn;
import com.rftx.conn.TransportConn;

import cmd.AbstractFunc;
import cmd.AbstractProcessor;
import cmd.CLIMain;
import cmd.Out;

public class FuncConn implements AbstractFunc {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFuncName() {
        // TODO Auto-generated method stub
        return "conn";
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
            case "ls":{
                Out.sayThisLine("list all connections:c:"+CLIMain.host.controlConns.size()+" t:"+CLIMain.host.transportConns.size()+" d:"+CLIMain.host.defaultConns.size()+"\n");
                Out.sayThisLine("CID\tname       \ttoken\tip:port               \ttype\tidentity\n");
                synchronized(CLIMain.host.controlConns){
                    for(ControlConn conn:CLIMain.host.controlConns){
                        Out.sayThisLine(conn.cid+"\t"+conn.peerName+"\t"
                        +(conn.token.equals("")?"_____":conn.token)+"\t"
                        +CLIMain.limitStrLen(conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort(), 23)
                        +"\tControl  \t"+(conn.identity==ControlConn.SERVER?"SERVER":"CLIENT")
                        +"\n");
                    }
                }
                
                synchronized(CLIMain.host.transportConns){
                    for(TransportConn conn:CLIMain.host.transportConns){
                        Out.sayThisLine(conn.cid+"\t"+"_____\t"
                        +conn.info.taskToken+"\t"
                        +CLIMain.limitStrLen(conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort(), 23)
                        +"\tTransport\t"+(conn.identity==TransportConn.RECEIVER?"RECV":"SEND")
                        +"\n");
                    }
                }
                synchronized(CLIMain.host.defaultConns){
                    for(DefaultConn conn:CLIMain.host.defaultConns){
                        Out.sayThisLine(conn.cid+"\t"+"_____\n"
                        +"_____\t"
                        +CLIMain.limitStrLen(conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort(), 23)
                        +"\tUnknown\t"+"_____"
                        +"\n");
                    }
                }
                Out.sayln("done.");
                break;
            }
            case "kill":{
                int connToKill=0;
                try{
                    connToKill=Integer.parseInt(arg0[1]);
                    synchronized(CLIMain.host.controlConns){
                        for(ControlConn conn:CLIMain.host.controlConns){
                            if(conn.cid==connToKill){
                                conn.dispose();
                                CLIMain.host.controlConns.remove(conn);
                                Out.sayThisLine("dispose control conn:\n");
                                Out.sayThisLine(conn.cid+"\t"+conn.peerName+"\t"
                                +(conn.token.equals("")?"_____":conn.token)+"\t"
                                +conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort()
                                +"\tControl\t"+(conn.identity==ControlConn.SERVER?"SERVER":"CLIENT")
                                +"\n");
                                connToKill=-1;
                                break;
                            }
                        }
                    }
                    synchronized(CLIMain.host.transportConns){
                        for(TransportConn conn:CLIMain.host.transportConns){
                            if(connToKill==-1)
                                break;
                            if(connToKill==conn.cid){
                                conn.dispose();
                                CLIMain.host.transportConns.remove(conn);
                                Out.sayThisLine("dispose transport conn:\n");
                                Out.sayThisLine(conn.cid+"\t"+"_____\t"
                                    +conn.info.taskToken+"\t"
                                    +conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort()
                                    +"\tTransport\t"+(conn.identity==TransportConn.RECEIVER?"RECV":"SEND")
                                    +"\n");
                                connToKill=-1;
                                break;
                            }
                        }
                    }
                    synchronized(CLIMain.host.defaultConns){
                        for(DefaultConn conn:CLIMain.host.defaultConns){
                            if(connToKill==-1)
                                break;
                            if(connToKill==conn.cid){
                                conn.dispose();
                                CLIMain.host.defaultConns.remove(conn);
                                Out.sayThisLine("kill unknown conn:\n");
                                Out.sayThisLine(conn.cid+"\t"+"_____\n"
                                +"_____\t"
                                +conn.getSocket().getInetAddress()+":"+conn.getSocket().getPort()
                                +"\tUnknown\t"+"_____"
                                +"\n");
                                connToKill=-1;
                                break;
                            }
                        }
                    }
                    if(connToKill==-1){
                        Out.sayln("done.                 ");
                    }else{
                        Out.sayln("no such conn.   ");
                    }
                }catch(Exception e){
                    Out.sayln("failed to kill conn.\n"+CLIMain.getErrorInfo(e));
                }
                break;
            }
        }
    }
    
}
