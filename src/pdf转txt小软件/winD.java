package pdfתtxtС���;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class winD extends JFrame{//������
	
	private JFileChooser fileChooser = new JFileChooser();
	
	void win (String s, int x, int y, int w, int h) {
        JFrame jf=new JFrame(s);
		jf.setLocation(x,y);
		jf.setSize(w,h);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p=new JPanel();
		jf.setContentPane(p);
		
		JLabel l=new JLabel("����pdf��ַ(����·��)��");
		TextField tf1 = new TextField("              .pdf");
		JLabel l2=new JLabel("����txt�ļ������ַ������·������");
		TextField tf2 = new TextField("              .txt");
		JButton button1 = new JButton("ѡ��");
		JButton button2 = new JButton("Ĭ��");
		JButton button3 = new JButton("ת��");
	
		
		p.add(l);
		p.add(tf1);
		p.add(button1);
		p.add(l2);
		p.add(tf2);
		p.add(button2);
		p.add(button3);

		
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���
				
				// �ж��û��������Ƿ�Ϊ���򿪡���ť
				if (i == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = fileChooser.getSelectedFile();// ���ѡ�е��ļ�����
					tf1.setText(selectedFile.getPath());// ��ʾѡ���ļ�������
				}
			
			}
			
			
		});

		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				String ss=tf1.getText().trim();
				ss=ss.substring(0,ss.length()-3);
					tf2.setText(ss+"txt");// ��ʾѡ���ļ�������
				

			
			}
			
			
		});

		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String s1=tf1.getText().trim();
				String s2=tf2.getText().trim();
				System.out.print(s1);
				winD wind=new winD();
				wind.pdftxt(s1,s2);
			
			}
			
			
		});
		
		
	}
	
	
	void pdftxt(String s1, String s2)
	{//pdfתtxt�ĺ���
		PDDocument helloDocument = null;
		try {
			helloDocument = PDDocument.load(new File(s1));
			PDFTextStripper textStripper = new PDFTextStripper();
		
			String s="";
			String[] strs = textStripper.getText(helloDocument).split("\r\n");//���ж�������
			
			for(int i=0;i<=strs.length-1;i++)
				s=s+"\n"+strs[i];
			
			helloDocument.close();
			
			
			
			File file = new File(s2);//д��txt�ļ�
			
			FileWriter fw;
			
				fw = new FileWriter(file);
				fw.write(s);
				fw.flush();
				fw.close();
			
			
			helloDocument.close();
			JOptionPane.showMessageDialog(null,"ת���ɹ�","�ɹ��������ظ�����",JOptionPane.PLAIN_MESSAGE);
		} 

		catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "����", "��ַ���ʽ����", JOptionPane.ERROR_MESSAGE);
			
			
		}
		
		
		
	}
	
	
	
	
	

}
