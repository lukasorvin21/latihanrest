package com.eksad.latihanrest.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionTotal {

	private Long transactionId;
	private BigDecimal total;
}
