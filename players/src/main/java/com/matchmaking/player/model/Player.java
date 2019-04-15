package com.matchmaking.player.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

  @ApiModelProperty(value = "This corresponds to the ID of a Player")
  @Id
  private String id;
  @ApiModelProperty(value = "Wins of the Player")
  private String wins;
  @ApiModelProperty(value = "Loss count of the Player")
  private String loses;
  @ApiModelProperty(value = "Rating of the Player ")
  private String rating;
  @ApiModelProperty(value = "Play style of the Player")
  private String playstyle;
  @ApiModelProperty(value = "TraceId the Player")
  private double traceId;


  public Player() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getWins() {
    return this.wins;
  }

  public void setWins(String wins) {
    this.wins = wins;
  }

  public String getLoses() {
    return this.loses;
  }

  public void setLoses(String loses) {
    this.loses = loses;
  }

  public String getRating() {
    return this.rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getPlaystyle() {
    return this.playstyle;
  }

  public void setPlaystyle(String playstyle) {
    this.playstyle = playstyle;
  }

  public double getTraceId() {
    return this.traceId;
  }

  public void setTraceId(double traceId) {
    this.traceId = traceId;
  }
}