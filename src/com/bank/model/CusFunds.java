package com.bank.model;

public class CusFunds {
	

	private String id; // id
	private String cu_fAccount;
	private double TotalFunds;
	private double FrozenCapital;
	
	
	public CusFunds(String cu_fAccount, double totalFunds, double frozenCapital) {
		super();
		this.cu_fAccount = cu_fAccount;
		TotalFunds = totalFunds;
		FrozenCapital = frozenCapital;
	}
	



	public CusFunds(String id, String cu_fAccount, double totalFunds, double frozenCapital) {
		super();
		this.id = id;
		this.cu_fAccount = cu_fAccount;
		TotalFunds = totalFunds;
		FrozenCapital = frozenCapital;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCu_fAccount() {
		return cu_fAccount;
	}


	public void setCu_fAccount(String cu_fAccount) {
		this.cu_fAccount = cu_fAccount;
	}


	public double getTotalFunds() {
		return TotalFunds;
	}


	public void setTotalFunds(double totalFunds) {
		TotalFunds = totalFunds;
	}


	public double getFrozenCapital() {
		return FrozenCapital;
	}


	public void setFrozenCapital(double frozenCapital) {
		FrozenCapital = frozenCapital;
	}


	
	
	public CusFunds() {
		super();
		// TODO Auto-generated constructor stub
	}



}
