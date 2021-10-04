package com.shoptask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellResponse {
    private Long quantityGoods;
    private GoodsResponse goodsResponse;
    private BuyerResponse buyerResponse;
}
