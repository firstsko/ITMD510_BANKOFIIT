package com.bank.model;

public class Customer {
	
	private String cuName;
	private String cuPassword;
	private String cuIDCard;
	private String cuAccount;
	private String cuPhone;
	private String cuAddress;
	private String id;
	
	public Customer(String cuAccount, String cuPassword) {
		super();
		this.cuPassword = cuPassword;
		this.cuAccount = cuAccount;
	}
	public Customer() {
		super();
	}
	
	public Customer(String cuName, String cuPassword, String cuIDCard, String cuAccount, String cuPhone,
			String cuAddress, String id) {
		super();
		this.cuName = cuName;
		this.cuPassword = cuPassword;
		this.cuIDCard = cuIDCard;
		this.cuAccount = cuAccount;
		this.cuPhone = cuPhone;
		this.cuAddress = cuAddress;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCuName() {
		return cuName;
	}
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	public String getCuPassword() {
		return cuPassword;
	}
	public void setCuPassword(String cuPassword) {
		this.cuPassword = cuPassword;
	}
	public String getCuIDCard() {
		return cuIDCard;
	}
	public void setCuIDCard(String cuIDCard) {
		this.cuIDCard = cuIDCard;
	}
	public String getCuAccount() {
		return cuAccount;
	}
	public void setCuAccount(String cuAccount) {
		this.cuAccount = cuAccount;
	}
	public String getCuPhone() {
		return cuPhone;
	}
	public void setCuPhone(String cuPhone) {
		this.cuPhone = cuPhone;
	}
	public String getCuAddress() {
		return cuAddress;
	}
	public void setCuAddress(String cuAddress) {
		this.cuAddress = cuAddress;
	}

	


}
