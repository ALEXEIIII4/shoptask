package com.shoptask.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name ="adrress")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<GoodsEntity> goods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }
}
