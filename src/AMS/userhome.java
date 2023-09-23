package AMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class userhome extends JFrame {

	private JPanel contentPane;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userhome frame = new userhome();
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
	public userhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME USER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(322, 34, 170, 34);
		contentPane.add(lblNewLabel);
		search = new JTextField();
		search.setBounds(313, 258, 96, 19);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Book Flight");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String flightcode = search.getText().toString();
				try {
					String data = main.ad.search(flightcode, "C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
					if(!data.equals("rf")) {
						String[] result = data.split("\\|");
						String searched_data="Flight code : "+result[0]+"\nSource : "+result[1]+"\nDestination : "+result[2]
						+"\nArrivaltime :" +result[3]+"\nDeparturetime : "+result[4]+"\nFare :"+result[5];
						JOptionPane.showMessageDialog(search, searched_data, "Proceed For Booking", getDefaultCloseOperation());
						dispose();
						booking b = new booking();
						b.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(search, "Flight not Found","", getDefaultCloseOperation());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(449, 255, 170, 20);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the flight code to Book");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(112, 259, 190, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnViewAllFlights = new JButton("View All Flights");
		btnViewAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View_for_user vfu = new View_for_user();
				vfu.setVisible(true);
			}
		});
		btnViewAllFlights.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewAllFlights.setBounds(449, 155, 170, 20);
		contentPane.add(btnViewAllFlights);

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
	}

}
