package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bank.model.Customer;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

public class CusoperaFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane cusoperatable =null;
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusoperaFrm frame = new CusoperaFrm(null);
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
	public CusoperaFrm(Customer customer) {
		
		String cname = customer.getCuName();
		setTitle("Client Deposit/Withdraw Business");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 509);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		mnNewMenu.setIcon(new ImageIcon(CusoperaFrm.class.getResource("/images/base.png")));
		mnNewMenu.setForeground(new Color(3, 3, 3));
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		//·µ»Ø²Ëµ¥
		JMenuItem fanhuiMenuItem = new JMenuItem("BACK TO DESKTOP",KeyEvent.VK_X);
		fanhuiMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JDesktopPane table = new JDesktopPane();
				CusVerifyFrm cusVerifyFrm = new CusVerifyFrm(table);
				cusVerifyFrm.setVisible(true);
			}
		});
		mnNewMenu.add(fanhuiMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cusoperatable = new JDesktopPane();
		
		JButton deposButton = new JButton("Deposit");
		deposButton.setIcon(new ImageIcon(CusoperaFrm.class.getResource("/images/12.png")));
		deposButton.setFont(new Font("Arial", Font.BOLD, 20));
		deposButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusdeposFrm cusdeposFrm=new CusdeposFrm(customer);
				cusoperatable.add(cusdeposFrm);
				cusdeposFrm.setVisible(true);
			}
		});
		deposButton.setBounds(118, 139, 175, 75);
		cusoperatable.add(deposButton);
		
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.setIcon(new ImageIcon(CusoperaFrm.class.getResource("/images/Misc - Desktop.png")));
		withdrawButton.setFont(new Font("Arial", Font.BOLD, 20));
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithrawFrm withrawFrm=new WithrawFrm(customer);
				cusoperatable.add(withrawFrm);   
				withrawFrm.setVisible(true);
				
			}
		});
		withdrawButton.setBounds(405, 139, 175, 75);
		cusoperatable.add(withdrawButton);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(cusoperatable, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(cusoperatable, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
		);
		
		JLabel khxmLabel = new JLabel("Hello: "+cname);
		khxmLabel.setForeground(new Color(255, 255, 255));
		khxmLabel.setFont(new Font("Arial", Font.BOLD, 20));
		khxmLabel.setBounds(9, 3, 284, 65);
		cusoperatable.add(khxmLabel);
		contentPane.setLayout(gl_contentPane);
	}
}
