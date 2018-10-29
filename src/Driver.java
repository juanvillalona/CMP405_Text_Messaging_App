import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Driver {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("James/Yunaelin/Fayra");
		frame.setLayout(new GridLayout(0,1));
		frame.setSize(700, 500);
		frame.setLocation(300, 300);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JPanel mPanel = new JPanel();
		mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
		mPanel.setSize(200,200);
		
		final String title = "Messaging Title";
		TitledBorder border = new TitledBorder(title);
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitlePosition(TitledBorder.TOP);
		mPanel.setBorder(border);
		
		mPanel.setForeground(Color.PINK);
		
		JLabel mLabel = new JLabel("Your text here");
		mLabel.setText("<html>" + mLabel.getText() + "<br/> fefeff</html>");
		
		mPanel.add(mLabel);
		
		
//		JLabel messagesLabel = new JLabel();
//		messagesLabel.setForeground(new Color(50, 50, 25));
//		messagesLabel.setBackground(Color.white);
//		messagesLabel.setOpaque(true);
//		
//		
//		//messagesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		//messagesLabel.setLocation(1,1);
//		
//		
//		messagesLabel.setText("hFEDFQWEFEQWFEWFWFWEFWEFWEFWEF");
//		
//		messagesPanel.add(messagesLabel, BorderLayout.CENTER);
//		messagesPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		
		frame.add(mPanel);
		
		JPanel tPanel = new JPanel();
		JTextArea textArea = new JTextArea(10, 60);
		tPanel.add(textArea);
		
		frame.add(tPanel);		
		
		
		JPanel btnPanel = new JPanel();
		JButton send = new JButton("Send");
		JButton cancel = new JButton("Cancel");
		
		btnPanel.add(send);
		btnPanel.add(cancel);

		
		frame.add(btnPanel);
		
		
//		final JTextArea textArea = new JTextArea(10,40);
//		frame.getContentPane().add(BorderLayout.SOUTH, textArea);
		
		frame.setVisible(true);
		
//		
//		//Socket socket = new Socket(64000);
//		
//		InetAddress myAddress = null;
//		//byte[] teacherAddress = new byte[]{192, 168, 1, 115};
//		//InetAddress teacherAddress = null;
////		try {
////			//teacherAddress = InetAddress.getByName("192.168.1.115");
////		} catch (UnknownHostException e1) {
////			e1.printStackTrace();
////		}
//		
//		try {
//			myAddress = InetAddress.getLocalHost();
//			System.out.println(myAddress);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//		socket.send("Hello!", myAddress, 64000);
//		socket.send("How Are You?", myAddress, 64000);
//		socket.send("I am having fun writing code", myAddress, 64000);
//		socket.send("What are you doing?", myAddress, 64000);
//		socket.send("Are you having fun?", myAddress, 64000);
//		socket.send("im good", myAddress, 64000);
//		
//		//socket.send("juanV says OLA!", teacherAddress, 64000);
//		//System.out.println(teacherAddress);
//		try {
//			System.out.println("Main is sleeping");
//			TimeUnit.SECONDS.sleep(5);
//			System.out.println("Main woke up");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		} 
//		
//		DatagramPacket packet;
//		
//		do {
//			packet = socket.receive();
//			if (packet != null) {
//				String message = new String(packet.getData());
//				//textArea.append("Message = " + message + "\n");
//			}
//		} while(packet != null);
//		
//		System.out.println("That's it folks!");
//	}

}
}
