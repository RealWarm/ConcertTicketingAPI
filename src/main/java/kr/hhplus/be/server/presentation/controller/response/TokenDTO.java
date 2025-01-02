package kr.hhplus.be.server.presentation.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class TokenDTO {
    private String token;
    private Integer queuePosition;
    private LocalDateTime expiresAt;
}