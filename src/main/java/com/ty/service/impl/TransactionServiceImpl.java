package com.ty.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.dto.TransactionDTO;
import com.ty.entity.Transaction;
import com.ty.repository.TransactionRepository;
import com.ty.service.TransactionService;

@Service
public abstract  class TransactionServiceImpl implements TransactionService {

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

        // We will set category, type and user later.

        return repo.save(transaction);

    }

    @Override
    public List<Transaction> getAll(Long userId) {

        return repo.findByUserId(userId);

    }

    @Override
    public List<Transaction> getAllTransactions() {

        return repo.findAll();

    }

	@Override
	public Transaction save(Transaction t) {
		// TODO Auto-generated method stub
		return null;
	}

}