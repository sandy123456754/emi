package com.ledger.emi.model;

public class LumpsumDetails {

	private String bankName;
	private String customerName;
	private Integer amount;
	private Integer emi;

	public LumpsumDetails(String bankName, String customerName, Integer amount, Integer emi) {
		this.bankName = bankName;
		this.customerName = customerName;
		this.amount = amount;
		this.emi = emi;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getEmi() {
		return emi;
	}

	public void setEmi(Integer emi) {
		this.emi = emi;
	}

}
