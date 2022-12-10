package com.bank.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bank.dao.BankInfoDao;
import com.bank.dao.TrinterDao;
import com.bank.model.BankInfo;
import com.bank.model.CusFunds;
import com.bank.model.Trinter;
import com.bank.util.DbUtil;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;

public class QueryTraferFram extends JInternalFrame {
	private JTable showtable;
	private DbUtil dbUtil=new DbUtil();
	private TrinterDao trinterDao=new TrinterDao();
	private BankInfoDao bankInfoDao =new BankInfoDao();
	private JTextField skkhtextField;
	private JTextField hkkhtextField;
	private JComboBox bankNumcBox ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryTraferFram frame = new QueryTraferFram();
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
	public QueryTraferFram() {
		setTitle("Query Transfer Records");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1015, 472);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 969, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		
		JLabel lblNewLabel = new JLabel("Source Account");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		skkhtextField = new JTextField();
		skkhtextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Target Account");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		hkkhtextField = new JTextField();
		hkkhtextField.setColumns(10);
		
		bankNumcBox = new JComboBox();
		
		JButton btnNewButton = new JButton("Query");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(QueryTraferFram.class.getResource("/images/Misc - search.png")));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Bank Code");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(skkhtextField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hkkhtextField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addComponent(bankNumcBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(skkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(hkkhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(bankNumcBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		showtable = new JTable();
		showtable.setBackground(new Color(255, 182, 193));
		showtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "OP Code", "Bank Code", "OP Type", "Source Account", "Target Account", "Transfer Amount", "Transfer Interface", "Transfer Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		showtable.getColumnModel().getColumn(1).setPreferredWidth(180);
		showtable.getColumnModel().getColumn(4).setPreferredWidth(127);
		scrollPane.setViewportView(showtable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Trinter());
		this.fillBankType("search");

	}
	
	
	/**
	 * @param type
	 */
	private void fillBankType(String type){
		Connection con=null;
		BankInfo bankInfo=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bankInfoDao.list(con, new BankInfo());
			if("search".equals(type)){
				bankInfo=new BankInfo();
				bankInfo.setBankNum("Select Bank");
				bankInfo.setId(-1);
				System.out.println(bankInfo.getBankName());
				this.bankNumcBox.addItem(bankInfo.getBankNum());
			}
			while(rs.next()){
				bankInfo=new BankInfo();
				bankInfo.setId(rs.getInt("id"));
				bankInfo.setBankName(rs.getString("bankName"));
				bankInfo.setBankNum(rs.getString("bankNum"));
				if("search".equals(type)){
					System.out.println(" "+bankInfo.getBankName()+" "+bankInfo.getBankNum());
					this.bankNumcBox.addItem(bankInfo.getBankNum());
				}
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
	 * @param bookType
	 */
	private void fillTable(Trinter trinter){
		String bn = trinter.getTr_iBank();
		System.out.println(bn);
		DefaultTableModel dtm=(DefaultTableModel) showtable.getModel();
		dtm.setRowCount(0);
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
	
	/**
	 * @param e
	 */
	private void bankSearchActionPerformed(ActionEvent evt) {
		String skkhtextField=this.skkhtextField.getText();
		String hkkhtextField=this.hkkhtextField.getText();

		String bnu = (String) this.bankNumcBox.getSelectedItem();
		System.out.println(bnu);

		
		Trinter trinter=new Trinter(bnu,skkhtextField,hkkhtextField);
		this.fillTable(trinter);
	}
}
