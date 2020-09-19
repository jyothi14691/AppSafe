package com.appsafe.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STORES_DETAILS")
public class Stores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer storesId;

    @Column(name = "store_name")
    String storeName;

    @Column(name = "store_location")
    String storeLocation;

    @OneToMany(mappedBy = "stores",cascade = CascadeType.ALL)
    private Set<Timings> timings;

    public Set<Timings> getTimings() {
        return timings;
    }

    public void setTimings(Set<Timings> timings) {
        this.timings = timings;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
}
