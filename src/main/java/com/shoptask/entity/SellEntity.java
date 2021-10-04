package com.shoptask.entity;

import javax.persistence.*;

@Entity
@Table(name = "sell")
public class SellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_goods")
    private Long quantityGoods;

    @ManyToOne
    @JoinColumn(name = "id_goods", nullable = false)
    private GoodsEntity goods;

    @ManyToOne
    @JoinColumn(name = "id_buyer", nullable = false)
    private BuyerEntity buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantityGoods() {
        return quantityGoods;
    }

    public void setQuantityGoods(Long quantityGoods) {
        this.quantityGoods = quantityGoods;
    }

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public BuyerEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerEntity buyer) {
        this.buyer = buyer;
    }
}
