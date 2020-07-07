package ConcurrencyControl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener{
	//���һ����ʾ��ǩ ����� �����ʾ��
	private JPanel p1 = new JPanel();
	
	//��ʾ��ǩ
	private JLabel la1=new JLabel("��һ��");
	private JLabel la2=new JLabel("�ڶ���");
	private JLabel la3=new JLabel("������");
	//�����
	private JTextField tf1=new  JTextField();
	private JTextField tf2=new  JTextField();
	private JTextField tf3=new  JTextField();
	//�����ʾ��
	private JLabel result1 = new JLabel();
	private JLabel result2 = new JLabel();
	private JLabel result3 = new JLabel(); 
	
	//�ܽ����ʾ
	private JLabel result = new JLabel();
	
	//��������ťѡ���� 
	private JPanel p2 = new JPanel();
	
	//ȷ���������ť
	private JButton ok=new JButton("ȷ��");
	private JButton clear=new JButton("���");
	private JLabel la4=new JLabel("��ѡ��ʵ�ַ�ʽ��");
	//����ʵ�ַ�ʽѡ��ť
	private ButtonGroup grp=new ButtonGroup();
	private JRadioButton bsem=new JRadioButton("semaphore");
	private JRadioButton bwn=new JRadioButton("wait��notify");
		
	public MainFrame(){
		super("��������ʵ��");
	    //��ѡ��ť�����
		grp.add(bsem);grp.add(bwn);
		//Ϊ��ǩ���þ�����ʾ
		la1.setHorizontalAlignment(JLabel.CENTER);
		la2.setHorizontalAlignment(JLabel.CENTER);
		la3.setHorizontalAlignment(JLabel.CENTER);
		result.setHorizontalAlignment(JLabel.CENTER);
		result1.setHorizontalAlignment(JLabel.CENTER);
		result2.setHorizontalAlignment(JLabel.CENTER);
		result3.setHorizontalAlignment(JLabel.CENTER);
		
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 46);
        result.setFont(font1);
        
        //��ӱ�ǩ�߿�
		result1.setBorder(BorderFactory.createEtchedBorder());
		result2.setBorder(BorderFactory.createEtchedBorder());
		result3.setBorder(BorderFactory.createEtchedBorder());
		result.setBorder(BorderFactory.createEtchedBorder());
		
		//����
		GridLayout grid1=new GridLayout(3,3);
		p1.setLayout(grid1);
		p1.add(la1);p1.add(la2);p1.add(la3);
		p1.add(tf1);p1.add(tf2);p1.add(tf3);
		p1.add(result1);p1.add(result2);p1.add(result3);
		this.add(p1);
		
		GridLayout grid2=new GridLayout(5,1);
		p2.setLayout(grid2);
		p2.add(ok);
		p2.add(clear);
		p2.add(la4);
		p2.add(bsem);
		p2.add(bwn);
		
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(result,BorderLayout.CENTER);
		this.getContentPane().add(p2,BorderLayout.EAST);
		
		//ע�������
		ok.addActionListener(this);
		clear.addActionListener(this);
		
		bsem.setActionCommand("sem");
		bwn.setActionCommand("bwn");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(520,230);
	}
	
	//��������
	public void clearInput() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	//��������
	public void clearOutput() {
		result1.setText("");
		result2.setText("");
		result3.setText("");
		result.setText("");
	}
	
	//�¼�����
	public void actionPerformed(ActionEvent e) {
		JButton jbt=(JButton)e.getSource();
		//�������ȷ����
		if(jbt==ok) {
			clearOutput();
            String str1=tf1.getText().trim();
    		String str2=tf2.getText().trim();
    		String str3=tf3.getText().trim();
    		//δѡ��ʵ�ַ�ʽ�ĵ�����ʾ
    		if(str1.equals("")|str2.equals("")|str3.equals("")) {
    			JOptionPane.showMessageDialog(null,"��������������");
    			}
    		
    		String choose=grp.getSelection().getActionCommand();
    		//�ź�����ʽ
    		if(choose.equals("sem")) {
    			new SemaphoreControllThread(str1,str2,str3,result1,result2,result3,result).start();
    		}
    		//˯�߻��ѷ�ʽ
    		else if (choose.equals("bwn")) {
    			new SynchronizedControllThread(str1,str2,str3,result1,result2,result3,result).start();
    		}

		}	
		
		//�������գ��������������
		else if(jbt==clear) {
			clearInput();
			clearOutput();
		}
	}
}

