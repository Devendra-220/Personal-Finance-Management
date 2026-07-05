package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ty.dto.TransactionDTO;
import com.ty.entity.Transaction;
import com.ty.service.TransactionService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService service;

	@PostMapping("/save")
	public String saveTransaction(@ModelAttribute TransactionDTO transactionDTO) {

	    service.save(transactionDTO);

	    return "redirect:/transaction/all";
	}
	
	
	@GetMapping("/add")
	public String showAddTransactionPage(Model model) {

	    model.addAttribute("transaction", new TransactionDTO());

	    return "add-transaction";
	}
	
	@GetMapping("/all")
	public String getAllTransactions(Model model) {

	    model.addAttribute("transactions", service.getAllTransactions());

	    return "transaction-list";
	}

}