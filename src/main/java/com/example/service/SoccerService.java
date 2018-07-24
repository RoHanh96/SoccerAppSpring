package com.example.service;

import java.util.List;

import com.example.model.Player;
import com.example.model.Team;

public interface SoccerService {
	public List<Player> getAllTeamPlayers(String teamName);
	public void addPlayer(String name, String position, int number, Team team);
	public List<Team> findAllTeam();
}
