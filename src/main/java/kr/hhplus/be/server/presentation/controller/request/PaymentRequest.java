package kr.hhplus.be.server.presentation.controller.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private String token;
    private Long reservationId;
    private Long amount;
}