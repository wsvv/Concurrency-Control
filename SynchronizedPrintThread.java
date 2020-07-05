package ConcurrencyControl;

import javax.swing.*;

public class SynchronizedPrintThread extends Thread{
    private String str;     //�����ı�
    private JLabel result;      //�ı������
    static private Object lock;     //lock����

    SynchronizedPrintThread(String str,JLabel result,Object lock){
        this.str=str;
        this.result=result;
        this.lock=lock;

    }

    
	public void run(){
        try{
            Thread.sleep((long)(Math.random()*10000+1000));     //�����ʱ1-10��
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                result.setText(str);        //�޸��ı��������
                synchronized (lock){
                    lock.notify();
                }
            }
    });
    }

}