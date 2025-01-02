package kr.hhplus.be.server.presentation.controller.response;

import lombok.Data;

@Data
public class AvailableDatesResponse {
    private Long concertOptionId;
    private String concertDate;
}
