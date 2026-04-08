package com.pedro.picpaychallenge.domain.enums;

public enum UserType {
	MERCHANT,
	COMMON;
	
    public boolean isMerchant() {
        return this == MERCHANT;
    }
}
