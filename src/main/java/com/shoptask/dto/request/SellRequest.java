package com.shoptask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellRequest {
    private Long quantityGoods;
    private Long idGoods;
    private Long idBuyer;
    private Long idShop;
}
