package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bank.dao.CusVerifyDao;
import com.bank.dao.TrinterDao;
import com.bank.model.Customer;
import com.bank.model.Trinter;
import com.bank.util.DbUtil;
import com.bank.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;

public class TraferFrm extends JInternalFrame {
	
	private DbUtil dbUtil=new DbUtil();
	private TrinterDao trinterDao=new TrinterDao();
	private CusVerifyDao cusVerifyDao=new CusVerifyDao();
	private JTextField hktextField;
	private JTextField sktextField;
	private JTextField jetextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TraferFrm() {
		setTitle("Transit Operation");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 500, 600);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Target Account");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Amount of Money");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		hktextField = new JTextField();
		hktextField.setColumns(10);
		
		sktextField = new JTextField();
		sktextField.setColumns(10);
		
		jetextField = new JTextField();
		jetextField.setColumns(10);
		
		JButton tijiaoButton = new JButton("Confirm");
		tijiaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traferAddActionPerformed(e);
			}
		});
		tijiaoButton.setFont(new Font("Arial", Font.PLAIN, 20));
		tijiaoButton.setIcon(new ImageIcon(TraferFrm.class.getResource("/images/Security - Admin.png")));
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		resetButton.setIcon(new ImageIcon(TraferFrm.class.getResource("/images/reset.png")));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Immediately");
		rdbtnNewRadioButton.setBackground(SystemColor.desktop);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Timing");
		rdbtnNewRadioButton_1.setBackground(SystemColor.desktop);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(sktextField, 166, 166, 166))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(hktextField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(jetextField, 166, 166, 166))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(tijiaoButton)
								.addComponent(rdbtnNewRadioButton))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(resetButton))))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(hktextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(sktextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(jetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tijiaoButton)
						.addComponent(resetButton))
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 转账记录添加事件处理
	 * @param e
	 */
	private void traferAddActionPerformed(ActionEvent evt) {
		String hktextField=this.hktextField.getText();
		String sktextField=this.sktextField.getText();
		String jetextField=this.jetextField.getText();
		//金额格式化
		Double jetextField2 = Double.parseDouble(jetextField);
		System.out.println("格式化后金额?"+jetextField2);
		
		if(!hktextField.equals("")){
			if(!sktextField.equals("")){
			Trinter trinter=new Trinter(hktextField, sktextField, jetextField2);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				String str = JOptionPane.showInputDialog("请输入支付密码?");
				Customer customer =cusVerifyDao.traVerify(con, hktextField);
				
				if (str.equals(customer.getCuPassword())){
				int addNum=trinterDao.add(con, trinter, jetextField);
				if(addNum==1){
					JOptionPane.showMessageDialog(null, "转账成功?");
					resetValue();
				}else{
					JOptionPane.showMessageDialog(null, "转账失败?");
				}
				}else {
					JOptionPane.showMessageDialog(null,"您输入的密码不正确?");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "转账失败?");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "收款卡号不能为空?");
		}
		}else {
			JOptionPane.showMessageDialog(null, "汇款卡号不能为空?");
		}
		
	}
	/*
	private JPasswordField passwd = new JPasswordField(10);
	
	public String showInputDialog() {
		JOptionPane localJOptionPane = new JOptionPane(
		"Please input this subject's password:",
		JOptionPane.QUESTION_MESSAGE);
		localJOptionPane.add(passwd);
		passwd.setEchoChar('*');
		JDialog localJDialog = localJOptionPane.createDialog(localJOptionPane,
		"Input");
		localJDialog.setVisible(true);
		String localObject = String.valueOf(passwd.getPassword());
		localJDialog.dispose();
		return localObject;
		}
		*/
	
	private void resetValueActionPerformed(ActionEvent evt){
		this.hktextField.setText("");
		this.sktextField.setText("");
		this.jetextField.setText("");
	}
	
	private void resetValue(){
		this.hktextField.setText("");
		this.sktextField.setText("");
		this.jetextField.setText("");
	}
}
