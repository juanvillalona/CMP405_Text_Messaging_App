import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Driver {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("James/Yunaelin/Fayra");
		frame.setSize(250, 250);
		frame.setLocation(300, 300);
		final JTextArea textArea = new JTextArea(10,40);
		frame.getContentPane().add(BorderLayout.CENTER, textArea);
		
		frame.setVisible(true);
		
		
		Socket socket = new Socket(64000);
		
		InetAddress myAddress = null;
		//byte[] teacherAddress = new byte[]{192, 168, 1, 115};
		//InetAddress teacherAddress = null;
//		try {
//			//teacherAddress = InetAddress.getByName("192.168.1.115");
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
		
		try {
			myAddress = InetAddress.getLocalHost();
			System.out.println(myAddress);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		socket.send("Hello!", myAddress, 64000);
		socket.send("How Are You?", myAddress, 64000);
		socket.send("I am having fun writing code", myAddress, 64000);
		socket.send("What are you doing?", myAddress, 64000);
		socket.send("Are you having fun?", myAddress, 64000);
		socket.send("im good", myAddress, 64000);
		
		//socket.send("juanV says OLA!", teacherAddress, 64000);
		//System.out.println(teacherAddress);
		try {
			System.out.println("Main is sleeping");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Main woke up");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} 
		
		DatagramPacket packet;
		
		do {
			packet = socket.receive();
			if (packet != null) {
				String message = new String(packet.getData());
				textArea.append("Message = " + message + "\n");
			}
		} while(packet != null);
		
		System.out.println("That's it folks!");
	}

}
