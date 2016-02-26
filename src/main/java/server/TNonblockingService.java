package server;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import impl.Hello;
import impl.HelloServiceImpl;
public class TNonblockingService {
	/*
	 * ʹ�÷�������ʽ������Ĵ�С���д��䣬������ Java �е� NIO
	 */
	public static void main(String[] args) { 
       try { 
    	   TNonblockingServerTransport serverTransport; 
    	   serverTransport = new TNonblockingServerSocket(10005); 
    	   Hello.Processor processor = new Hello.Processor(new HelloServiceImpl()); 
    	   TServer server = new TNonblockingServer(new Args(serverTransport).processor(processor)); 
    	   System.out.println("Start server on port 10005 ..."); 
    	   server.serve();
	   } catch (TTransportException e) { 
	       e.printStackTrace(); 
	   } 
	}
}
