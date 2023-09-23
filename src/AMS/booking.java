package AMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOKING PANEL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(248, 57, 130, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(94, 130, 101, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(94, 181, 101, 16);
		contentPane.add(lblNewLabel_2);
		
		String[] genders = {"Male","Female"};
		final JComboBox gender = new JComboBox(genders);
		gender.setBounds(436, 228, 65, 21);
		contentPane.add(gender);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(94, 231, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter contact details");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(94, 278, 122, 13);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(423, 130, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(423, 181, 96, 19);
		contentPane.add(age);
		age.setColumns(10);
		
		contact = new JTextField();
		contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
				String num = contact.getText().toString();
				if(num.length()>=10) {
					e.consume();
				}
			}
			
		});
		contact.setBounds(423, 276, 96, 19);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_name = name.getText().toString();
				String user_age = age.getText().toString();
				String user_gender = (String)gender.getSelectedItem();
				String user_number = contact.getText().toString();
				try {
					main.booking.book_flight(user_name, user_age, user_gender, user_number,"C:/Users/prem/Desktop/myprojects/fs/FS AMS/bookings.txt");
					dispose();
					aupage uh = new aupage();
					uh.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(272, 328, 85, 21);
		contentPane.add(btnNewButton);
	}
}
