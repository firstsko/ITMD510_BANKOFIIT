package com.bank.util;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Administrator
 *
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://www.papademas.net:3307/510fp?useUnicode=true&characterEncoding=utf8";
	private String dbUserName="fp510";
	private String dbPassword="510";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("2");
		}
	}
	
}
