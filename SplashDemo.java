package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class SplashDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashDemo frame = new SplashDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loadFrame()
	{
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Login d=new Login();
				d.setVisible(true);
				SplashDemo.this.dispose();
			}
		}
				).start();
	}
	public void drawGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstagram = new JLabel(" Instagram");
		lblInstagram.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 24));
		lblInstagram.setBounds(88, 77, 153, 40);
		contentPane.add(lblInstagram);
	}

	/**
	 * Create the frame.
	 */
	public SplashDemo() {
		drawGui();
		loadFrame();
	}
}
