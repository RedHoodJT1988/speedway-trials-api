package com.galvanize.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    int age;
    @Column
    String nickName;
    @Column
    int carId;
    @Column
    int win;
    @Column
    int loss;

    public Driver() {
    }

    public Driver(String fistName, String lastName, int age, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
    }

    public Driver(Long id, String fistName, String lastName, int age, String nickName, int win, int loss) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
        this.win = win;
        this.loss = loss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getCar() {
        return carId;
    }

    public void setCar(int car) {
        this.carId = car;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public void update(Driver expected) {
        if(expected.getId()!=0){this.setId(expected.getId());}
        if(expected.getAge()!=0){this.setAge(expected.getAge());}
        if(expected.getCar()!=0){this.setCar(expected.getCar());}
        if(expected.getWin()!=0){this.setWin(expected.getWin());}
        if(expected.getLoss()!=0){this.setLoss(expected.getLoss());}
        if(expected.getFirstName()!=null){this.setFirstName(expected.getFirstName());}
        if(expected.getLastName()!=null){this.setLastName(expected.getLastName());}
        if(expected.getNickName()!=null){this.setNickName(expected.getNickName());}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getAge() == driver.getAge() &&
                carId == driver.carId &&
                getWin() == driver.getWin() &&
                getLoss() == driver.getLoss() &&
                Objects.equals(getId(), driver.getId()) &&
                Objects.equals(getFirstName(), driver.getFirstName()) &&
                Objects.equals(getLastName(), driver.getLastName()) &&
                Objects.equals(getNickName(), driver.getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAge(), getNickName(), carId, getWin(), getLoss());
    }
}
