package com.ty.service;

import java.util.List;

import com.ty.dto.TransactionDTO;
import com.ty.entity.Transaction;

public interface TransactionService {

    Transaction save(TransactionDTO dto);

    List<Transaction> getAllTransactions();

    Transaction getById(Long id);

    Transaction update(Long id, TransactionDTO dto);

    void delete(Long id);

}