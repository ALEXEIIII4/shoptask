package com.shoptask.converters;

import com.shoptask.dto.request.BuyerRequest;
import com.shoptask.dto.response.BuyerResponse;
import com.shoptask.entity.BuyerEntity;
import org.springframework.stereotype.Service;

@Service
public class BuyerConverter {

    public BuyerEntity convertDtoToEntity(BuyerRequest buyerRequest) {
        BuyerEntity buyerEntity = new BuyerEntity();
        buyerEntity.setEmail(buyerRequest.getEmail());
        buyerEntity.setFio(buyerRequest.getFio());
        return buyerEntity;
    }

    public BuyerResponse convertEntityToDto(BuyerEntity buyerEntity) {
        BuyerResponse buyerResponse = new BuyerResponse();
        buyerResponse.setId(buyerEntity.getId());
        buyerResponse.setEmail(buyerEntity.getEmail());
        buyerResponse.setFio(buyerEntity.getFio());
        return buyerResponse;
    }
}
