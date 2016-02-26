package server;
import org.apache.thrift.TProcessor; 
import org.apache.thrift.protocol.TBinaryProtocol; 
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer; 
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket; 
import org.apache.thrift.transport.TTransportException;
import impl.Hello;
import impl.HelloServiceImpl; 
public class TThreadPoolService { 
   /**
    * ���̷߳�������ʹ�ñ�׼������ʽ I/O
    * @param args
    */
   public static void main(String[] args) { 
       try { 
           // ���÷���˿�Ϊ 7911 
           TServerSocket serverTransport = new TServerSocket(7911); 
           // ����Э�鹤��Ϊ TBinaryProtocol.Factory 
           Factory proFactory = new TBinaryProtocol.Factory();  
/*			ʹ�� TCompactProtocol Э�鹹���� HelloServiceServer.java
           TCompactProtocol.Factory proFactory = new TCompactProtocol.Factory();
         	ʹ�� TJSONProtocol Э�鹹���� HelloServiceServer.java
        	TJSONProtocol.Factory proFactory = new TJSONProtocol.Factory();
         	ʹ�� TJSONProtocol Э��� HelloServiceClient.java
         	TJSONProtocol protocol = new TJSONProtocol(transport);
			ʹ�� TCompactProtocol Э��� HelloServiceClient.java
			TCompactProtocol protocol = new TCompactProtocol(transport);*/
           // ������������ Hello �����ʵ��      
           TProcessor processor = new Hello.Processor(new HelloServiceImpl()); 
           TServer server = new TThreadPoolServer(new Args(serverTransport).processor(processor)); 
           System.out.println("Start server on port 7911..."); 
           server.serve(); 
       } catch (TTransportException e) { 
           e.printStackTrace(); 
       } 
   } 
}
