
package com.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class UpdateEmployee extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtempid;
	private JTextField txtempemail;
	private JTextField txtempphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		setTitle("UpdateEmployee");
		drawGui();
	}
	public void drawGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpid = new JLabel("EmpId");
		lblEmpid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmpid.setBounds(50, 38, 62, 26);
		contentPane.add(lblEmpid);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(50, 76, 62, 26);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(50, 113, 62, 26);
		contentPane.add(lblPhone);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(95, 150, 89, 23);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		txtempid = new JTextField();
		txtempid.setBounds(130, 38, 132, 20);
		contentPane.add(txtempid);
		txtempid.setColumns(10);
		
		txtempemail = new JTextField();
		txtempemail.setBounds(130, 81, 132, 20);
		contentPane.add(txtempemail);
		txtempemail.setColumns(10);
		
		txtempphone = new JTextField();
		txtempphone.setBounds(128, 113, 134, 20);
		contentPane.add(txtempphone);
		txtempphone.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(314, 80, 89, 23);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		String id=null;
		if(caption.contentEquals("Search"))
		{
			id
		}
	}

}
