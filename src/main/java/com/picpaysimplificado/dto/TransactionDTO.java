package com.picpaysimplificado.dto;

import com.picpaysimplificado.model.user.User;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal amount, Long senderId, Long receiverId) {
}
