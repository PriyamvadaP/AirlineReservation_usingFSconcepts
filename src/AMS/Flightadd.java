package AMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Flightadd extends JFrame {

	private JPanel contentPane;
	private JTextField flight_code;
	
	private JTextField arrival_time;
	private JTextField departure_time;
	private JTextField fare;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flightadd frame = new Flightadd();
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
	public Flightadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER FLIGHT DETAILS");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(136, 38, 312, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FLIGHT CODE");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(87, 112, 128, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SOURCE");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(87, 157, 95, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DESTINATION");
		lblNewLabel_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(87, 201, 111, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ARRIVAL TIME");
		lblNewLabel_1_3.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(87, 250, 128, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("DEPARTURE TIME");
		lblNewLabel_1_4.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(87, 294, 162, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("FARE");
		lblNewLabel_1_5.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(87, 344, 95, 16);
		contentPane.add(lblNewLabel_1_5);
		
		 flight_code= new JTextField();
		 flight_code.setBounds(316, 111, 130, 26);
		contentPane.add(flight_code);
		flight_code.setColumns(10);
		
	
			
		String[] doc_type_string = {"Chennai","Bangalore","Kochi","Hyderabad","Mumbai","Delhi","Vizag","Kolkata","Ahmedabad","Goa","Lucknow"};
		final JComboBox cb = new JComboBox(doc_type_string);
		cb.setBounds(316, 155, 201, 26);
		contentPane.add(cb);
		
			
		String[] doc_type_string1 = {"Bangalore","Chennai","Kochi","Hyderabad","Delhi","Mumbai","Vizag","Kolkata","Ahmedabad","Goa","Lucknow"};
		final JComboBox cb1 = new JComboBox(doc_type_string1);
		cb1.setBounds(316, 199, 201, 26);
		contentPane.add(cb1);
		
		arrival_time= new JTextField();
		arrival_time.setBounds(318, 249, 130, 26);
		contentPane.add(arrival_time);
		arrival_time.setColumns(10);
		
		departure_time= new JTextField();
		departure_time.setBounds(316, 293, 130, 26);
		contentPane.add(departure_time);
		departure_time.setColumns(10);
		
		fare= new JTextField();
		fare.setBounds(316, 343, 130, 26);
		contentPane.add(fare);
		fare.setColumns(10);
		
		JButton Submit = new JButton("SUBMIT");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flightcode = flight_code.getText().toString();
				String source= (String)cb.getSelectedItem();
				String destination = (String)cb1.getSelectedItem();
				String  arrivaltime= arrival_time.getText().toString();
				String  departuretime= departure_time.getText().toString();
				String  far= fare.getText().toString();
				if(!flightcode.equals("") && !arrivaltime.equals("") && !departuretime.equals("") && !far.equals("")) {
					try {
						main.ad.insert(flightcode,source,destination,arrivaltime,departuretime,far,"C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
						dispose();
						adminhome ap=new adminhome();
						main.create_au_index();
						dispose();
						ap.setVisible(true);
						}
							
					 catch (Exception e1) {
						// TODO Auto-generated catch blocke1.printStackTrace();
					}
					}
					else {
						JOptionPane.showMessageDialog( flight_code, "Enter All The Fields", "", getDefaultCloseOperation());
					}
				}
			
		});
		Submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Submit.setBounds(257, 388, 141, 26);
		contentPane.add(Submit);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				adminhome ah=new adminhome();
				ah.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(587, 388, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
		
	}

}
