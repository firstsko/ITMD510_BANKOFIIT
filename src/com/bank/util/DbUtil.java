package com.bank.util;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://www.papademas.net:3307/510fp?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	private String dbUserName="fp510"; // 用户名
	private String dbPassword="510"; // 密码
	private String jdbcName="com.mysql.jdbc.Driver"; // 驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接成功?");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
}
