package com.matchmaking.player.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Queue {
    private String id;
    private QueueStatus status;
    private String location;
    private String errorMessage;

    @JsonIgnore
    private long updated;

    public Queue() {
        id = UUID.randomUUID().toString();
        status = QueueStatus.WAITING;
        updated = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        updated = System.currentTimeMillis();
    }

    public QueueStatus getStatus() {
        return status;
    }

    public void setStatus(QueueStatus status) {
        this.status = status;
        updated = System.currentTimeMillis();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        updated = System.currentTimeMillis();
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        updated = System.currentTimeMillis();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getUpdated() {
        return updated;
    }
}
