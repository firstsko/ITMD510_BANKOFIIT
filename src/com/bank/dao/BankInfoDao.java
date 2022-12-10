package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.BankInfo;
import com.bank.util.StringUtil;

public class BankInfoDao {
	
	/**
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BankInfo bankInfo)throws Exception{
		StringBuffer sb=new StringBuffer("select * from huitu_bankinfo");
		if(StringUtil.isNotEmpty(bankInfo.getBankName())){
			sb.append(" and bankName like '%"+bankInfo.getBankName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

}
