package com.galvanize.entities;

import javax.persistence.*;
import java.util.Objects;

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

    /*
    * LAH: This method would update this object instance, but would not get persisted to the actual database.
    * Use the repository to handle updates to a specific entity. The save function in your JpaRepository will
    * handle updates as well:
    * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#save-S-
     */
    public void update(Car expected) {
        if(expected.getId()!=0)this.setId(expected.getId());
        if(expected.getDriverId()!=0)this.setDriverId(expected.getDriverId());
        if(expected.getModel()!=null)this.setModel(expected.getModel());
        if(expected.getNickName()!=null)this.setNickName(expected.getNickName());
        if(expected.getYear()!=0)this.setYear(expected.getYear());
        if(expected.getStatus()!=null)this.setStatus(expected.getStatus());
        if(expected.getTopSpeed()!=0)this.setTopSpeed(expected.getTopSpeed());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() &&
                getDriverId() == car.getDriverId() &&
                getTopSpeed() == car.getTopSpeed() &&
                Objects.equals(getId(), car.getId()) &&
                Objects.equals(getNickName(), car.getNickName()) &&
                Objects.equals(getModel(), car.getModel()) &&
                getStatus() == car.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNickName(), getModel(), getYear(), getDriverId(), getStatus(), getTopSpeed());
    }
}
