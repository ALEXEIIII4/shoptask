package com.shoptask.repository;

import com.shoptask.entity.SellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends JpaRepository<SellEntity, Long> {
    SellEntity findById(SellEntity sellEntity);
}
