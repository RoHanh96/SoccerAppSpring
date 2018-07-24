package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Player;
import com.example.model.Team;
import com.example.repository.PlayerRepository;
import com.example.repository.TeamRepository;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public List<Player> getAllTeamPlayers(String teamName) {
		List<Player> players = null;
		try {
			int teamID = teamRepository.findByName(teamName).getId();
			players = playerRepository.findByTeamId(teamID);
		} catch (Exception e) {
			return players;
		}
		return players;
	}
	
	@Override
	public void addPlayer(String name, String position, int number, Team team) {
		//Team team = teamRepository.findByName(teamName);
		Player player = new Player();
		player.setName(name);
		player.setNum(number);
		player.setPosition(position);
		player.setTeam(team);
		playerRepository.save(player);
	}
	
	@Override
	public List<Team> findAllTeam() {
		List<Team> team = teamRepository.findAll();
		return team;
	}
}
