package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Splash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void LoadFrame()
	{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);//sleep method raise exception
					Login login=new Login();
					login.setVisible(true);
					Splash.this.dispose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		//t.start();
	}
public void DrawGui() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 512, 431);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);getContentPane().setBackground(Color.CYAN);
getContentPane().setLayout(null);

JLabel lblEmpmisWelcomesYou = new JLabel("Empmis Welcomes you ");
lblEmpmisWelcomesYou.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 15));
lblEmpmisWelcomesYou.setBounds(120, 73, 217, 59);
getContentPane().add(lblEmpmisWelcomesYou);
	
}
	/**
	 * Create the frame.
	 */
	public Splash() {
		DrawGui();
		LoadFrame();
		
	}
}
