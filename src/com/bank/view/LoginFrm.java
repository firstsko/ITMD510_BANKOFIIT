package com.bank.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;


import com.bank.dao.OperatorDao;
import com.bank.model.Operator;
import com.bank.util.DbUtil;
import com.bank.util.StringUtil;
import com.bank.view.LoginFrm;
import com.bank.view.MainFrm;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private OperatorDao operatorDao=new OperatorDao();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
					//String lookAndFeel = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
					//UIManager.setLookAndFeel(lookAndFeel);
				  	//org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					 JFrame.setDefaultLookAndFeelDecorated(true);
					 JFrame.setDefaultLookAndFeelDecorated(true);
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setAlwaysOnTop(true);
		setResizable(false);
		//Change Fonts
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setTitle("Bank Of IIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("BANK OF IIT", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));

		lblNewLabel.setIcon(new ImageIcon((new ImageIcon(this.getClass().getResource("/images/iit_logo.png")).getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))));

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(83)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(passwordTxt))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(117)
								.addComponent(btnNewButton)
								.addGap(26)
								.addComponent(btnNewButton_1))))
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)))
		);
		contentPane.setLayout(gl_contentPane);
		
		// 设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}



	/**
	 * Login Event
	 * @param
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String opName=this.userNameTxt.getText();
		String opPassword=new String(this.passwordTxt.getPassword());


		
		if(StringUtil.isEmpty(opName)){
			JOptionPane.showMessageDialog(null, "UserName can not be empty");
			return;
		}
		if(StringUtil.isEmpty(opPassword)){
			JOptionPane.showMessageDialog(null, "Password can not be empty！");
			return;
		}
		Operator operator=new Operator(opName,opPassword);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			Operator currentUser=operatorDao.login(con, operator);
			if(currentUser!=null){
				dispose();
				new MainFrm().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Wrong UserName or password！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reset event
	 * @param
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}

}
