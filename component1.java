package hey;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.sql.*;

public class component1 {

	private JFrame frame,frame1;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					component1 window = new component1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public component1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 192));
		frame.setBounds(100, 100, 522, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(43, 59, 68, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(43, 158, 68, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 61, 153, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				//JOptionPane.showMessageDialog(null,"INVALID PASSWORD OR USERNAME");
		         String s=textField.getText();
		         String p=passwordField.getText();
		       
		         try {
		        	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
					 PreparedStatement ps=conn.prepareStatement("select * from student where name=? and pass=?");
					 ps.setString(1, s);
					 ps.setString(2,p);
					 ResultSet r=ps.executeQuery();
					 if(r.next())
					 {
						 attendence1 j=new attendence1();
						   j.setVisible(true);
					 }
					 else
					{
			        	JOptionPane.showMessageDialog(null,"INVALID PASSWORD OR USERNAME");	 
			        }
				
				     } catch (SQLException e1) {
					e1.printStackTrace();
				     }
				
				
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 13));
		btnNewButton.setBounds(266, 313, 91, 25);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 152, 153, 36);
		frame.getContentPane().add(passwordField);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}