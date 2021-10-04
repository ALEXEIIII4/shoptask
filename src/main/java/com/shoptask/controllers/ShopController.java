package com.shoptask.controllers;

import com.shoptask.dto.response.ShopsResponse;
import com.shoptask.services.ShopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ShopsResponse>> findByShopName(@PageableDefault(value = 15) Pageable pageable) {
            return ResponseEntity.ok(shopService.getListShops(pageable));
    }
}
