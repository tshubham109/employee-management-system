package com.swing;
import java.awt.event.*;


import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutil.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;

public class AddEmployee extends JFrame implements ActionListener,KeyListener
{
private Connection con;
private PreparedStatement ps;
private JRadioButton rdmale,rdfemale;
private JComboBox cmbempdesig;
	private JPanel contentPane;
	private JTextField txtempid;
	private JTextField txtempname;
	private JTextField txtempemail;
	private JTextField txtempphone;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setTitle("AddEmployee\r\n");
		con=CrudOperation.createConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//close the parent window
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//window will be in centre
		setContentPane(contentPane);
		
		JLabel lblEmpid = new JLabel("EmpId");
		lblEmpid.setBounds(23, 32, 58, 21);
		lblEmpid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(23, 64, 58, 14);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 89, 48, 14);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(23, 114, 48, 14);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(113, 198, 89, 23);
		
		btnSubmit.addActionListener(this);
		btnSubmit.addKeyListener(this);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtempid = new JTextField();
		txtempid.setBounds(134, 34, 96, 20);
		txtempid.setColumns(10);
		
		txtempname = new JTextField();
		txtempname.setBounds(134, 63, 96, 20);
		txtempname.setColumns(10);
		
		txtempemail = new JTextField();
		txtempemail.setBounds(134, 88, 96, 20);
		txtempemail.setColumns(10);
		
		txtempphone = new JTextField();
		txtempphone.setBounds(134, 113, 96, 20);
		txtempphone.setColumns(10);
		
		 cmbempdesig = new JComboBox();
		cmbempdesig.setBounds(102, 144, 117, 22);
		cmbempdesig.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbempdesig.setModel(new DefaultComboBoxModel(new String[] {"Designation", "junior manager", "senior manager", "project manager"}));
		
		 rdmale = new JRadioButton("male");
		rdmale.setBounds(84, 173, 58, 23);
		buttonGroup.add(rdmale);
		rdmale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		 rdfemale = new JRadioButton("female");
		rdfemale.setBounds(154, 173, 76, 23);
		buttonGroup.add(rdfemale);
		rdfemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblEmpid);
		contentPane.add(txtempid);
		contentPane.add(lblName);
		contentPane.add(txtempname);
		contentPane.add(lblEmail);
		contentPane.add(txtempemail);
		contentPane.add(lblPhone);
		contentPane.add(txtempphone);
		contentPane.add(cmbempdesig);
		contentPane.add(rdmale);
		contentPane.add(rdfemale);
		contentPane.add(btnSubmit);
	}
	public void insertData()
	{
		System.out.println("button clicked");
		String Empid=txtempid.getText();
		String Empname=txtempname.getText();
		String email=txtempemail.getText();
		String phone=txtempphone.getText();
		String gender="";
		if(rdmale.isSelected())
			gender=rdmale.getText();
		if(rdfemale.isSelected())//is Selected method returns boolean value that is True
			gender=rdfemale.getText();
		String desig=(String)cmbempdesig.getSelectedItem();//gives the reference  of superclass
		if(Empid.isEmpty()||Empname.isEmpty()||email.isEmpty()||phone.isEmpty()||gender.isEmpty()||desig.contentEquals("Designation"))
		{
			JOptionPane.showMessageDialog(this, "Please Enter The Data");
		}
		else
		{
		String strinsert="insert into employee values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(strinsert);//query goes to rdbms
			ps.setString(1, Empid);
			ps.setString(2,Empname);
			ps.setString(3,email);
			ps.setString(4,phone);
			ps.setString(5,desig);
			ps.setString(6,gender);
			int rw=ps.executeUpdate();//fire insert query
			if(rw>0)
			{
				//System.out.println("row inserted successfully");
			JOptionPane.showMessageDialog(this,"data inserted","Insertion",JOptionPane.PLAIN_MESSAGE);
			txtempid.setText("");
			txtempname.setText("");
			txtempphone.setText("");
			txtempemail.setText("");
			}
		}
			catch(SQLException se)
			{
				System.out.println(se);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		insertData();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();//return the ascii value
		System.out.println(code);
		if(code==10)
			insertData();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
