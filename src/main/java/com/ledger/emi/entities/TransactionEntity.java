package com.ledger.emi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Transaction")
@Table(name = "Transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer emi;
	private Integer amount;
	private String loan;

	public TransactionEntity() {
		super();
	}

	public TransactionEntity(Integer emi, Integer amount, String loan) {
		this.emi = emi;
		this.amount = amount;
		this.loan = loan;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmi() {
		return emi;
	}

	public void setEmi(Integer emi) {
		this.emi = emi;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", emi=" + emi + ", amount=" + amount + ", loanEntity=" + loan
				+ "]";
	}

}
