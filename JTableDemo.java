package com.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JTableDemo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtdesig;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableDemo frame = new JTableDemo();
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
	public JTableDemo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		drwaGui();
		
		
		
	}
	public void drwaGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 41, 355, 210);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Shruti", Font.ITALIC, 14));
		table.setForeground(Color.BLUE);
		JTableHeader header=table.getTableHeader();
		header.setBackground(Color.BLACK);
		header.setFont(new Font("Lucida Console",Font.BOLD,20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Scott", "java", "7398431818"},
				{"sunny", "mbbs", "9838115271"},
				{"Deepika", "bsc", "7379600012"},
			},
			new String[] {
				"Name", "Course", "Phone"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		scrollPane.setViewportView(table);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(46, 11, 66, 14);
		contentPane.add(lblDesignation);
		
		txtdesig = new JTextField();
		txtdesig.setBounds(179, 8, 96, 20);
		contentPane.add(txtdesig);
		txtdesig.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(298, 7, 89, 23);
		btnGo.addActionListener(this);
		contentPane.add(btnGo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
