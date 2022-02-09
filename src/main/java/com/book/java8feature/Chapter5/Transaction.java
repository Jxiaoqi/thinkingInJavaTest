package com.book.java8feature.Chapter5;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private Trader trader;
    private Integer year;
    private int value;

}
