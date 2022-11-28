package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Customer;

public class CusVerifyDao {
	
	
/**
 * 
 * @param con
 * @param operator
 * @return
 * @throws Exception
 */
	public Customer login(Connection con,Customer customer)throws Exception{
		Customer resultUser=null;
		String sql="select * from huitu_customer where cuAccount=? and cuPassword=?";
		System.out.println(sql);
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, customer.getCuAccount());
		pstmt.setString(2, customer.getCuPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new Customer();
			resultUser.setId(rs.getString("id"));
			resultUser.setCuName(rs.getString("cuName"));
			resultUser.setCuPassword(rs.getString("cuPassword"));
			resultUser.setCuIDCard(rs.getString("cuIDCard"));
			resultUser.setCuAccount(rs.getString("cuAccount"));
			resultUser.setCuPhone(rs.getString("cuPhone"));
			resultUser.setCuAddress(rs.getString("cuAddress"));
		}
		return resultUser;
	}
	
	/**
	 * 
	 * @param con
	 * @param operator
	 * @return
	 * @throws Exception
	 */
		public Customer traVerify(Connection con,String cuAccount)throws Exception{
			Customer resultUser=null;
			String sql="select cuPassword from huitu_customer where cuAccount=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cuAccount);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				resultUser=new Customer();
				resultUser.setCuPassword(rs.getString("cuPassword"));
			}
			return resultUser;
		}

}
