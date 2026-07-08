package com.ty.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransactionDTO {

    private Long id;

    private String title;

    private Double amount;

    private String description;

    private LocalDate date;

    private String type;

    private String category;

    private Long userId;

}