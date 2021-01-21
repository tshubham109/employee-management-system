package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtuserid;
	private JPasswordField txtuserpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LoginFrame");
		drawGui();
	}
	public void drawGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 369);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Shruti", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(32, 38, 57, 22);
		contentPane.add(lblNewLabel);
		
		txtuserid = new JTextField();
		txtuserid.setBounds(112, 37, 212, 20);
		contentPane.add(txtuserid);
		txtuserid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Shruti", Font.ITALIC, 16));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBackground(Color.BLUE);
		lblPassword.setBounds(32, 83, 79, 22);
		contentPane.add(lblPassword);
		
		txtuserpass = new JPasswordField();
		txtuserpass.setBounds(112, 82, 212, 20);
		contentPane.add(txtuserpass);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setFont(new Font("Shruti", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBounds(86, 116, 91, 27);
		contentPane.add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userid=txtuserid.getText().trim();
		System.out.println(userid);
		char []pass=txtuserpass.getPassword();
		String userpass=String.valueOf(pass);
		if(userid.isEmpty()==true||userpass.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"data required");
		}
		else
		{	if(userid.equals("Scott")&&userpass.equals("tiger"))
			{
			Admin admin=new Admin();
			
			admin.setVisible(true);
			this.dispose();
			}
		else
			JOptionPane.showMessageDialog(this, "invlid userid or password");
		}
	}
}
