package com.pedro.picpaychallenge.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequestDTO {
	private Long payer;
	private Long payee;
	private BigDecimal value;
}
