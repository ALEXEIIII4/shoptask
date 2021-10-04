package com.shoptask.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
public class BuyerEntity {

    @Id
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "fio")
    private String fio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<SellEntity> sells;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SellEntity> getSells() {
        return sells;
    }

    public void setSells(List<SellEntity> sells) {
        this.sells = sells;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
