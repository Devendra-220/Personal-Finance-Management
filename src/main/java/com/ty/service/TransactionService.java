package com.ty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.entity.Transaction;
import com.ty.user.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionRepository repo;
	
	public Transaction save(Transaction t) {
		return repo.save(t);
		
	}
	public List<Transaction>
	getAll(Long UserId){
		return repo.findByUserId(UserId);
		
		
	}
	public List<Transaction> getAllTransactions(){

	    return repo.findAll();

	}
}
