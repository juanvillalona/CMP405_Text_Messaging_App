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
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
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

	private static LinkedList<InetAddress> addresses = new LinkedList<InetAddress>();
	private static LinkedList<messageWindow> windows = new LinkedList<messageWindow>();
	
//	public void sendMessage(messageWindow m, String message) {
//		Socket socket = new Socket(64000);
//		
//		InetAddress myAddress = null;
//		InetAddress teacherAddress = null;
//		try {
//			teacherAddress = InetAddress.getByName("196.168.1.10");
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			myAddress = InetAddress.getLocalHost();
//			//System.out.println(myAddress);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//		socket.send(message, teacherAddress, 64000);
//		
//		m.writeMessage(true, false, message);
//
//		
//	}
//	
	public static void getMessage(messageWindow m, String message) {
		m.writeMessage(false, true, message);
	}
	
	public static void main(String[] args) {
		
		InetAddress myAddress = null;
		try {
			myAddress = InetAddress.getLocalHost();
			//System.out.println(myAddress);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		messageWindow c1 = new messageWindow(myAddress, myAddress, true);
		c1.initializeWindow();
		
		//messageWindow c1 = new messageWindow(teacherAddress, "hello", false);
		//c1.initializeWindow();
		
		
		Socket socket = new Socket(64000);

//		InetAddress myAddress = null;
//		//byte[] teacherAddress = new byte[]{192, 168, 1, 115};
//		InetAddress teacherAddress = null;
//		InetAddress anotherAddress = null;
//		try {
//			teacherAddress = InetAddress.getByName("192.168.1.115");
//			anotherAddress = InetAddress.getByName("201.252.12.11");
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			myAddress = InetAddress.getLocalHost();
//			System.out.println(myAddress);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//	socket.send("Hello!", myAddress, 64000);
//		socket.send("How Are You?", myAddress, 64000);
//		socket.send("I am having fun writing code", myAddress, 64000);
//		socket.send("What are you doing?", myAddress, 64000);
//		socket.send("Are you having fun?", myAddress, 64000);
//		socket.send("im good", myAddress, 64000);
//		
//		//socket.send("juanV says OLA!", teacherAddress, 64000);
//		//System.out.println(teacherAddress);
	try {
		System.out.println("Main is sleeping");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Main woke up");
		} catch (Exception e) {
		e.printStackTrace();
			System.exit(-1);
		}
	
	System.out.println("my address is: " + myAddress.getHostAddress() );

		
//		addresses.add(teacherAddress);
//		addresses.add(myAddress);
//		addresses.add(anotherAddress);
//
//		
		DatagramPacket packet;

		
		do {
			packet = socket.receive();
			if (packet != null) {
				
				String message = new String(packet.getData());
				
				getMessage(c1, message);
			}
				
			
					
				
				
			
		}while(packet != null);
		
		System.out.println("That's it folks!");
	

}
}





