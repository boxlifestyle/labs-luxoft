package com.bykov.testspec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Booze {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "booze_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> productionAddresses;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type boozeType;

    public Booze(List<Address> productionAddresses, Type boozeType) {
        this.productionAddresses = productionAddresses;
        this.boozeType = boozeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getProductionAddresses() {
        return productionAddresses;
    }

    public void setProductionAddresses(List<Address> productionAddresses) {
        this.productionAddresses = productionAddresses;
    }

    public Type getBoozeType() {
        return boozeType;
    }

    public void setBoozeType(Type boozeType) {
        this.boozeType = boozeType;
    }
}
