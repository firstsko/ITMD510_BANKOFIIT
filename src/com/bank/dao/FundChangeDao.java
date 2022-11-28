package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bank.model.FundChange;

/**
 * 存款业务Dao
 * @author Administrator
 *
 */
public class FundChangeDao {
	
	/**
	 * 客户资金变更表添加(存款)
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,FundChange fundChange)throws Exception{
		String sql="insert into fund_change (fu_cName,fu_cIDCard,fu_cAccount,"
				+ "fu_cTAccount,fu_cMoney,fu_cOperationcode,fu_cState,fu_cRemark)"
				+ " values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, fundChange.getFu_cName());
		pstmt.setString(2, fundChange.getFu_cIDCard());
		pstmt.setString(3, fundChange.getFu_cAccount());
		pstmt.setString(4, null);
		pstmt.setDouble(5, fundChange.getFu_cMoney());
		pstmt.setString(6, "CK500");
		pstmt.setString(7, "success");
		pstmt.setString(8, fundChange.getFu_cRemark());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 客户资金变更表添加(存款)
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int qkadd(Connection con,FundChange fundChange)throws Exception{
		String sql="insert into huitu_fund_change (fu_cName,fu_cIDCard,fu_cAccount,"
				+ "fu_cTAccount,fu_cMoney,fu_cOperationcode,fu_cState,fu_cRemark)"
				+ " values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, fundChange.getFu_cName());
		pstmt.setString(2, fundChange.getFu_cIDCard());
		pstmt.setString(3, fundChange.getFu_cAccount());
		pstmt.setString(4, null);
		pstmt.setDouble(5, fundChange.getFu_cMoney());
		pstmt.setString(6, "QK500");
		pstmt.setString(7, "success");
		pstmt.setString(8, fundChange.getFu_cRemark());
		return pstmt.executeUpdate();
	}

}
