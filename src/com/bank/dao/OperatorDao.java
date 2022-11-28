package com.bank.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Operator;;


/**
 * 用户Dao类
 * @author Administrator
 *
 */
public class OperatorDao {

	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Operator login(Connection con,Operator operator)throws Exception{
		Operator resultUser=null;
		String sql="select * from huitu_operator where opName=? and opPassword=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, operator.getOpName());
		pstmt.setString(2, operator.getOpPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new Operator();
			resultUser.setId(rs.getString("id"));
			resultUser.setOpName(rs.getString("opName"));
			resultUser.setOpPassword(rs.getString("opPassword"));
		}
		return resultUser;
	}
}
