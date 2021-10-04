package com.shoptask.services;

import com.shoptask.converters.SellsConverter;
import com.shoptask.dto.request.SellRequest;
import com.shoptask.entity.SellEntity;
import com.shoptask.repository.SellRepository;
import org.springframework.stereotype.Service;

@Service
public class SellService {

    private final SellRepository sellRepository;
    private final SellsConverter sellsConverter;

    public SellService(SellRepository sellRepository, SellsConverter sellsConverter) {
        this.sellRepository = sellRepository;
        this.sellsConverter = sellsConverter;
    }

    public SellEntity findById(SellEntity sellEntity) {
        return sellRepository.findById(sellEntity);
    }

    public void delete(SellEntity sellEntity) {
        sellRepository.delete(sellEntity);
    }

    public void updateFromRequest(SellRequest sellRequest) {
        update(sellsConverter.convertDtoToEntity(sellRequest));
    }

    public SellEntity update(SellEntity sellEntity) {
        return sellRepository.save(sellEntity);
    }

/*    public Page<SellResponse> getList(Pageable pageable, SellRequest sellRequest) {
        Page<SellEntity> sellEntityLists = sellsConverter.converterEntityToDto(pageable, sellRequest);
        return sellEntityLists;
    }*/

}
