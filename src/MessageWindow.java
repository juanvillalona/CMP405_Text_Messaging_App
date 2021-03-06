import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MessageWindow {
	
	JFrame frame;
	JPanel mPanel, tPanel, btnPanel;
	JLabel mLabel;
	Button send1, cancel;
	JTextArea textArea;
	
	String message;
	
	InetAddress IP, port;
	Socket socket;
	DatagramPacket packet;
	boolean active;
	
	public void writeMessage(boolean me, boolean them, String message) {
		if(me == true) {
			mLabel.setText(mLabel.getText() + "Me: " + message + "</br>");
		} else {
			mLabel.setText(mLabel.getText() + "Them: " + message + "</br>");
		}
	}
	
	public InetAddress getIPAddress() {
		return IP;
	}
	

	
	public MessageWindow(InetAddress IP,InetAddress port,Socket socket, boolean active) throws UnknownHostException {
		this.IP = IP;
		this.port = port;
		this.active = active;
		this.socket = socket;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void toggleActive() {
		if(active == true) {
			active = false;
		} else {
			active = true;
		}
	}
	
	public InetAddress getIP() {
		return IP;
	}
	
	public void initializeWindow(){
	 
	frame = new JFrame(IP.toString());
	frame.setLayout(new GridLayout(0,1));
	frame.setSize(700, 500);
	frame.setLocation(300, 300);
	JFrame.setDefaultLookAndFeelDecorated(true);
	
	mPanel = new JPanel();
	mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
	mPanel.setSize(200,200);
	
	final String title = IP.toString();
	TitledBorder border = new TitledBorder(title);
	border.setTitleJustification(TitledBorder.CENTER);
	border.setTitlePosition(TitledBorder.TOP);
	mPanel.setBorder(border);
	
	mPanel.setForeground(Color.PINK);
	
	mLabel = new JLabel();
	
	mPanel.add(mLabel);
	
	
//	JLabel messagesLabel = new JLabel();
//	messagesLabel.setForeground(new Color(50, 50, 25));
//	messagesLabel.setBackground(Color.white);
//	messagesLabel.setOpaque(true);
//	
//	
//	//messagesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//	//messagesLabel.setLocation(1,1);
//	
//	
//	messagesLabel.setText("hFEDFQWEFEQWFEWFWFWEFWEFWEFWEF");
//	
//	messagesPanel.add(messagesLabel, BorderLayout.CENTER);
//	messagesPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//	
	frame.add(mPanel);
	
	tPanel = new JPanel();
	textArea = new JTextArea(10, 50);
	tPanel.add(textArea);
	
	frame.add(tPanel);		
	
	
	btnPanel = new JPanel();
	Button send = new Button("Send");
	Button close = new Button("Cancel");
	
	send.addActionListener(new java.awt.event.ActionListener () {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			
			
				
				InetAddress myAddress = null;
				InetAddress teacherAddress = null;
			try {
					teacherAddress = InetAddress.getByName("192.168.1.101");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
				
				message = textArea.getText().toString();
				
				try {
					myAddress = InetAddress.getLocalHost();
					//System.out.println(myAddress);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(-1);
				}
				
				socket.send(message, IP, 64000);
				
				writeMessage(true, false, message);

				
			
		}
	}); 

	
	close.addActionListener(new java.awt.event.ActionListener () {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			active = false;
			System.exit(0);
		}
	});
		
	
	btnPanel.add(send);
	btnPanel.add(close);

	
	frame.add(btnPanel);
	
	frame.setVisible(true);
}
	
	
}

