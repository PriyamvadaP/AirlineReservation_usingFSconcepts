package AMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class adminhome extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTextField delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminhome frame = new adminhome();
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
	public adminhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Flight");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flightadd fa=new Flightadd();
				fa.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(101, 113, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Flights");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFlight vf=new ViewFlight();
				vf.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(316, 112, 136, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search Flight");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String flightcode = search.getText().toString();
				try {
					String data = main.ad.search(flightcode, "C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
					if(!data.equals("rf")) {
						String[] result = data.split("\\|");
						String searched_data="Flight code : "+result[0]+"\nSource : "+result[1]+"\nDestination : "+result[2]
						+"\nArrivaltime :" +result[3]+"\nDeparturetime : "+result[4]+"\nFare :"+result[5];
						JOptionPane.showMessageDialog(search, searched_data, "RESULT", getDefaultCloseOperation());
					}else {
						JOptionPane.showMessageDialog(search, "Flight not Found","", getDefaultCloseOperation());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(469, 256, 131, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnDeleteFlight = new JButton("Delete Flight");
		btnDeleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = delete.getText().toString();
				try {
					String data = main.ad.remove(key,"C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
					if(!data.equals("rf")) {
						String[] result = data.split("\\|");
						String searched_data="Flight code : "+key+"\nSource : "+result[1]+"\nDestination : "+result[2]
						+"\nArrivaltime :" +result[3]+"\nDeparturetime : "+result[4]+"\nFare :"+result[5];
						JOptionPane.showMessageDialog(delete, searched_data, "DELETED RECORD", getDefaultCloseOperation());
					}else {
						JOptionPane.showMessageDialog(delete, "Flight not Found","", getDefaultCloseOperation());
					}
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnDeleteFlight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteFlight.setBounds(478, 337, 111, 21);
		contentPane.add(btnDeleteFlight);
		
		JButton btnViewAllBookings = new JButton("View All Bookings");
		btnViewAllBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				all_bookings abd = new all_bookings();
				abd.setVisible(true);
			}
		});
		btnViewAllBookings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewAllBookings.setBounds(522, 113, 121, 21);
		contentPane.add(btnViewAllBookings);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				aupage au=new aupage();
				au.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(623, 370, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(260, 31, 205, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the flight code to search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(112, 259, 190, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter the flight code to delete");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(112, 340, 190, 15);
		contentPane.add(lblNewLabel_1_1);
		
		search = new JTextField();
		search.setBounds(341, 258, 96, 19);
		contentPane.add(search);
		search.setColumns(10);
		
		delete = new JTextField();
		delete.setBounds(341, 339, 96, 19);
		contentPane.add(delete);
		delete.setColumns(10);
	
	}
}
