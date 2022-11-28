package com.bank.model;

/**
 * @author
 *
 */
public class Operator {
	
	private String id; // ���
	private String opName; // �û���
	private String opPassword; // ����
	private String department; // ����

	public Operator(String opName, String opPassword, String department) {
		super();
		this.opName = opName;
		this.opPassword = opPassword;
		this.department = department;
	}
	public Operator(String opName, String opPassword) {
		super();
		this.opName = opName;
		this.opPassword = opPassword;
	}

	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getOpPassword() {
		return opPassword;
	}

	public void setOpPassword(String opPassword) {
		this.opPassword = opPassword;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
