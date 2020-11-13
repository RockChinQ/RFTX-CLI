package cmd;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.rftx.core.RFTXHost;
import com.rftx.util.Debugger;

import listener.*;

public class CLIMain {
    public final static String VERSION_STRING="20201103";
    public final static String RFTX_VERSION="v0.1-alpha";
    public static CLIProcessor processor=new CLIProcessor();
    public static Commands cmdThr=new Commands();

    public static RFTXHost host=new RFTXHost("localhost");

    public static ServerConn serverConn=new ServerConn();
    public static ClientConn clientConn=new ClientConn();
    public static void main(String[] args) throws Exception{
        // Debugger.debug=true;
        Out.sayln( "Rock's File Transfer eXtended lib-Command Line Interface\n");
        processor.run("ver");
        Out.sayln( "https://github.com/RockChinQ/RFTX2\n");
        host.initClient();
        host.client.setClientConnListener(clientConn);
        cmdThr.start();
    }
    public static String getErrorInfo(Exception e){
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString().replaceAll("\t","    ");
    }
}
