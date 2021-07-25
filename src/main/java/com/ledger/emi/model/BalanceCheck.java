package com.ledger.emi.model;

public class BalanceCheck {

	private String bankName;
	private String customerName;
	private Integer emis;

	public BalanceCheck(String bankName, String customerName, Integer emis) {
		super();
		this.bankName = bankName;
		this.customerName = customerName;
		this.emis = emis;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getEmis() {
		return emis;
	}

	public void setEmis(Integer emis) {
		this.emis = emis;
	}

}
