package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Example extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JScrollPane Jscrollpane;
	Connection con=null;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField txtdesig;
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Example() throws Exception {
		con=CrudOperation.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				String query="Select * from designation";
				ps=con.prepareStatement(query);
				ps.setString(1, txtdesig.getText());
				rs=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				int c=table.getRowCount();
				if(c>0)
				{
					scrollPane.setViewportView(table);
				}
				
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			}
		});
		btnGo.setBounds(537, 11, 89, 23);
		contentPane.add(btnGo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 58, 515, 344);
		contentPane.add(scrollPane);
		
		table = new JTable();
		//scrollPane.setViewportView(table);
		
		txtdesig = new JTextField();
		txtdesig.setBounds(350, 12, 96, 20);
		contentPane.add(txtdesig);
		txtdesig.setColumns(10);
	}
}
