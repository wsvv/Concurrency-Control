package ConcurrencyControl;

import java.util.concurrent.Semaphore;
import javax.swing.*;

public class SemaphorePrintThread extends Thread {
	
	private String str;
	private JLabel result;
	private Semaphore sem;
	
	SemaphorePrintThread(String str,JLabel result,Semaphore sem){
		this.str=str;
		this.result=result;
		this.sem=sem;
		}
	
	public void run() {
		try {
			Thread.sleep((long)(Math.random()*10000+1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		result.setText(str);
		sem.release();

}
}
