
package com.swing;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class AddDepartment extends JFrame implements ActionListener,KeyListener ,WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps,psupdate;
	private ResultSet rs;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txthod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment frame = new AddDepartment();
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
	public AddDepartment()throws Exception {
		con=CrudOperation.connection();
		setTitle("AddDepartment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.swatchesDefaultRecentColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(42, 31, 48, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(42, 68, 48, 14);
		contentPane.add(lblName);
		
		JLabel lblHod = new JLabel("HOD");
		lblHod.setBounds(42, 105, 48, 14);
		contentPane.add(lblHod);
		
		txtid = new JTextField();
		txtid.setBounds(99, 28, 96, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(99, 65, 96, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txthod = new JTextField();
		txthod.setBounds(99, 105, 96, 20);
		contentPane.add(txthod);
		txthod.setColumns(10);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(75, 167, 89, 23);
		btnAdd.addActionListener(this);
		btnAdd.addKeyListener(this);
		contentPane.add(btnAdd);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(75, 213, 89, 23);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
	}
	public void InsertData() {
	String id=txtid.getText();
	String Name=txtname.getText();
	String Hod=txthod.getText();
	String strinsert="insert into adddepartment values(?,?,?);";
		try {
			ps=con.prepareStatement(strinsert);//query goes to rdbms
			ps.setString(1, id);
			ps.setString(2,Name);
			ps.setString(3,Hod);
		
		
			int rw=ps.executeUpdate();//fire insert query
			if(rw>0)
			{
				//System.out.println("row inserted successfully");
			JOptionPane.showMessageDialog(this,"data inserted","Insertion",JOptionPane.PLAIN_MESSAGE);
			txtid.setText("");
			txtname.setText("");
			txthod.setText("");
			
			}
		}
			catch(SQLException se)
			{
				System.out.println(se);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	  String caption=e.getActionCommand();
	  String id=null;
	  if(caption.contentEquals("Search"))
	  {
		  id=txtid.getText();
		  if(id.isEmpty())
		    JOptionPane.showMessageDialog(this, "ID required");
		  else {
			  String strsql="Select * from adddepartment where Id=?;";
			  try {
				  ps=con.prepareStatement(strsql);
				  ps.setString(1, id);
				  rs=(ResultSet) ps.executeQuery();
				  if(rs.next())
				  {
					txtname.setText(rs.getString("Name"));
					txthod.setText(rs.getString("HOD"));
				  }
				  else {
					  JOptionPane.showMessageDialog(this,"NO such id exists");
				  }
				  }
			  catch(SQLException se)
			  {
				  System.out.println(se);
			  }
			  finally {
				  try {
					  if(ps!=null)
						  ps.close();
					  if(rs!=null)
						  rs.close();
					  
				  }
				  catch(SQLException se)
				  {
					  System.out.println(se);
				  }
			  }
			  
			  }
		  }
	  if(caption.contentEquals("add")) {
		  //InsertData();
		  String strupdate="update adddepartment set Name=?,HOD=? where Id=?;";
		  String Id=txtid.getText();
		  String Name=txtname.getText();
		  String Hod=txthod.getText();
		  if(Id.isEmpty()||Name.isEmpty()||Hod.isEmpty())
			  JOptionPane.showMessageDialog(this, "Data needed");
		  else {
			  try {
				  psupdate=con.prepareStatement(strupdate);
				  psupdate.setString(1, Name);
				  psupdate.setString(2, Hod);
				  psupdate.setString(3, Id);
				  int rw=psupdate.executeUpdate();
				  if(rw>0)
					  JOptionPane.showMessageDialog(this,"Data Updated Sucessfully");
				  
			  }catch(SQLException se)
			  {
				  System.out.println(se);
				  
			  }
			  finally {
				  try {
					  if(psupdate!=null)
						  psupdate.close();
					  
				  }
				  catch(SQLException se)
				  {
					  System.out.println(se);
				  }
			  }
		  }
	  }
	  
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();//return the ascii value
		System.out.println(code);
		if(code==10)
			InsertData();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		CrudOperation.CloseConnection();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
