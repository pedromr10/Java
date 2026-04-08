package com.pedro.picpaychallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.picpaychallenge.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
