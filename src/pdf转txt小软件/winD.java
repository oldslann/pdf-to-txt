package pdf转txt小软件;

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

public class winD extends JFrame{//窗口类
	
	private JFileChooser fileChooser = new JFileChooser();
	
	void win (String s, int x, int y, int w, int h) {
        JFrame jf=new JFrame(s);
		jf.setLocation(x,y);
		jf.setSize(w,h);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p=new JPanel();
		jf.setContentPane(p);
		
		JLabel l=new JLabel("输入pdf地址(绝对路径)：");
		TextField tf1 = new TextField("              .pdf");
		JLabel l2=new JLabel("输入txt文件保存地址（绝对路径）：");
		TextField tf2 = new TextField("              .txt");
		JButton button1 = new JButton("选择");
		JButton button2 = new JButton("默认");
		JButton button3 = new JButton("转化");
	
		
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
				
				int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框
				
				// 判断用户单击的是否为“打开”按钮
				if (i == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = fileChooser.getSelectedFile();// 获得选中的文件对象
					tf1.setText(selectedFile.getPath());// 显示选中文件的名称
				}
			
			}
			
			
		});

		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				String ss=tf1.getText().trim();
				ss=ss.substring(0,ss.length()-3);
					tf2.setText(ss+"txt");// 显示选中文件的名称
				

			
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
	{//pdf转txt的函数
		PDDocument helloDocument = null;
		try {
			helloDocument = PDDocument.load(new File(s1));
			PDFTextStripper textStripper = new PDFTextStripper();
		
			String s="";
			String[] strs = textStripper.getText(helloDocument).split("\r\n");//逐行读入数据
			
			for(int i=0;i<=strs.length-1;i++)
				s=s+"\n"+strs[i];
			
			helloDocument.close();
			
			
			
			File file = new File(s2);//写入txt文件
			
			FileWriter fw;
			
				fw = new FileWriter(file);
				fw.write(s);
				fw.flush();
				fw.close();
			
			
			helloDocument.close();
			JOptionPane.showMessageDialog(null,"转化成功","成功，请勿重复创建",JOptionPane.PLAIN_MESSAGE);
		} 

		catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "出错", "地址或格式有误", JOptionPane.ERROR_MESSAGE);
			
			
		}
		
		
		
	}
	
	
	
	
	

}
