package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import com.bank.dao.CusVerifyDao;
import com.bank.model.Customer;
import com.bank.util.StringUtil;
import com.bank.util.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JDesktopPane;

public class CusVerifyFrm extends JInternalFrame {


	private JTextField cuAccounttext;
	private JPasswordField cuPasswordField;
	private DbUtil dbUtil=new DbUtil();
	private CusVerifyDao cusVerifyDao = new CusVerifyDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

					JDesktopPane table = null;
					CusVerifyFrm frame = new CusVerifyFrm(null);
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
	public CusVerifyFrm(JDesktopPane table) {
		setClosable(true);
		setIconifiable(true);
		setTitle("Verify Account Information");
		setBounds(100, 100, 450, 300);

		JLabel lblNewLabel = new JLabel("Account Number");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_1 = new JLabel("Account Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));

		cuAccounttext = new JTextField();
		cuAccounttext.setFont(new Font("Arial", Font.PLAIN, 12));
		cuAccounttext.setColumns(10);

		cuPasswordField = new JPasswordField();

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusverifyActionPerformed(table,e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(CusVerifyFrm.class.getResource("/images/login.png")));
		btnNewButton.setFont(new Font("Login", Font.BOLD, 16));

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setIcon(new ImageIcon(CusVerifyFrm.class.getResource("/images/reset.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(114)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(128, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(66, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
								.addGap(31)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cuPasswordField)
										.addComponent(cuAccounttext, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addGap(73))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(71)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(cuAccounttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addGap(40)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(cuPasswordField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
								.addGap(37)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton)
										.addComponent(btnNewButton_1))
								.addContainerGap(46, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		cuAccounttext.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		cuPasswordField.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

	}

	private void CusverifyActionPerformed(JDesktopPane table, ActionEvent evt) {
		String cuAccounttext = this.cuAccounttext.getText();
		String cuPasswordField = new String(this.cuPasswordField.getPassword());

		if (StringUtil.isEmpty(cuAccounttext)) {
			JOptionPane.showMessageDialog(null, "Account Number can not be empty");
			return;
		}
		if (StringUtil.isEmpty(cuPasswordField)) {
			JOptionPane.showMessageDialog(null, "Password can not be empty");
			return;
		}
		Customer customer = new Customer(cuAccounttext, cuPasswordField);
		Connection con = null;

		try {
			con = dbUtil.getCon();
			Customer currentUser = cusVerifyDao.login(con, customer);
			System.out.println("Login IN----------"+currentUser.getCuName());
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "Verified");
				dispose();
				CusoperaFrm cusoperaFrm=new CusoperaFrm(currentUser);
				cusoperaFrm.setVisible(true);

				table.add(cusoperaFrm);

			} else {
				JOptionPane.showMessageDialog(null, "Account Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	/**
	 * Reset
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * Reset
	 */
	private void resetValue(){
		this.cuAccounttext.setText("");
		this.cuPasswordField.setText("");
	}
}
