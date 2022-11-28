package com.bank.model;

public class Trinter {
	
	private String id; 
	private String tr_iNumber; 
	private String tr_iBank; 
	private String tr_iOper; 
	private String tr_iAccount; 
	private double tr_iMoney;
	private String tr_iTAccount;
	private String tr_inter;
	private String tr_time;
	
	
	
	public Trinter(String bankNum) {
		super();
		this.tr_iBank = bankNum;
	}

	public Trinter() {
		super();
	}
	
	public Trinter(String tr_iBank, String tr_iAccount, String tr_iTAccount) {
		super();
		this.tr_iBank = tr_iBank;
		this.tr_iAccount = tr_iAccount;
		this.tr_iTAccount = tr_iTAccount;
	}

	public Trinter(String tr_iAccount, String tr_iTAccount,double tr_iMoney) {
		super();
		this.tr_iAccount = tr_iAccount;
		this.tr_iMoney = tr_iMoney;
		this.tr_iTAccount = tr_iTAccount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTr_iNumber() {
		return tr_iNumber;
	}
	public void setTr_iNumber(String tr_iNumber) {
		this.tr_iNumber = tr_iNumber;
	}
	public String getTr_iBank() {
		return tr_iBank;
	}
	public void setTr_iBank(String tr_iBank) {
		this.tr_iBank = tr_iBank;
	}
	public String getTr_iOper() {
		return tr_iOper;
	}
	public void setTr_iOper(String tr_iOper) {
		this.tr_iOper = tr_iOper;
	}
	public String getTr_iAccount() {
		return tr_iAccount;
	}
	public void setTr_iAccount(String tr_iAccount) {
		this.tr_iAccount = tr_iAccount;
	}
	public double getTr_iMoney() {
		return tr_iMoney;
	}
	public void setTr_iMoney(double tr_iMoney) {
		this.tr_iMoney = tr_iMoney;
	}
	public String getTr_iTAccount() {
		return tr_iTAccount;
	}
	public void setTr_iTAccount(String tr_iTAccount) {
		this.tr_iTAccount = tr_iTAccount;
	}
	public String getTr_inter() {
		return tr_inter;
	}
	public void setTr_inter(String tr_inter) {
		this.tr_inter = tr_inter;
	}
	public String getTr_time() {
		return tr_time;
	}
	public void setTr_time(String tr_time) {
		this.tr_time = tr_time;
	}


}
