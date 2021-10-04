package com.shoptask.repository;

import com.shoptask.entity.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {

    @Query("SELECT goods " +
            "FROM GoodsEntity AS goods " +
            "join goods.shop as s " +
            "WHERE s.id = :id")
    Page<GoodsEntity> findByShopId(Pageable pageable, Long id);

    Page<GoodsEntity> findByQuantity(Pageable pageable, Long quantity);

    @Query("SELECT goods " +
            "FROM GoodsEntity AS goods " +
            "join goods.shop as s " +
            "join goods.sells as sells " +
            "where s.id = :idShop " +
            "group by goods.id")
    Page<GoodsEntity> findByShopIdAndSells(Pageable pageable, Long idShop);

    Page<GoodsEntity> findByPricePerOne(Pageable pageable, BigDecimal pricePerOne);

}
