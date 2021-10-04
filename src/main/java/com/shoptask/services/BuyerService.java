package com.shoptask.services;

import com.shoptask.converters.BuyerConverter;
import com.shoptask.dto.response.BuyerResponse;
import com.shoptask.entity.BuyerEntity;
import com.shoptask.repository.BuyerRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private final BuyerConverter buyerConverter;
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerConverter buyerConverter, BuyerRepository buyerRepository) {
        this.buyerConverter = buyerConverter;
        this.buyerRepository = buyerRepository;
    }

    public BuyerEntity update(BuyerEntity buyerEntity) {
        return buyerRepository.save(buyerEntity);
    }

    public BuyerEntity findById(BuyerEntity buyerEntity) {
        return buyerRepository.findById(buyerEntity);
    }

    public void delete(BuyerEntity buyerEntity) {
         buyerRepository.delete(buyerEntity);
    }

    public BuyerResponse getByEmail(String email) {
        BuyerEntity buyerEntity = buyerRepository.findByEmail(email);
        return buyerConverter.convertEntityToDto(buyerEntity);
    }

}
