package kr.hhplus.be.server.presentation.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class SeatDTO {
    private Long seatId;
    private String seatNumber;
    private String status;
}