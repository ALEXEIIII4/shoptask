package com.shoptask.controllers;

import com.shoptask.dto.request.BuyerRequest;
import com.shoptask.dto.response.BuyerResponse;
import com.shoptask.services.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/email")
    public ResponseEntity<BuyerResponse> getByBuyerEmail(@RequestBody BuyerRequest buyerRequest) {
        BuyerResponse response = buyerService.getByEmail(buyerRequest.getEmail());
        return ResponseEntity.ok(response);
    }

}
