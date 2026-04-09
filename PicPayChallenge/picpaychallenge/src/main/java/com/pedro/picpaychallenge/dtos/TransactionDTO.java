package com.pedro.picpaychallenge.dtos;

import java.math.BigDecimal;

public record TransactionDTO (BigDecimal amount, Long payerId, Long payeeId){}
