package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Trinter;
import com.bank.util.StringUtil;

/***
 * 转账接口Dao类
 * @author 
 *
 */
public class TrinterDao {
	
	
	/**
	 * 转账记录添加
	 * @param con
	 * @param trinter
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Trinter trinter,String money)throws Exception{
		String sql="INSERT INTO huitu_transfer_interface(tr_iNumber,tr_iBank,tr_iOper,tr_iAccount,tr_iTAccount,tr_iMoney,tr_inter) VALUES" +
				"(concat('ZZ500','BJ01',"+trinter.getTr_iAccount()+","+trinter.getTr_iTAccount()+","+money+",'JK01',ceiling(rand()*100+100)),?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "BJ01");
		pstmt.setString(2, "ZZ500");
		pstmt.setString(3, trinter.getTr_iAccount());
		pstmt.setString(4, trinter.getTr_iTAccount());
		pstmt.setDouble(5, trinter.getTr_iMoney());
		pstmt.setString(6, "JK01");
		return pstmt.executeUpdate();
	}
	
	/**
	 * 转账 信息查询
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Trinter trinter)throws Exception{
		StringBuffer sb=new StringBuffer("select * from huitu_transfer_interface ti,huitu_bankinfo bi where ti.tr_iBank=bi.bankNum");
		System.out.println(sb);
		if(StringUtil.isNotEmpty(trinter.getTr_iAccount())){
			sb.append(" and ti.tr_iAccount = '"+trinter.getTr_iAccount()+"'");
		}
		if(StringUtil.isNotEmpty(trinter.getTr_iTAccount())){
			sb.append(" and ti.tr_iTAccount = '"+trinter.getTr_iTAccount()+"'");
		}
		if(trinter.getTr_iBank()!=null && trinter.getTr_iBank()!="请选择"){
			sb.append(" and ti.tr_iBank = '"+trinter.getTr_iBank()+"'");
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

}
