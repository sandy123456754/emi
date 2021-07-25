package com.ledger.emi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Loan")
@Table(name = "Loan")
public class LoanEntity {

	@Id
	private String id;
	private String bankName;
	private String customerName;
	private Integer pricipalAmount;
	private Float interest;
	private Float term;
	private Integer totalAmount;
	private Float totalEmis;
	private Integer emiAmount;

	public Integer getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Integer emiAmount) {
		this.emiAmount = emiAmount;
	}

	public LoanEntity() {
		super();
	}

	public LoanEntity(String bankName, String customerName, Integer pricipalAmount, Float interest, Float term) {
		super();
		this.bankName = bankName;
		this.customerName = customerName;
		this.pricipalAmount = pricipalAmount;
		this.interest = interest;
		this.term = term;
		this.id = bankName + " " + customerName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getPricipalAmount() {
		return pricipalAmount;
	}

	public void setPricipalAmount(Integer pricipalAmount) {
		this.pricipalAmount = pricipalAmount;
	}

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Float getTerm() {
		return term;
	}

	public void setTerm(Float term) {
		this.term = term;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Float getTotalEmis() {
		return totalEmis;
	}

	public void setTotalEmis(Float totalEmis) {
		this.totalEmis = totalEmis;
	}

	@Override
	public String toString() {
		return "LoanEntity [id=" + id + ", bankName=" + bankName + ", customerName=" + customerName
				+ ", pricipalAmount=" + pricipalAmount + ", interest=" + interest + ", term=" + term + ", totalAmount="
				+ totalAmount + ", totalEmis=" + totalEmis + "emi amount = "+ emiAmount+ "]";
	}

}
