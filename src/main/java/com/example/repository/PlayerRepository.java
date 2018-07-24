package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	List<Player> findByName(String playerName);
	List<Player> findByTeamId(int teamID);
}
