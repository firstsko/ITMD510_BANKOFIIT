package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.bank.util.DbUtil;
import com.bank.dao.CusFundsDao;
import com.bank.dao.FundChangeDao;
import com.bank.model.Customer;
import com.bank.model.FundChange;
import com.bank.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CusdeposFrm extends JInternalFrame {
	private JTextField ckkhtextField;
	private JTextField ckjetextField;
	private JTextField ckhmtextField;
	private JTextField beizhutextField;
	private CusFundsDao cusFundsDao=new CusFundsDao();
	private String idcard;
	
	private DbUtil dbUtil=new DbUtil();
	private FundChangeDao fundChangeDao=new FundChangeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusdeposFrm frame = new CusdeposFrm(null);
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
	public CusdeposFrm(Customer customer) {
		
		setIconifiable(true);
		setClosable(true);
		setTitle("Deposit");
		setBounds(100, 100, 493, 379);
		
		JLabel ckjeLabel = new JLabel("\u5B58\u6B3E\u91D1\u989D\uFF1A");
		ckjeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel ckkhLabel = new JLabel("\u5B58\u6B3E\u5361\u53F7\uFF1A");
		ckkhLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton tijiaoButton = new JButton("\u63D0  \u4EA4");
		tijiaoButton.setIcon(new ImageIcon(CusdeposFrm.class.getResource("/images/Security - Admin.png")));
		tijiaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customdepoAddActionPerformed(e);
			}
		});
		tijiaoButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD  \u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		resetButton.setIcon(new ImageIcon(CusdeposFrm.class.getResource("/images/reset.png")));
		resetButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel ckjeLabel_1 = new JLabel("\u5B58\u6B3E\u6237\u540D\uFF1A");
		ckjeLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		idcard = customer.getCuIDCard();
		System.out.println("���ͻ����֤��"+idcard);
		
		ckkhtextField = new JTextField();
		ckkhtextField.setColumns(10);
		ckkhtextField.setText(customer.getCuAccount());
		
		ckjetextField = new JTextField();
		ckjetextField.setColumns(10);
		
		ckhmtextField = new JTextField();
		ckhmtextField.setColumns(10);
		ckhmtextField.setText(customer.getCuName());
		
		JLabel beizhuLabel = new JLabel("\u5907    \u6CE8\uFF1A");
		beizhuLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		beizhutextField = new JTextField();
		beizhutextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(tijiaoButton)
					.addGap(70)
					.addComponent(resetButton)
					.addGap(103))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(ckjeLabel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(ckjeLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(ckkhLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(beizhuLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(beizhutextField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(ckkhtextField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(ckjetextField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(ckhmtextField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addGap(80))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(ckkhLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(ckkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ckjeLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(ckjetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ckjeLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(ckhmtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(beizhutextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(beizhuLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tijiaoButton)
						.addComponent(resetButton))
					.addGap(36))
		);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8BBE  \u7F6E");
		mnNewMenu.setIcon(new ImageIcon(CusdeposFrm.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8FD4\u56DE",KeyEvent.VK_X);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CusoperaFrm cusoperaFrm = new CusoperaFrm(null);
				cusoperaFrm.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

	}
	
	/**
	 * ��Ӵ���¼�����
	 * @param e
	 */
	private void customdepoAddActionPerformed(ActionEvent evt) {
		String ckkhtextField=this.ckkhtextField.getText();
	
		String ckjetextField=new String(this.ckjetextField.getText());
		System.out.println("��ʽ��ǰ��"+ckjetextField);
		Double ckjetextField2 = Double.parseDouble(ckjetextField);
		System.out.println("��ʽ�����"+ckjetextField2);
		
		String ckhmtextField=new String(this.ckhmtextField.getText());
		String beizhutextField=new String(this.beizhutextField.getText());
		System.out.println("��ע��"+beizhutextField);
		String idcard=this.idcard;
		System.out.println("���֤��"+idcard);
		if(StringUtil.isEmpty(ckjetextField)){
			JOptionPane.showMessageDialog(null, "������Ϊ�գ�");
			return;
		}
		FundChange fundChange=new FundChange(ckhmtextField,idcard,ckkhtextField,ckjetextField2,beizhutextField);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=fundChangeDao.add(con, fundChange);
			int m=cusFundsDao.norsubupdate(con, ckjetextField2, ckkhtextField);
			if(n==1 && m==1){
				JOptionPane.showMessageDialog(null, "���ɹ���");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void resetValueActionPerformed(ActionEvent evt){
		this.ckjetextField.setText("");
		this.beizhutextField.setText("");
	}
	
	private void resetValue(){
		this.ckjetextField.setText("");
		this.beizhutextField.setText("");
	}

}
