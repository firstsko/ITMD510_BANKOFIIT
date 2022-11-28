package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bank.dao.CusFundsDao;
import com.bank.dao.FundChangeDao;
import com.bank.model.CusFunds;
import com.bank.util.DbUtil;
import com.bank.util.StringUtil;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class QueryCusfdFrm extends JInternalFrame {
	
	private DbUtil dbUtil=new DbUtil();
	private CusFundsDao cusFundsDao=new CusFundsDao();
	
	private JTable cusfdstable;
	private JTextField yhkhtextField;
	private JTextField xuhaotextField;
	private JTextField accounttextField;
	private JTextField totaltextField;
	private JTextField frozetextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryCusfdFrm frame = new QueryCusfdFrm();
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
	public QueryCusfdFrm() {
		setTitle("Client Funds Operation");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 615, 585);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Account Card No.");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		yhkhtextField = new JTextField();
		yhkhtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("QUERY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusfundsSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(QueryCusfdFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBorder(new TitledBorder(null, "Frozen Capital Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(yhkhtextField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton)))
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(yhkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		xuhaotextField = new JTextField();
		xuhaotextField.setEditable(false);
		xuhaotextField.setColumns(10);
		
		JLabel label = new JLabel("Account Card No.");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		
		accounttextField = new JTextField();
		accounttextField.setEditable(false);
		accounttextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		totaltextField = new JTextField();
		totaltextField.setEditable(false);
		totaltextField.setColumns(10);
		
		JLabel label_1 = new JLabel("Frozen Capital");
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		frozetextField = new JTextField();
		frozetextField.setEditable(false);
		frozetextField.setColumns(10);
		
		JButton dongjieButton = new JButton("Freeze");
		dongjieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frozenUpdateActionEvent(e);
			}
		});
		dongjieButton.setFont(new Font("Arial", Font.PLAIN, 16));
		dongjieButton.setIcon(new ImageIcon(QueryCusfdFrm.class.getResource("/images/Security - Denied.png")));
		
		JButton btnNewButton_2 = new JButton("Unfreeze");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unfreUpdateActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(QueryCusfdFrm.class.getResource("/images/Misc - lock-open.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(xuhaotextField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(accounttextField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(4)
							.addComponent(totaltextField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(label_1)
							.addGap(3)
							.addComponent(frozetextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(dongjieButton)
							.addGap(45)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(xuhaotextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(accounttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addComponent(totaltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addComponent(label_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(frozetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, Alignment.TRAILING)
						.addComponent(dongjieButton, Alignment.TRAILING))
					.addGap(15))
		);
		panel.setLayout(gl_panel);
		
		cusfdstable = new JTable();
		cusfdstable.setBackground(new Color(250, 235, 215));
		cusfdstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cusfdstableMousePressed(e);
			}
		});
		cusfdstable.setFont(new Font("Arial", Font.PLAIN, 16));
		cusfdstable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Account Card No.", "Balance", "Frozen Capital"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		cusfdstable.getColumnModel().getColumn(1).setPreferredWidth(191);
		cusfdstable.getColumnModel().getColumn(2).setPreferredWidth(85);
		cusfdstable.getColumnModel().getColumn(3).setPreferredWidth(85);
		scrollPane.setViewportView(cusfdstable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new CusFunds());

	}
	
	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void cusfdstableMousePressed(MouseEvent evt) {
		int row=cusfdstable.getSelectedRow();
		xuhaotextField.setText((String)cusfdstable.getValueAt(row, 0));
		accounttextField.setText((String)cusfdstable.getValueAt(row, 1));
		totaltextField.setText((String)cusfdstable.getValueAt(row, 2));
		frozetextField.setText((String)cusfdstable.getValueAt(row, 3));
	}

 	/**
	 * 客户资金查询搜索事件处理
	 * @param evt
	 */
	private void cusfundsSearchActionPerformed(ActionEvent evt) {
		String yhkhtextField=this.yhkhtextField.getText();
		CusFunds cusFunds=new CusFunds();
		cusFunds.setCu_fAccount(yhkhtextField);
		this.fillTable(cusFunds);
	}
	
	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(CusFunds cusFunds){
		DefaultTableModel dtm=(DefaultTableModel) cusfdstable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=cusFundsDao.list(con, cusFunds);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("cu_fAccount"));
				v.add(rs.getString("TotalFunds"));
				v.add(rs.getString("FrozenCapital"));
				dtm.addRow(v);
			}
		}catch(Exception e){
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
	 * 冻结资金修改事件处理
	 * @param evt
	 */
	private void frozenUpdateActionEvent(ActionEvent evt) {
		String accounttextField=this.accounttextField.getText();
		String totaltextField=this.totaltextField.getText();
		String frozetextField=this.frozetextField.getText();
		if(StringUtil.isEmpty(accounttextField)){
			JOptionPane.showMessageDialog(null, "请选择要冻结的卡号");
			return;
		}
		/*
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		*/
		CusFunds cusFunds=new CusFunds(accounttextField,
				Double.parseDouble(totaltextField),
				Double.parseDouble(frozetextField));
		Connection con=null;
		try{
			if(Double.parseDouble(totaltextField)==0.00) {
				JOptionPane.showMessageDialog(null, "冻结失败,可冻结金额不足");
			}else {
			con=dbUtil.getCon();
			int modifyNum=cusFundsDao.frozeupdate(con, cusFunds);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "冻结成功");
				this.resetValue();
				this.fillTable(new CusFunds());
			}else{
				JOptionPane.showMessageDialog(null, "冻结失败,可冻结金额不足");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "冻结失败");
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
	 * 冻结资金修改事件处理
	 * @param evt
	 */
	private void unfreUpdateActionEvent(ActionEvent evt) {
		String accounttextField=this.accounttextField.getText();
		String totaltextField=this.totaltextField.getText();
		String frozetextField=this.frozetextField.getText();
		if(StringUtil.isEmpty(accounttextField)){
			JOptionPane.showMessageDialog(null, "请选择要解冻的卡号");
			return;
		}
		/*
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		*/
		CusFunds cusFunds=new CusFunds(accounttextField,
				Double.parseDouble(totaltextField),
				Double.parseDouble(frozetextField));
		Connection con=null;
		try{
			if(Double.parseDouble(frozetextField)==0.00) {
				JOptionPane.showMessageDialog(null, "可解冻资金为0?无需解冻");
			}else {
			con=dbUtil.getCon();
			int modifyNum=cusFundsDao.unfreupdate(con, cusFunds);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "解冻成功");
				this.resetValue();
				this.fillTable(new CusFunds());
			}else{
				JOptionPane.showMessageDialog(null, "解冻失败");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "解冻失败");
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
	 * 重置表单
	 */
	private void resetValue(){
		this.accounttextField.setText("");
		this.totaltextField.setText("");
		this.frozetextField.setText("");
		this.xuhaotextField.setText("");
	}
}
