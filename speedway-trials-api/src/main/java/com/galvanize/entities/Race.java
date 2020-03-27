package com.galvanize.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    @Column
    String category;
    @Column
    LocalDate date;
    @Column
    String bestTime;
    @Column
    Long winnerId;
    @ManyToMany
    List<Driver> participants;

    public Race() {
    }

    public Race(String name, String category, LocalDate date, String bestTime, Long winnerId, List<Driver> participants) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winnerId = winnerId;
        this.participants = participants;
    }

    public Race(Long id, String name, String category, LocalDate date, String bestTime, Long winnerId, List<Driver> participants) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winnerId = winnerId;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBestTime() {
        return bestTime;
    }

    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public List<Driver> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Driver> participants) {
        this.participants = participants;
    }

    public void update(Race expected) {
        if(expected.getId()!=0)this.setId(expected.getId());
        if(expected.getBestTime()!=null)this.setBestTime(expected.getBestTime());
        if(expected.getCategory()!=null)this.setCategory(expected.getCategory());
        if(expected.getDate()!=null)this.setDate(expected.getDate());
        if(expected.getName()!=null)this.setName((expected.getName()));
        if(expected.getParticipants()!=null)this.setParticipants(expected.getParticipants());
        if(expected.getWinnerId()!=null)this.setWinnerId(expected.getWinnerId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(getId(), race.getId()) &&
                Objects.equals(getName(), race.getName()) &&
                Objects.equals(getCategory(), race.getCategory()) &&
                Objects.equals(getDate(), race.getDate()) &&
                Objects.equals(getBestTime(), race.getBestTime()) &&
                Objects.equals(getWinnerId(), race.getWinnerId()) &&
                Objects.equals(getParticipants(), race.getParticipants());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getDate(), getBestTime(), getWinnerId(), getParticipants());
    }
}
