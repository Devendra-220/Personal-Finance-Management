package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    private TransactionService service;

    // Show Add Transaction Page
    @GetMapping("/add")
    public String showAddTransactionPage(Model model) {

        model.addAttribute("transaction", new TransactionDTO());

        return "add-transaction";
    }

    // Save Transaction
    @PostMapping("/save")
    public String saveTransaction(@ModelAttribute TransactionDTO transactionDTO) {

        service.save(transactionDTO);

        return "redirect:/transaction/all";
    }

    // Display All Transactions
    @GetMapping("/all")
    public String getAllTransactions(Model model) {

        model.addAttribute("transactions", service.getAllTransactions());

        return "transaction-list";
    }

    // Show Edit Page
    @GetMapping("/edit/{id}")
    public String editTransaction(@PathVariable Long id, Model model) {

        Transaction transaction = service.getById(id);

        model.addAttribute("transaction", transaction);

        return "edit-transaction";
    }

    // Update Transaction
    @PostMapping("/update/{id}")
    public String updateTransaction(@PathVariable Long id,
                                    @ModelAttribute TransactionDTO dto) {

        service.update(id, dto);

        return "redirect:/transaction/all";
    }

    // Delete Transaction
    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/transaction/all";
    }

}