package callback;

import org.apache.thrift.async.AsyncMethodCallback;

public class MethodCallback implements AsyncMethodCallback { 
    Object response = null; 

    public Object getResult() { 
        // ���ؽ��ֵ
        return this.response; 
    } 

    // ������񷵻صĽ��ֵ
    public void onComplete(Object response) { 
        this.response = response; 
    } 

    // ������÷�������г��ֵ��쳣
	public void onError(Exception arg0) {
		// TODO Auto-generated method stub
	} 
}