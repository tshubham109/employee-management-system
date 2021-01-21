package com.swing;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DesigJTable extends JFrame  {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesigJTable frame = new DesigJTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection con=null;
PreparedStatement ps;
ResultSet rs;
private JTextField txtdesig;
	/**
	 * Create the frame.
	 */
	public DesigJTable() {
		try {
			con=CrudOperation.connection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{try {
					String query="Select * from designation";
					ps=con.prepareStatement(query);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			
			}
						
			
		
		btnGo.setBounds(532, 23, 89, 23);
		contentPane.add(btnGo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 55, 605, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtdesig = new JTextField();
		txtdesig.setBounds(366, 24, 96, 20);
		contentPane.add(txtdesig);
		txtdesig.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(231, 27, 80, 14);
		contentPane.add(lblDesignation);
		}}
	

