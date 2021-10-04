package com.shoptask.converters;

import com.shoptask.dto.request.SellRequest;
import com.shoptask.dto.response.SellResponse;
import com.shoptask.entity.SellEntity;
import com.shoptask.repository.BuyerRepository;
import com.shoptask.repository.GoodsRepository;
import org.springframework.stereotype.Service;

@Service
public class SellsConverter {

    private final GoodsRepository goodsRepository;
    private final BuyerRepository buyerRepository;
    private final GoodsConverter goodsConverter;
    private final BuyerConverter buyerConverter;

    public SellsConverter(GoodsRepository goodsRepository, BuyerRepository buyerRepository, GoodsConverter goodsConverter, BuyerConverter buyerConverter) {
        this.goodsRepository = goodsRepository;
        this.buyerRepository = buyerRepository;
        this.goodsConverter = goodsConverter;
        this.buyerConverter = buyerConverter;
    }

    public SellEntity convertDtoToEntity(SellRequest sellRequest) {
        SellEntity sellEntity = new SellEntity();
        sellEntity.setQuantityGoods(sellRequest.getQuantityGoods());
        sellEntity.setBuyer(buyerRepository.getById(sellRequest.getIdBuyer()));
        sellEntity.setGoods(goodsRepository.getById(sellRequest.getIdGoods()));
        return sellEntity;
    }

    public SellResponse convertEntityToDto(SellEntity sellEntity) {
        SellResponse sellResponse = new SellResponse();
        sellResponse.setQuantityGoods(sellEntity.getQuantityGoods());
        sellResponse.setBuyerResponse(buyerConverter.convertEntityToDto(sellEntity.getBuyer()));
        sellResponse.setGoodsResponse(goodsConverter.convertEntityToDto(sellEntity.getGoods()));
        return sellResponse;
    }
}
