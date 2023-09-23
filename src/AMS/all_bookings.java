package AMS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class all_bookings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					all_bookings frame = new all_bookings();
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
	public all_bookings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(27, 49, 515, 350);
        JTable jTable1 = new javax.swing.JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "NAME", "AGE", "GENDER" , "CONTACT No."  
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        final DefaultTableModel di= (DefaultTableModel)jTable1.getModel();
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.setBounds(27, 5, 77, 29);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			adminhome ap=new adminhome();
					dispose();
					ap.setVisible(true);
        		}catch(Exception e1) {
        			
        		}
        	}
        });
        
        JButton btnNewButton_1 = new JButton("SHOW");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			
    	    		String[][] data = main.booking.view_booking();
    	    		 int num_row = main.rec_b;
    	 	        for(int i=0;i<num_row;i++) {
    	 	        	 
    	 	        	di.addRow(data[i]);
    	 	        }
    	    		}catch(Exception ej){System.out.print("cant show");}
        		
        	}
        });
        
        JLabel lblNewLabel = new JLabel("BOOKINGS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(22)
        					.addComponent(btnNewButton)
        					.addGap(129)
        					.addComponent(lblNewLabel)
        					.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
        					.addComponent(btnNewButton_1))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnNewButton)
        					.addComponent(btnNewButton_1))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(19)
        					.addComponent(lblNewLabel)))
        			.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
		
	}

}
