package com.ledger.emi.loan;

public interface EMIsInterface {

	public String balanceCheck(String[] balanceCommand);

	public void lumpsumPayment(String[] lumpsumCommand);

	public void loanCreation(String[] loanCommand);
}
