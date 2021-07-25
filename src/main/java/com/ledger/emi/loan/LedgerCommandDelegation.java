package com.ledger.emi.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ledger.emi.model.CommandsEnum;
import com.ledger.emi.repositry.LoanRepositry;

@Component
public class LedgerCommandDelegation {

	@Autowired
	private LedgerCommandsExecution ledgerCommandsExecution;

	public String commandExecution(String command) {
		String[] commandSplit = command.split(" ");
		switch (CommandsEnum.valueOf(commandSplit[0])) {
		case BALANCE:
			return ledgerCommandsExecution.balanceCheck(commandSplit);
		case LOAN:
			ledgerCommandsExecution.loanCreation(commandSplit);
			break;
		case PAYMENT:
			ledgerCommandsExecution.lumpsumPayment(commandSplit);
			break;
		default:
			return null;
		}
		return command;
	}
}
