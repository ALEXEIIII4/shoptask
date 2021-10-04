package com.shoptask.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "goods")
public class GoodsEntity {

    @Id
    private Long id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "price_per_one")
    private BigDecimal pricePerOne;

    @Column(name ="quantity")
    private Long quantity;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_shop", nullable = false)
    private ShopEntity shop;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goods")
    private List<SellEntity> sells;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPricePerOne() {
        return pricePerOne;
    }

    public void setPricePerOne(BigDecimal pricePerOne) {
        this.pricePerOne = pricePerOne;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public List<SellEntity> getSells() {
        return sells;
    }

    public void setSells(List<SellEntity> sells) {
        this.sells = sells;
    }
}
