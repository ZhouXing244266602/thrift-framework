package server;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.server.TServer.Args;
import impl.Hello;
import impl.HelloServiceImpl;
public class TSimpleService {
	/*
	 * ���̷߳�������ʹ�ñ�׼������ʽ I/O
	 */
	public static void main(String[] args) {
		try {
			TServerSocket serverTransport = new TServerSocket(7911);
			TProcessor processor = new Hello.Processor(new HelloServiceImpl()); 
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor)); 
			System.out.println("Start server on port 7911..."); 
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		} 		
	}
}
