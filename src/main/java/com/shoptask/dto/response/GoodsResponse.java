package com.shoptask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsResponse {
    private String name;
    private BigDecimal price;
    private Long quantity;
    private String code;
    private ShopsResponse shopsResponse;
    private Page<SellResponse> sellResponse;
}
