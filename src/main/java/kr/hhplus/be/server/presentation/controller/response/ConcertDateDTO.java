package kr.hhplus.be.server.presentation.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class ConcertDateDTO {
    Long concertOptionId;
    LocalDateTime concertDate;
}
