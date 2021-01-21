package com.swing;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Admin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem miadd,miupdate,midelete;
	private JLabel lblimage;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
	
		drawGui();
		
	}
	public void drawGui()
	{
		setTitle("AdminFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 387);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEmployee = new JMenu("Employee");
		menuBar.add(mnEmployee);
		
		 miadd = new JMenuItem("Add");
		 miadd.addActionListener(this);
		mnEmployee.add(miadd);
		
		 miupdate = new JMenuItem("Update");
		 miupdate.addActionListener(this);
		mnEmployee.add(miupdate);
		
		midelete = new JMenuItem("Delete");
		midelete.addActionListener(this);
		mnEmployee.add(midelete);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		
		
		lblNewLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/com/images/kkk.jpg")));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/com/images/suraj.jpg")));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/com/images/kkk.jpg")));
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/com/images/kkk.jpg")));
		lblNewLabel.setBounds(236, 133, 341, 152);
		contentPane.add(lblNewLabel);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String caption=e.getActionCommand();
		if(caption.contentEquals("Add"))
		{
		AddEmployee emp=new AddEmployee();
			emp.setVisible(true);
		}
		if(caption.contentEquals("Update"))
		{
		UpdateEmployee emp=new UpdateEmployee();
		emp.setVisible(true);
		}
		if(caption.contentEquals("Delete"))
		{
		DeleteEmployee emp=new DeleteEmployee();
		emp.setVisible(true);
		}
		}
}
