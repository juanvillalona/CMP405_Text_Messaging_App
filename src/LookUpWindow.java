import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.glass.events.WindowEvent;

import javafx.scene.layout.Border;



public class LookUpWindow {
	
	static LinkedList <MessageWindow> windows = new LinkedList<MessageWindow>();

	JFrame frame;
	JPanel mPanel, tPanel, btnPanel;
	JLabel mLabel;
	Button send1, cancel;
	JTextArea textArea;
	Socket socket;
	
	String IP, port;
	
	public LookUpWindow(Socket socket) {
		this.socket = socket;

//		frame = new JFrame();
//		frame.setLayout(new GridLayout(0,1));
//		frame.setSize(700, 500);
//		frame.setLocation(300, 300);
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		
//		mPanel = new JPanel();
//		mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
//		mPanel.setSize(200,200);
//		
//	
//		
//		mPanel.setForeground(Color.PINK);
//		
//		mLabel = new JLabel();
//		
//		mPanel.add(mLabel);
//		
//		
////		JLabel messagesLabel = new JLabel();
////		messagesLabel.setForeground(new Color(50, 50, 25));
////		messagesLabel.setBackground(Color.white);
////		messagesLabel.setOpaque(true);
//	//	
//	//	
////		//messagesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
////		//messagesLabel.setLocation(1,1);
//	//	
//	//	
////		messagesLabel.setText("hFEDFQWEFEQWFEWFWFWEFWEFWEFWEF");
//	//	
////		messagesPanel.add(messagesLabel, BorderLayout.CENTER);
////		messagesPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//	//	
//		frame.add(mPanel);
//		
//		tPanel = new JPanel();
//		textArea = new JTextArea(10, 50);
//		tPanel.add(textArea);
//		
//		frame.add(tPanel);		
//		
//		
//		btnPanel = new JPanel();
//		Button send = new Button("Send");
//		Button close = new Button("Cancel");
//		
//		send.addActionListener(new java.awt.event.ActionListener () {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				
//				
//					
//					InetAddress myAddress = null;
//					InetAddress teacherAddress = null;
//				try {
//						teacherAddress = InetAddress.getByName("192.168.1.101");
//				} catch (UnknownHostException e1) {
//					e1.printStackTrace();
//				}
//					
//					
//					try {
//						myAddress = InetAddress.getLocalHost();
//						//System.out.println(myAddress);
//					} catch (Exception e) {
//						e.printStackTrace();
//						System.exit(-1);
//					}
//					
//					
//
//					
//				
//			}
//		}); 
//
//		
//		close.addActionListener(new java.awt.event.ActionListener () {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				System.exit(0);
//			}
//		});
//			
//		
//		btnPanel.add(send);
//		btnPanel.add(close);
//
//		
//		frame.add(btnPanel);
//		
//		frame.setVisible(true);
		Frame frm=new Frame("DataEntry frame");
		  Label lbl = new Label("Please fill this blank:");
		  frm.add(lbl);
		  frm.setSize(500,200);
		  frm.setVisible(true);
		  frm.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent e){
		  System.exit(0);
		  }
		  });
		  Panel p = new Panel();
		  Panel p1 = new Panel();
		  Label jIP = new Label("IP");
		  TextField lFirstName = new TextField(20);
		  Label jPort =new Label("Port");
		  TextField lLastName=new TextField(20);
		  p.setLayout(new GridLayout(3,1));
		  p.add(jIP);
		  p.add(lFirstName);
		  p.add(jPort);
		  p.add(lLastName);
		  Button Submit=new Button("Submit");
		  Submit.addActionListener(new java.awt.event.ActionListener () {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
				IP = lFirstName.getText().toString();
				port = lLastName.getText().toString();
				
				InetAddress IPA = null;
				InetAddress Port = null;
				try {
					IPA = InetAddress.getByName(IP);
					Port = InetAddress.getByName(port);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				
			
					try {
						MessageWindow a = new MessageWindow(IPA, Port,  socket, true);
						a.initializeWindow();
						windows.add(a);
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
				
				}
		  });
				
		  p.add(Submit);
		  p1.add(p);
		  frm.add(p1,BorderLayout.NORTH);
		  
	
	}
	
	public String getIP() {
		return IP;
	}
	
	public String getPort() {
		return port;
	}
	
	public LinkedList<MessageWindow> getWindows() {
		return windows;
	}
	
}
