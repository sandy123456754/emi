package com.ledger.emi.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ledger.emi.entities.LoanEntity;
@Repository
public interface LoanRepositry extends JpaRepository<LoanEntity, String>{

}
