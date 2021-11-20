package com.bykov.testspec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Country productionCountry;

    private String address;

    @ManyToMany(mappedBy = "productionAddresses", fetch = FetchType.EAGER)
    private List<Booze> booze;

    public Address(Country productionCountry, String address) {
        this.productionCountry = productionCountry;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(Country productionCountry) {
        this.productionCountry = productionCountry;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booze> getBooze() {
        return booze;
    }

    public void setBooze(List<Booze> booze) {
        this.booze = booze;
    }
}
