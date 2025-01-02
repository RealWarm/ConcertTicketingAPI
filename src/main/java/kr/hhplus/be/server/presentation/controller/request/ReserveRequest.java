package kr.hhplus.be.server.presentation.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ReserveRequest {
    private String token;
    private Long concertOptionId;
    private Long seatId;
    private Long userId;
}