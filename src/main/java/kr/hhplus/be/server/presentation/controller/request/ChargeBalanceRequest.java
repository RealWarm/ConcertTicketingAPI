package kr.hhplus.be.server.presentation.controller.request;

import lombok.Data;

@Data
public class ChargeBalanceRequest {
    private Long userId;
    private Long amount;
}