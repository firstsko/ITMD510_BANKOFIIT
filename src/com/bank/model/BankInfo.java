package com.bank.model;

public class BankInfo {
	
	private int id; // id
	private String bankNum; // ���б��
	private String bankName; // ��������
	
	public BankInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankInfo(String bankName) {
		super();
		this.bankName = bankName;
	}

	public BankInfo(int id, String bankNum, String bankName) {
		super();
		this.id = id;
		this.bankNum = bankNum;
		this.bankName = bankName;
	}
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


}
