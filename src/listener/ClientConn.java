package listener;

import com.rftx.conn.ControlConn;
import com.rftx.listener.ClientConnListener;

import cmd.Out;

public class ClientConn implements ClientConnListener {

    @Override
    public void authenticated(ControlConn arg0) {
        // TODO Auto-generated method stub
        Out.saySub("NOTI", "conn to server:"+arg0.peerName+" is authenticated.");
    }

    @Override
    public void connected(ControlConn arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void disconnected(ControlConn arg0) {
        // TODO Auto-generated method stub
        Out.saySub("NOTI", "server:"+arg0.peerName+" is disconnected.");
    }
    
}
