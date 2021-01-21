package com.swing;
import java.sql.*;//2
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.dbutil.CrudOperation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class DeleteEmployee extends JFrame implements ActionListener
{
	JComboBox cmbid;
	private JPanel contentPane;//1
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;// it holds the address of output of the query.it works on select only 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		con=CrudOperation.createConnection();
		drawgui();
	}
	public void fillCombo()
	{
		String strsql="select employeeid from employee";
		rs=CrudOperation.fetchData(strsql);
		try {
		while(rs.next())
		{
			String id=rs.getString("employeeid");
			cmbid.addItem(id);//addItem is a method of combobox
		}
		}//next method raise SQL Exception
		catch(SQLException se)
		{
			System.out.println(se);
			
		}
	}
	
public void drawgui()
{setTitle("DeleteEmployee");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100, 100, 450, 300);
setLocationRelativeTo(null);
setExtendedState(Frame.MAXIMIZED_BOTH);
contentPane = new JPanel();
contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
setContentPane(contentPane);
contentPane.setLayout(null);

cmbid = new JComboBox();
cmbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
cmbid.setModel(new DefaultComboBoxModel(new String[] {"Select_id"}));
cmbid.setBounds(126, 42, 113, 22);
fillCombo();
contentPane.add(cmbid);

JButton btnDelete = new JButton("Delete");
btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
btnDelete.setBounds(136, 75, 89, 23);
btnDelete.addActionListener(this);
contentPane.add(btnDelete);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String id=(String)cmbid.getSelectedItem();
	if(id.equalsIgnoreCase("Select Employeeid"))
	{
		JOptionPane.showMessageDialog(this,"please select valid ID");
	}
	else {
		int option=JOptionPane.showConfirmDialog(this,"Do You Really Wish to Delete this"+id);
		System.out.println(option);
		if(option==0)
		{
			String strdelete="delete from employee where employeeid=?";
			try {
				ps=con.prepareStatement(strdelete);//query compile
				ps.setString(1, id);
				System.out.println(ps);
				int row=ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this,"Record Deleted Sucessfully");
				}
			}
			catch(SQLException se)
			{
				
			}
		}
	}
}

}
