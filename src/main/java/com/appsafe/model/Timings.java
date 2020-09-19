package com.appsafe.model;

import javax.persistence.*;

@Entity
@Table(name = "TIMINGS")
public class Timings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer timingsId;

    @Column(name = "start_hour")
    Integer startHour;

    @Column(name = "end_hour")
    Integer endHour;

    @Column(name = "num_of_people")
    Integer numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Stores stores;

    public Integer getTimingsId() {
        return timingsId;
    }

    public void setTimingsId(Integer timingsId) {
        this.timingsId = timingsId;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Stores getStores() {
        return stores;
    }

    public void setStores(Stores stores) {
        this.stores = stores;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}