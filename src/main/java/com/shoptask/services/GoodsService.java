package com.shoptask.services;

import com.shoptask.converters.GoodsConverter;
import com.shoptask.converters.SellsConverter;
import com.shoptask.dto.response.GoodsResponse;
import com.shoptask.dto.response.SellResponse;
import com.shoptask.entity.GoodsEntity;
import com.shoptask.repository.GoodsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsConverter goodsConverter;
    private final SellsConverter sellsConverter;

    public GoodsService(GoodsRepository goodsRepository,
                        GoodsConverter goodsConverter,
                        SellsConverter sellsConverter) {
        this.goodsRepository = goodsRepository;
        this.goodsConverter = goodsConverter;
        this.sellsConverter = sellsConverter;
    }

    public GoodsEntity update(GoodsEntity goodsEntity) {
        return goodsRepository.save(goodsEntity);
    }

    public void delete(GoodsEntity goodsEntity) {
        goodsRepository.delete(goodsEntity);
    }

    public Page<GoodsResponse> findByIdList(Pageable pageable, Long id) {
        Page<GoodsEntity> goodsEntityList = goodsRepository.findByShopId(pageable, id);
        return goodsEntityList.map(goodsConverter::convertEntityToDto);
    }

    public Page<GoodsResponse> getListsOfShops(Pageable pageable, Long quantity) {
        Page<GoodsEntity> goodsEntityList = goodsRepository.findByQuantity(pageable, quantity);
        return goodsEntityList.map(goodsConverter::convertEntityToDto);
    }
    public Page<GoodsResponse> getByPricePerOneAndGoodsName(Pageable pageable, BigDecimal pricePerOne) {
        Page<GoodsEntity> goodsEntityList = goodsRepository.findByPricePerOne(pageable, pricePerOne);
        return goodsEntityList.map(goodsConverter::convertEntityToDto);
    }

    public Page<GoodsResponse> findByIdShopAndSells(Pageable pageable, Long idShop) {
        Page<GoodsEntity> goodsEntities = goodsRepository.findByShopIdAndSells(pageable, idShop);
        List<GoodsResponse> goodsResponseList = new ArrayList<>();

        for (GoodsEntity goodsEntity : goodsEntities) {
            Page<SellResponse> sells = new PageImpl<>(goodsEntity.getSells()
                    .stream()
                    .map(sellsConverter::convertEntityToDto)
                    .collect(Collectors.toList()));
            goodsResponseList.add(goodsConverter.convertEntityToDtoWithSells(goodsEntity, sells));
        }

        return new PageImpl<>(goodsResponseList);
    }

}
