package com.galvanize.entities;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String nickName;
    @Column
    String model;
    @Column
    int year;
    @Column
    int driverId;
    @Column
    @Enumerated(EnumType.STRING)
    Status status;
    @Column
    int topSpeed;

    public Car() {
    }

    public Car(String nickName, String model, int year, int driverId, Status status, int topSpeed) {
        this.nickName = nickName;
        this.model = model;
        this.year = year;
        this.driverId = driverId;
        this.status = status;
        this.topSpeed = topSpeed;
    }

    public Car(Long id, String nickName, String model, int year, int driverId, Status status, int topSpeed) {
        this.id = id;
        this.nickName = nickName;
        this.model = model;
        this.year = year;
        this.driverId = driverId;
        this.status = status;
        this.topSpeed = topSpeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}
