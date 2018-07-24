package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
	public Team findByName(String teamName);
	public Team findByPlayers(String playerName);
	public List<Team> findAll();
}
