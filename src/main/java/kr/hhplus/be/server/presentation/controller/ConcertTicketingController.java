package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.presentation.controller.request.ChargeBalanceRequest;
import kr.hhplus.be.server.presentation.controller.request.PaymentRequest;
import kr.hhplus.be.server.presentation.controller.request.ReserveRequest;
import kr.hhplus.be.server.presentation.controller.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ConcertTicketingController {


    @PostMapping("/{concertId}/token")
    public ResponseEntity<CommonResponse<TokenDTO>> issueToken(
            @PathVariable Long concertId,
            @RequestParam Long userId
    ) {
        TokenDTO dto = TokenDTO.builder()
                .token("randomUUID")
                .queuePosition(11)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .build();

        CommonResponse<TokenDTO> response = new CommonResponse<>();
        response.setResult("200");
        response.setMessage("Success");
        response.setData(dto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }//issueToken


    @GetMapping("/{concertId}/available-dates")
    public ResponseEntity<List<ConcertDateDTO>> getAvailableDates(
            @PathVariable Long concertId,
            @RequestParam String token
    ) {
        List<ConcertDateDTO> options = new ArrayList<>();
        ConcertDateDTO concert1 = new ConcertDateDTO(1L, LocalDateTime.now().plusDays(11));
        ConcertDateDTO concert2 = new ConcertDateDTO(2L, LocalDateTime.now().plusDays(11));

        return new ResponseEntity<>(List.of(concert1, concert2), HttpStatus.OK);
    }


    @GetMapping("/{concertId}/available-seats")
    public ResponseEntity<List<SeatDTO>> getAvailableSeats(
            @PathVariable Long concertOptionId,
            @RequestParam String token
    ) {
        SeatDTO seat1 = new SeatDTO(1L, "A1", "Available");
        SeatDTO seat2 = new SeatDTO(2L, "A2", "Hold");
        return new ResponseEntity<>(List.of(seat1, seat2), HttpStatus.OK);
    }


    @PostMapping("/reserve")
    public ResponseEntity<CommonResponse<ReserveResponse>> reserveSeat(
            @RequestBody ReserveRequest request
    ) {
        CommonResponse<ReserveResponse> response = CommonResponse.<ReserveResponse>builder()
                .data(new ReserveResponse(1L))
                .message("Success")
                .result("200")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PatchMapping("/balance/charge")
    public ResponseEntity<UserBalanceResponse> chargeBalance(
            @RequestBody ChargeBalanceRequest request
    ) {
        UserBalanceResponse response = new UserBalanceResponse();
        response.setBalance(6000L);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/balance")
    public ResponseEntity<UserBalanceResponse> getBalance(
            @RequestParam Long userId
    ) {
        UserBalanceResponse response = new UserBalanceResponse();
        response.setBalance(6000L);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/pay")
    public ResponseEntity<CommonResponse<PaymentResponse>> pay(
            @RequestBody PaymentRequest request
    ) {
        CommonResponse<PaymentResponse> response = new CommonResponse<>();
        response.setResult("200");
        response.setMessage("Success");
        response.setData(new PaymentResponse(456L));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}//end


