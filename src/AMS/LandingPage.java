package AMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LandingPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage frame = new LandingPage();
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
	public LandingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(	0, 255, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GET STARTED");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					try {
						main.create_au_index();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					aupage au=new aupage();
					au.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(508, 229, 179, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C://Users//prem//Desktop//myprojects//fs//FS AMS//Airline.jpg"));
		lblNewLabel_1.setBounds(28, 108, 345, 293);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("File Structures ");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(231, 54, 606, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblMiniProject = new JLabel("Mini Project");
		lblMiniProject.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 34));
		lblMiniProject.setBounds(376, 133, 606, 69);
		contentPane.add(lblMiniProject);

		JLabel lblNewLabel2 = new JLabel("Priyamvada P. (1BY20IS121)");
		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel2.setBounds(552, 375, 361, 20);
		contentPane.add(lblNewLabel2);
	}
}






