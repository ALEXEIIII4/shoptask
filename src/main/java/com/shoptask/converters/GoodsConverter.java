package com.shoptask.converters;

import com.shoptask.dto.response.GoodsResponse;
import com.shoptask.dto.response.SellResponse;
import com.shoptask.entity.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsConverter {

    private final ShopsConverter shopsConverter;

    public GoodsConverter(ShopsConverter shopsConverter) {
        this.shopsConverter = shopsConverter;
    }

    public GoodsResponse convertEntityToDto(GoodsEntity goodsEntity) {
        GoodsResponse goodsResponse = new GoodsResponse();
        goodsResponse.setName(goodsEntity.getGoodsName());
        goodsResponse.setPrice(goodsEntity.getPricePerOne());
        goodsResponse.setQuantity(goodsEntity.getQuantity());
        goodsResponse.setCode(goodsEntity.getCode());
        goodsResponse.setShopsResponse(shopsConverter.convertEntityToDto(goodsEntity.getShop()));
        return goodsResponse;
    }

    public GoodsResponse convertEntityToDtoWithSells(GoodsEntity goodsEntity, Page<SellResponse> sellResponses) {
        GoodsResponse goodsResponse = new GoodsResponse();
        goodsResponse.setName(goodsEntity.getGoodsName());
        goodsResponse.setPrice(goodsEntity.getPricePerOne());
        goodsResponse.setQuantity(goodsEntity.getQuantity());
        goodsResponse.setCode(goodsEntity.getCode());
        goodsResponse.setShopsResponse(shopsConverter.convertEntityToDto(goodsEntity.getShop()));
        goodsResponse.setSellResponse(sellResponses);
        return goodsResponse;
    }
}
