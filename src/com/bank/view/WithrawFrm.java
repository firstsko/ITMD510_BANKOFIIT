package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.bank.dao.CusFundsDao;
import com.bank.dao.FundChangeDao;
import com.bank.model.Customer;
import com.bank.model.FundChange;
import com.bank.util.DbUtil;
import com.bank.util.StringUtil;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class WithrawFrm extends JInternalFrame {
	
	private DbUtil dbUtil=new DbUtil();
	private FundChangeDao fundChangeDao=new FundChangeDao();
	private CusFundsDao cusFundsDao=new CusFundsDao();
	private JTextField qkkhtextField;
	private JTextField qkzhtextField;
	private JTextField qkjetextField;
	private JTextField qkbztextField;
	private String idcard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithrawFrm frame = new WithrawFrm(null);
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
	public WithrawFrm(Customer customer) {
		setTitle("Withdraw");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 475, 375);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Withdraw Client");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Withdraw Account");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Withdraw Amount");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Remark");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		idcard = customer.getCuIDCard();
		
		qkkhtextField = new JTextField();
		qkkhtextField.setEditable(false);
		qkkhtextField.setColumns(10);
		qkkhtextField.setText(customer.getCuName());
		
		
		qkzhtextField = new JTextField();
		qkzhtextField.setEditable(false);
		qkzhtextField.setColumns(10);
		qkzhtextField.setText(customer.getCuAccount());
		
		qkjetextField = new JTextField();
		qkjetextField.setColumns(10);
		
		qkbztextField = new JTextField();
		qkbztextField.setText("\u65E0");
		qkbztextField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customdepoAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(WithrawFrm.class.getResource("/images/Security - Admin.png")));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(WithrawFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addGap(24)
										.addComponent(qkbztextField))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addGap(25)
										.addComponent(qkjetextField, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(26)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(qkzhtextField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(qkkhtextField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(112)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addComponent(lblNewLabel)
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(qkzhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addComponent(lblNewLabel_2)
							.addGap(37)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(55)
							.addComponent(qkkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(qkjetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(qkbztextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
	private void resetValueActionPerformed(ActionEvent evt){
		this.qkjetextField.setText("");
		this.qkbztextField.setText("");
	}
	
	private void resetValue(){
		this.qkjetextField.setText("");
		this.qkbztextField.setText("");
	}
	/**
	 * 耶紗贋錘並周侃尖
	 * @param e
	 */
	private void customdepoAddActionPerformed(ActionEvent evt) {
		String qkkhtextField=this.qkkhtextField.getText();
	
		String qkjetextField=this.qkjetextField.getText();
		System.out.println("(函錘)鯉塀晒念署駆�"+qkjetextField);
		Double qkjetextField2 = Double.parseDouble(qkjetextField);
		System.out.println("(函錘)鯉塀晒朔署駆�"+qkjetextField2);
		
		String qkzhtextField=this.qkzhtextField.getText();
		String qkbztextField=this.qkbztextField.getText();
		System.out.println("姥廣�"+qkbztextField);
		String idcard=this.idcard;
		System.out.println("附芸屬�"+idcard);
		if(StringUtil.isEmpty(qkjetextField)){
			JOptionPane.showMessageDialog(null, "函錘署駆音嬬葎腎�");
			return;
		}
		FundChange fundChange=new FundChange(qkkhtextField,idcard,qkzhtextField,qkjetextField2,qkbztextField);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=fundChangeDao.qkadd(con, fundChange);
			int m=cusFundsDao.noraddupdate(con,qkjetextField2,qkzhtextField);
			if(n==1 && m==1){
				JOptionPane.showMessageDialog(null, "函錘撹孔�");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "函錘払移�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "函錘払移�");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
