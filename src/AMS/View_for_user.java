package AMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class View_for_user extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_for_user frame = new View_for_user();
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
	public View_for_user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 472);
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
                "FLIGHT CODE", "source", "destination" , "arrivaltime" ,"departuretime" ,"fare", 
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        final DefaultTableModel d= (DefaultTableModel)jTable1.getModel();
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.setBounds(27, 5, 77, 29);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			userhome ap=new userhome();
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
        			
    	    		String[][] data = main.ad.view();
    	    		 int num_row = main.rec;
    	 	        for(int i=0;i<num_row;i++) {
    	 	        	 
    	 	        	d.addRow(data[i]);
    	 	        }
    	    		}catch(Exception ej){System.out.print("cant show");}
        		
        	}
        });
        
        JLabel lblNewLabel = new JLabel("AVAILABLE FLIGHTS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(13, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addGap(23)
        			.addComponent(btnNewButton)
        			.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnNewButton_1)
        			.addGap(22))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(27)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNewButton_1)
        				.addComponent(btnNewButton)
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
	}

}
