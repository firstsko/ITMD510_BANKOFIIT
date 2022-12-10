package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.CusFunds;
import com.bank.util.StringUtil;

public class CusFundsDao {
	
	/**
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public int noraddupdate(Connection con,double balance,String AccoutID)throws Exception{
		String sql="update huitu_customer_funds set TotalFunds=TotalFunds-? where cu_fAccount=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1,balance);
		pstmt.setString(2,AccoutID);
		return pstmt.executeUpdate();
	}
	
	/**
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public int norsubupdate(Connection con,double balance,String AccoutID)throws Exception{
		String sql="update huitu_customer_funds set TotalFunds=TotalFunds+? where cu_fAccount=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1,balance);
		pstmt.setString(2,AccoutID);
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * @param con
	 * @param cusFunds
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,CusFunds cusFunds)throws Exception{
		StringBuffer sb=new StringBuffer("select * from huitu_customer_funds");
		if(StringUtil.isNotEmpty(cusFunds.getCu_fAccount())){
			sb.append(" and cu_fAccount ="+cusFunds.getCu_fAccount().trim()+"");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	/**
	 * @param con
	 * @param cusFunds
	 * @return
	 * @throws Exception
	 */
	public int frozeupdate(Connection con,CusFunds cusFunds)throws Exception{
		String sql="update huitu_customer_funds set TotalFunds=?,FrozenCapital=? where cu_fAccount=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1,0.00);
		pstmt.setDouble(2,cusFunds.getTotalFunds());
		pstmt.setString(3,cusFunds.getCu_fAccount());
		return pstmt.executeUpdate();
	}
	
	/**
	 * @param con
	 * @param cusFunds
	 * @return
	 * @throws Exception
	 */
	public int unfreupdate(Connection con,CusFunds cusFunds)throws Exception{
		String sql="update huitu_customer_funds set TotalFunds=?,FrozenCapital=? where cu_fAccount=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDouble(1,cusFunds.getFrozenCapital());
		pstmt.setDouble(2,0.00);
		pstmt.setString(3,cusFunds.getCu_fAccount());
		return pstmt.executeUpdate();
	}
}
