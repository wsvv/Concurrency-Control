package ConcurrencyControl;

import java.util.concurrent.Semaphore;
import javax.swing.*;

public class SemaphorePrintThread extends Thread {
	
	private String str;		//�����ı�
	private JLabel result;	//�ı������
	private Semaphore sem; 		//�ź���
	
	SemaphorePrintThread(String str,JLabel result,Semaphore sem){
		this.str=str;
		this.result=result;
		this.sem=sem;
		}
	
	public void run() {
		try {
			Thread.sleep((long)(Math.random()*10000+1000));		//�����ʱ1-10��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//�������߳����޸�result��ֵ
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			result.setText(str);	//�޸��ı��������
			sem.release();
		}
	});
}
}
