package checkin.view.components;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckinForm {

	public JFrame frame;
	public JTextField textField;



	/**
	 * Create the application.
	 */
	public CheckinForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
