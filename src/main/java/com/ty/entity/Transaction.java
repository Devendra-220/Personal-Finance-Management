package com.ty.entity;

import java.time.LocalDate;

import com.ty.enums.CategoryType;
import com.ty.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "transactions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {

	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TransactionType type;


	private Double amount;

	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public void setDescription(String description)	{

		
	}

}