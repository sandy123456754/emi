package com.ledger.emi.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ledger.emi.entities.TransactionEntity;

@Repository
public interface TransactionRepositry extends JpaRepository<TransactionEntity, Long>{
	
	public List<TransactionEntity> findByLoan(String loan);

}
