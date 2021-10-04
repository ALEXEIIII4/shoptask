package com.shoptask.services;

import com.shoptask.converters.ShopsConverter;
import com.shoptask.dto.response.ShopsResponse;
import com.shoptask.entity.ShopEntity;
import com.shoptask.repository.ShopRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopsConverter shopsConverter;

    public ShopService(ShopRepository shopRepository,
                       ShopsConverter shopsConverter) {
        this.shopRepository = shopRepository;
        this.shopsConverter = shopsConverter;
    }

    public ShopEntity update(ShopEntity shopEntity) {
        return shopRepository.save(shopEntity);
    }

    public ShopEntity findById(ShopEntity shopEntity) {
        return shopRepository.getById(shopEntity);
    }

    public void delete(ShopEntity shopEntity) {
        shopRepository.delete(shopEntity);
    }

    @Transactional
    public Page<ShopsResponse> getListShops(Pageable pageable) {
        Page<ShopEntity> shopEntityList = shopRepository.findAll(pageable);
        return shopEntityList.map(shopsConverter::convertEntityToDto);
    }
}
