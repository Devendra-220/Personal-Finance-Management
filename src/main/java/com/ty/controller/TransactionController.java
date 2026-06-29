package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ty.entity.Transaction;
import com.ty.service.TransactionService;

@RestController

@RequestMapping("/transaction")

public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping
    public Transaction save(
            @RequestBody Transaction t
    ){
        return service.save(t);
    }

    @GetMapping("/{id}")

    public List<Transaction> get(
            @PathVariable Long id
    ){
        return service.getAll(id);
    }
    
    @GetMapping("/all")

    public List<Transaction> getAll(){

        return service.getAllTransactions();

    }

}