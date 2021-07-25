package com.ledger.emi.model;

public class LoanDetails {

	private String bankName;
	private String customerName;
	private Integer pricipalAmount;
	private Float interest;
	private Float term;

	public LoanDetails(LoanBuilder builder) {
		this.bankName = builder.bankName;
		this.customerName = builder.customerName;
		this.pricipalAmount = builder.pricipalAmount;
		this.interest = builder.interest;
		this.term = builder.years;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Float getTerm() {
		return term;
	}

	public void setTerm(Float term) {
		this.term = term;
	}

	public static LoanBuilder getBuilder() {
		return new LoanBuilder();
	}

	public static class LoanBuilder {

		private String bankName;
		private String customerName;
		private Integer pricipalAmount;
		private Float interest;
		private Float years;

		public LoanBuilder setBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}

		public LoanBuilder setCustomerName(String customerName) {
			this.customerName = customerName;
			return this;
		}

		public LoanBuilder setAmount(Integer amount) {
			this.pricipalAmount = amount;
			return this;
		}

		public LoanBuilder setInterest(Float interest) {
			this.interest = interest;
			return this;
		}

		public LoanBuilder setTerm(Float term) {
			this.years = term;
			return this;
		}

		public LoanDetails build() {
			return new LoanDetails(this);
		}
	}

}
