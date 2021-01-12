package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricket {
	
	@Id
	private String playerId;
	
	@NotNull
    @Field
	private String playerName;
	
	@NotNull
    @Field
	private Integer averageRun;
	
	@NotNull
    @Field
	private Integer noOfRun;
	
	@NotNull
    @Field
	private Integer noOfWicket;
	
	public Cricket(String playerId, String playerName, Integer averageRun, Integer noOfRun, Integer noOfWicket) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageRun = averageRun;
		this.noOfRun= noOfRun;
		this.noOfWicket=noOfWicket;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setplayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getAverageRun() {
		return averageRun;
	}

	public void setAverageRun(Integer averageRun) {
		this.averageRun = averageRun ;
	}
	
	public Integer getNoOfRun() {
		return noOfRun;
	}	

	public void setNoOfRun(Integer noOfRun) {
		this.noOfRun = noOfRun ;
	}
	
	public Integer getNoOfWicket() {
		return noOfWicket;
	}	

	public void setNoOfWicket(Integer noOfWicket) {
		this.noOfWicket = noOfWicket ;
	}
	
	
	
	

}
