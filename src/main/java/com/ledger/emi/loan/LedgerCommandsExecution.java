package com.ledger.emi.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ledger.emi.model.BalanceCheck;
import com.ledger.emi.model.LoanDetails;
import com.ledger.emi.model.LumpsumDetails;
import com.ledger.emi.service.LoanService;

@Service
public class LedgerCommandsExecution implements EMIsInterface {

	@Autowired
	private LoanService loanService;

	@Override
	public String balanceCheck(String[] balanceCommand) {
		BalanceCheck balanceCheck = new BalanceCheck(balanceCommand[1], balanceCommand[2],
				Integer.parseInt(balanceCommand[3]));
		String output = loanService.balanceCheck(balanceCheck);
		System.out.println(output);
		return output;
	}

	@Override
	public void lumpsumPayment(String[] lumpsumCommand) {
		LumpsumDetails lumpsumDetails = new LumpsumDetails(lumpsumCommand[1], lumpsumCommand[2],
				Integer.parseInt(lumpsumCommand[3]), Integer.parseInt(lumpsumCommand[4]));
		loanService.lumpsumPayment(lumpsumDetails);
	}

	@Override
	public void loanCreation(String[] loanCommand) {
		LoanDetails loanDetails = LoanDetails.getBuilder().setBankName(loanCommand[1]).setCustomerName(loanCommand[2])
				.setAmount(Integer.parseInt(loanCommand[3])).setInterest(Float.parseFloat(loanCommand[5]))
				.setTerm(Float.parseFloat(loanCommand[4])).build();
		loanService.createLoan(loanDetails);
	}

}
