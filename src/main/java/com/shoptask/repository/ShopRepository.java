package com.shoptask.repository;

import com.shoptask.entity.ShopEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
    ShopEntity getById(ShopEntity shopEntity);

    @Query("SELECT shop FROM ShopEntity AS shop")
    Page<ShopEntity> findAll(Pageable pageable);
}
