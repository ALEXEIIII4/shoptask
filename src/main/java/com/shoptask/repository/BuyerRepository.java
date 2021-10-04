package com.shoptask.repository;

import com.shoptask.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {
    BuyerEntity findById(BuyerEntity buyerEntity);
    BuyerEntity findByEmail(String email);
}
