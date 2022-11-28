package com.bank.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bank.dao.BankInfoDao;
import com.bank.dao.TrinterDao;
import com.bank.model.BankInfo;
import com.bank.model.Trinter;
import com.bank.util.DbUtil;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class QueryTraferFrm extends JInternalFrame {
	
	private DbUtil dbUtil=new DbUtil();
	private TrinterDao trinterDao=new TrinterDao();
	private BankInfoDao bankInfoDao =new BankInfoDao();
	
	private JComboBox yhbhcomboBox;
	private JTextField hkkhtextField;
	private JTextField skkhtextField;
	private JTable showtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryTraferFrm frame = new QueryTraferFrm();
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
	public QueryTraferFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Query Transfer Records");
		setBounds(100, 100, 996, 449);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 923, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		showtable = new JTable();
		showtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "OP Code", "Bank Code", "OP Type", "Source Account", "Target Account", "Transfer Amount", "Transfer Interface", "Transfer Time"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Double.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		showtable.getColumnModel().getColumn(4).setPreferredWidth(150);
		showtable.getColumnModel().getColumn(5).setPreferredWidth(150);
		showtable.getColumnModel().getColumn(6).setPreferredWidth(80);
		showtable.getColumnModel().getColumn(8).setPreferredWidth(135);
		scrollPane.setViewportView(showtable);
		
		JLabel lblNewLabel = new JLabel("\u6C47\u6B3E\u5361\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		hkkhtextField = new JTextField();
		hkkhtextField.setColumns(10);
		
		skkhtextField = new JTextField();
		skkhtextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6536\u6B3E\u5361\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		 yhbhcomboBox = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("\u94F6\u884C\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JButton queryButton = new JButton("QUERY");
		queryButton.setIcon(new ImageIcon(QueryTraferFrm.class.getResource("/images/Misc - search.png")));
		queryButton.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(hkkhtextField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(skkhtextField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblNewLabel_2)
					.addGap(4)
					.addComponent(yhbhcomboBox, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(781, Short.MAX_VALUE)
					.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(hkkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(skkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(yhbhcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(queryButton)
					.addGap(4))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillBankInfoType("search");
		/* this.fillTable(new Trinter()); */
	}
	
	/**
	 * @param type
	 */
	private void fillBankInfoType(String type){
		Connection con=null;
		BankInfo bankInfo=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bankInfoDao.list(con, new BankInfo());
			if("search".equals(type)){
				bankInfo=new BankInfo();
				bankInfo.setBankName("«Î—°‘Ò...");
				bankInfo.setId(-1);
				System.out.println(bankInfo.getBankName());
				this.yhbhcomboBox.addItem(bankInfo.getBankName());
			}
			while(rs.next()){
				bankInfo=new BankInfo();
				bankInfo.setId(rs.getInt("id"));
				bankInfo.setBankName(rs.getString("bankName"));
				bankInfo.setBankNum(rs.getString("bankNum"));
				if("search".equals(type)){
					System.out.println("chade:"+bankInfo.getBankName());
					this.yhbhcomboBox.addItem(bankInfo.getBankName());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * @param book
	 */
	/*
	private void fillTable(Trinter trinter){
		DefaultTableModel dtm=(DefaultTableModel) showtable.getModel();
		dtm.setRowCount(0); //
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=trinterDao.list(con, trinter);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("tr_iNumber"));
				v.add(rs.getString("tr_iBank"));
				v.add(rs.getString("tr_iOper"));
				v.add(rs.getString("tr_iAccount"));
				v.add(rs.getString("tr_iTAccount"));
				v.add(rs.getString("tr_iMoney"));
				v.add(rs.getString("tr_inter"));
				v.add(rs.getString("tr_time"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	  */
}
