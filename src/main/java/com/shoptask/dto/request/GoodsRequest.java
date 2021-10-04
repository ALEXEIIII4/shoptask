package com.shoptask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsRequest {
    private String name;
    private BigDecimal price;
    private Long quantity;
    private String code;
    private String idShop;
    private String idSells;
}
