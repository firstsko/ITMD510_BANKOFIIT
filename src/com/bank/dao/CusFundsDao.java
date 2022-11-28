package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.CusFunds;
import com.bank.util.StringUtil;

public class CusFundsDao {
	
	/**
	 * 更新账户资金?取款?
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
	 * 更新账户资金?存款?
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
	 * 查询客户资金情况
	 * @param con
	 * @param cusFunds
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,CusFunds cusFunds)throws Exception{
		StringBuffer sb=new StringBuffer("select * from huitu_customer_funds");
		if(StringUtil.isNotEmpty(cusFunds.getCu_fAccount())){
			//先用and 为后续多个条件方便使用
			sb.append(" and cu_fAccount ="+cusFunds.getCu_fAccount().trim()+"");
		}
		//替换语句 将and 处理转为where
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	/**
	 * 冻结客户资金
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
	 * 解冻客户资金
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
