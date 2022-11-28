package com.bank.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	public JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setFont(new Font("Dialog", Font.PLAIN, 35));
		setTitle("Bank Of IIT Manager System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Data Operation");
		mnNewMenu.setForeground(new Color(255, 99, 71));
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Custom Business");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("Client Deposit/Withdraw");
		menuItem.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusVerifyFrm cusVerifyFrm=new CusVerifyFrm(table);
				cusVerifyFrm.setVisible(true);
				table.add(cusVerifyFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Client Balance Management");
		menuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QueryCusfdFrm queryCusfdFrm=new QueryCusfdFrm();
				queryCusfdFrm.setVisible(true);
				table.add(queryCusfdFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_1.add(menuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Transit Business");
		mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("Transit Operation");
		menuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraferFrm traferFrm=new TraferFrm();
				traferFrm.setVisible(true);
				table.add(traferFrm);
			}
		});


		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Transit Records");
		menuItem_3.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryTraferFram queryTraferFram=new QueryTraferFram();
				queryTraferFram.setVisible(true);
				table.add(queryTraferFram);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Safety Exit");
		menuItem_4.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "Confirm to Exit?");
				if(result==0){
					dispose();
				}
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem_4);
		
		JMenu menu = new JMenu("Help");
		menu.setFont(new Font("Arial", Font.PLAIN, 12));
		menu.setForeground(new Color(255, 99, 71));
		menu.setBackground(new Color(255, 255, 255));
		menu.setFont(new Font("Arial", Font.PLAIN, 12));
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu);
		
		JMenuItem mntmjava = new JMenuItem("About us");
		mntmjava.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutFrame java1234InterFrm=new AboutFrame();
				java1234InterFrm.setVisible(true);
				table.add(java1234InterFrm);
			}
		});
		mntmjava.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menu.add(mntmjava);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		table = new JDesktopPane();
		table.setBackground(new java.awt.Color(100, 100, 100));
		contentPane.add(table, BorderLayout.CENTER);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
