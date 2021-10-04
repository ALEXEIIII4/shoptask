package com.shoptask.controllers;

import com.shoptask.dto.response.GoodsResponse;
import com.shoptask.services.GoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/shops")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/goods")
    public ResponseEntity<Page<GoodsResponse>> findByIdShop(@PageableDefault(value = 15) Pageable pageable,
                                                      @RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(goodsService.findByIdList(pageable, id));
    }

    @GetMapping("/sold")
    public ResponseEntity<Page<GoodsResponse>> getListOfSoldGoods(@PageableDefault(value = 15) Pageable pageable,
                                                                  @RequestParam(value = "id") Long idShop) {
        Page<GoodsResponse> responses = goodsService.findByIdShopAndSells(pageable, idShop);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/shit")
    public ResponseEntity<Page<GoodsResponse>> getByQuantityGoods(@PageableDefault(value = 15) Pageable pageable,
                                                                  @RequestParam(value = "quantity") Long quantity) {
        return ResponseEntity.ok(goodsService.getListsOfShops(pageable, quantity));
    }

    @GetMapping("/shit2")
    public ResponseEntity<Page<GoodsResponse>> getNameGoodsByPrice(@PageableDefault(value = 15) Pageable pageable,
                                                             @RequestParam(value = "price_per_one") BigDecimal price) {
        return ResponseEntity.ok(goodsService.getByPricePerOneAndGoodsName(pageable, price));
    }
}
