package com.ty.service;

import java.util.List;

import com.ty.dto.TransactionDTO;
import com.ty.entity.Transaction;

public interface TransactionService {

    Transaction save(Transaction t);

    List<Transaction> getAll(Long userId);

    List<Transaction> getAllTransactions();

	Transaction save(TransactionDTO dto);

}