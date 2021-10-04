package com.shoptask.controllers;

import com.shoptask.dto.request.SellRequest;
import com.shoptask.dto.response.SellResponse;
import com.shoptask.entity.SellEntity;
import com.shoptask.services.SellService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shops")
public class SellController {
    private final SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @PostMapping("/sell")
    public ResponseEntity addSell(@RequestBody SellRequest request) {
        sellService.updateFromRequest(request);
        return ResponseEntity.ok().build();
    }

/*    @GetMapping("/sold")
    public ResponseEntity<Page<SellResponse>> getListOfSoldGoods(@PageableDefault(value = 15) Pageable pageable,
                                                   @RequestBody SellRequest request) {
        SellResponse response =
    }*/
}
