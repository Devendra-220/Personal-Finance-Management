package com.ty.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.dto.TransactionDTO;
import com.ty.entity.Transaction;
import com.ty.repository.TransactionRepository;
import com.ty.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repo;

    public TransactionServiceImpl(TransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Transaction save(TransactionDTO dto) {

        Transaction transaction = new Transaction();

        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());

        return repo.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {

        return repo.findAll();
    }

    @Override
    public Transaction getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID : " + id));
    }

    @Override
    public Transaction update(Long id, TransactionDTO dto) {

        Transaction transaction = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID : " + id));

        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());

        return repo.save(transaction);
    }

    @Override
    public void delete(Long id) {

        Transaction transaction = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID : " + id));

        repo.delete(transaction);
    }
}