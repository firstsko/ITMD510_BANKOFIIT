package com.bank.model;

public class FundChange {
	

	private String id; 
	private String fu_cName; 
	private String fu_cIDCard; 
	private String fu_cAccount; 
	private String fu_cTAccount; 
	private double fu_cMoney;
	private String fu_cOperationcode;
	private String fu_cState;
	private String fu_cTime;
	private String fu_cRemark;
	
	
	
	public FundChange(String fu_cName, String fu_cIDCard, String fu_cAccount, double fu_cMoney, String fu_cRemark) {
		super();
		this.fu_cName = fu_cName;
		this.fu_cIDCard = fu_cIDCard;
		this.fu_cAccount = fu_cAccount;
		this.fu_cMoney = fu_cMoney;
		this.fu_cRemark = fu_cRemark;
	}




	public FundChange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public FundChange(String id, String fu_cName, String fu_cIDCard, String fu_cAccount, String fu_cTAccount,
			double fu_cMoney, String fu_cOperationcode, String fu_cState, String fu_cTime, String fu_cRemark) {
		super();
		this.id = id;
		this.fu_cName = fu_cName;
		this.fu_cIDCard = fu_cIDCard;
		this.fu_cAccount = fu_cAccount;
		this.fu_cTAccount = fu_cTAccount;
		this.fu_cMoney = fu_cMoney;
		this.fu_cOperationcode = fu_cOperationcode;
		this.fu_cState = fu_cState;
		this.fu_cTime = fu_cTime;
		this.fu_cRemark = fu_cRemark;
	}
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFu_cName() {
		return fu_cName;
	}



	public void setFu_cName(String fu_cName) {
		this.fu_cName = fu_cName;
	}



	public String getFu_cIDCard() {
		return fu_cIDCard;
	}



	public void setFu_cIDCard(String fu_cIDCard) {
		this.fu_cIDCard = fu_cIDCard;
	}



	public String getFu_cAccount() {
		return fu_cAccount;
	}



	public void setFu_cAccount(String fu_cAccount) {
		this.fu_cAccount = fu_cAccount;
	}



	public String getFu_cTAccount() {
		return fu_cTAccount;
	}



	public void setFu_cTAccount(String fu_cTAccount) {
		this.fu_cTAccount = fu_cTAccount;
	}



	public double getFu_cMoney() {
		return fu_cMoney;
	}



	public void setFu_cMoney(double fu_cMoney) {
		this.fu_cMoney = fu_cMoney;
	}



	public String getFu_cOperationcode() {
		return fu_cOperationcode;
	}



	public void setFu_cOperationcode(String fu_cOperationcode) {
		this.fu_cOperationcode = fu_cOperationcode;
	}



	public String getFu_cState() {
		return fu_cState;
	}



	public void setFu_cState(String fu_cState) {
		this.fu_cState = fu_cState;
	}



	public String getFu_cTime() {
		return fu_cTime;
	}



	public void setFu_cTime(String fu_cTime) {
		this.fu_cTime = fu_cTime;
	}



	public String getFu_cRemark() {
		return fu_cRemark;
	}



	public void setFu_cRemark(String fu_cRemark) {
		this.fu_cRemark = fu_cRemark;
	}




}
