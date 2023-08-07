package hey;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import javax.swing.JComboBox;

public class attendence1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendence1 frame = new attendence1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public attendence1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(46, 40, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject Teacher");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(46, 91, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(46, 146, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll no");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(46, 200, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Subject");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(341, 40, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(341, 91, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Year");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(341, 146, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(164, 37, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 197, 130, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(417, 88, 108, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		String[] values= {"Asmita Mam","Mandar sir","Ashwini mam","Nilima mam"};
		final JComboBox comboBox = new JComboBox(values);
		comboBox.setBounds(167, 87, 127, 22);
		contentPane.add(comboBox);
		
		String[] values1= {"Computer","IT","EXTC"};
		final JComboBox comboBox_1 = new JComboBox(values1);
		comboBox_1.setBounds(164, 142, 130, 22);
		contentPane.add(comboBox_1);
		
		String[] values2= {"DS","DSGT","DLCOA","CG","OOPM"};
		final JComboBox comboBox_2 = new JComboBox(values2);
		comboBox_2.setBounds(417, 36, 108, 22);
		contentPane.add(comboBox_2);
		
		String[] values3= {"FE","SE","TE","BE"};
		final JComboBox comboBox_3 = new JComboBox(values3);
		comboBox_3.setBounds(419, 142, 106, 22);
		contentPane.add(comboBox_3);

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"ATTENDENCE MARKED");
				
				String sname=textField.getText();
				String steacher=(String)comboBox.getSelectedItem();
				String branch=(String)comboBox_1.getSelectedItem();
				String rollno=textField_3.getText();
				String subject=(String)comboBox_2.getSelectedItem();
				String date=textField_5.getText();
				String year=(String)comboBox_3.getSelectedItem();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance1","root","");
					PreparedStatement ps=conn.prepareStatement("Insert into details(name, SubjectTeacher, Branch, Rollno,Subject, Date, Year) values(?,?,?,?,?,?,?)");
					ps.setString(1, sname);
					ps.setString(2, steacher);
					ps.setString(3, branch);
					ps.setString(4, rollno); 
					ps.setString(5, subject);
					ps.setString(6, date);
					ps.setString(7, year);
					
					int x =ps.executeUpdate();
					if(x > 0) {
						System.out.println("Attendence Marked");
						JOptionPane.showMessageDialog(null,"Attendence Marked");
					}else {
						System.out.println("Attendence not Marked...");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(256, 283, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
