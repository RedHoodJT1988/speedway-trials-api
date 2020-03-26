package com.galvanize.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    Date date;
    @Column
    String bestTime;
    @Column
    Long winnerId;
    @ManyToMany
    List<Driver> participants;

    public Race() {
    }

    public Race(Long id, String name, String category, Date date, String bestTime, Long winnerId, List<Driver> participants) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
