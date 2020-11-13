package listener;

import com.rftx.conn.ControlConn;
import com.rftx.listener.ServerConnListener;

import cmd.Out;

public class ServerConn implements ServerConnListener {

    @Override
    public void authenticated(ControlConn arg0) {
        // TODO Auto-generated method stub
        Out.saySub("NOTI", arg0.peerName+" conn authenticated.");
    }

    @Override
    public void connected(ControlConn arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void disconnected(ControlConn arg0) {
        // TODO Auto-generated method stub
        Out.saySub("NOTI", arg0.peerName+" conn disconnected.");

    }
    
}
