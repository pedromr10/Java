package com.pedro.picpaychallenge.dtos;

import java.math.BigDecimal;

import com.pedro.picpaychallenge.enums.UserType;

public record UserDTO (String fullName, String cpf, String email, String password, UserType type,BigDecimal balance){}
