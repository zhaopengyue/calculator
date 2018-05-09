package four;

import javax.swing.*;

public class MyCalculator extends JFrame{
	
	private Administration administration;
	public MyCalculator(String title) {
		super(title);
		administration = new Administration();
		this.setSize(600, 430);
		this.setResizable(false);  
		this.setLayout(null);
		this.setBounds(0, 0, 600, 430);
		this.getContentPane().add(administration);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
