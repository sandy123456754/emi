package com.ledger.emi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ledger.emi.entities.LoanEntity;
import com.ledger.emi.entities.TransactionEntity;
import com.ledger.emi.model.BalanceCheck;
import com.ledger.emi.model.LoanDetails;
import com.ledger.emi.model.LumpsumDetails;
import com.ledger.emi.repositry.LoanRepositry;
import com.ledger.emi.repositry.TransactionRepositry;
//./src/main/java/com/ledger/emi/inputfile.txt
@Service
public class LoanService {

	@Autowired
	private LoanRepositry loanRepositry;

	@Autowired
	private TransactionRepositry transactionRepositry;

	public void createLoan(LoanDetails loanDetails) {
		Integer amount = loanDetails.getPricipalAmount();
		Float interest = loanDetails.getInterest();
		Float term = loanDetails.getTerm();
		Integer totalAmount = (int) Math.ceil((double)(amount + (amount * (interest / 100) * term)));
		LoanEntity loanEntity = new LoanEntity(loanDetails.getBankName(), loanDetails.getCustomerName(),
				loanDetails.getPricipalAmount(), loanDetails.getInterest(), loanDetails.getTerm());
		loanEntity.setTotalAmount(totalAmount);
		loanEntity.setTotalEmis((float) (term * 12.0));
		loanEntity.setEmiAmount((int) Math.ceil((double)(totalAmount/(term * 12))));
		System.out.println(loanEntity);
		loanRepositry.save(loanEntity);
		
	}

	public void lumpsumPayment(LumpsumDetails lumpsumDetails) {
		transactionRepositry.save(new TransactionEntity(lumpsumDetails.getEmi(), lumpsumDetails.getAmount(),
				lumpsumDetails.getBankName() + " " + lumpsumDetails.getCustomerName()));
	}

	public String balanceCheck(BalanceCheck balanceCheck) {
		String id = balanceCheck.getBankName() + " " + balanceCheck.getCustomerName();
		List<TransactionEntity> transactionEntities = transactionRepositry.findByLoan(id);
		Optional<LoanEntity> loanEntity = loanRepositry.findById(id);
		Integer loanAmount = loanEntity.get().getTotalAmount();
		Integer emiAmountPerMonth = loanEntity.get().getEmiAmount() ;
		loanAmount -= balanceCheck.getEmis() * emiAmountPerMonth;
		for (TransactionEntity transactionEntity : transactionEntities) {
			if (transactionEntity.getEmi() <= balanceCheck.getEmis()) {
				loanAmount -= transactionEntity.getAmount();
			}
		}
		Integer paidAmount = (int) Math.ceil((double)(loanEntity.get().getTotalAmount() - loanAmount)) ;
		id += " " + paidAmount;
		Integer d = (int) Math.ceil((double)(loanAmount / (double)(emiAmountPerMonth)));
		id += " " + d;
		return id;

	}

}
