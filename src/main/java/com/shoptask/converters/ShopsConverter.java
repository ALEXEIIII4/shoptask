package com.shoptask.converters;

import com.shoptask.dto.response.ShopsResponse;
import com.shoptask.entity.ShopEntity;
import org.springframework.stereotype.Service;


@Service
public class ShopsConverter {

    public ShopsResponse convertEntityToDto(ShopEntity shopEntity) {
        ShopsResponse shopsResponse = new ShopsResponse();
        shopsResponse.setName(shopEntity.getShopName());
        shopsResponse.setAddress(shopEntity.getAddress());
        return shopsResponse;

    }
}

