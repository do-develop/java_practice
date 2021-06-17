package javafx_practice.callback;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DownloadUI implements ActionListener, Download.CallBack{
	
	JFrame frame;
	JButton button;
	public DownloadUI() {
	
		frame = new JFrame();
		frame.setTitle("Freezing UI Example");
		frame.setSize(300,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton();
		button.addActionListener(this);
		button.setText("Click to download some text");
		
		frame.add(button);
		frame.setVisible(true);
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Downloading...");
		new Thread(new Download(this)).start();
	}
	
	@Override
	public synchronized void iAmDone(String sender) {
		System.out.println("Entered: "+ sender);
		try { Thread.sleep(3000); } catch (Exception e) {};
		System.out.println("Exited: "+ sender);
	}
	
	public static void main(String[] args) {
		new DownloadUI();
	}

	

}