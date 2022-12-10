package com.bank.util;


/**
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	


	public static boolean isEmpty(Double balance) {
		if(balance!=null && !"".equals(balance)){
			return true;
		}else{
			return false;
		}
	}


	/**
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}

	
}
