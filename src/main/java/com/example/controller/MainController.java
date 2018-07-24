package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Player;
import com.example.model.Team;
import com.example.service.SoccerServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private SoccerServiceImpl soccerService;
	
	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPlayers(Model model) {
		List<Team> teamList = soccerService.findAllTeam();
		model.addAttribute("teamList",teamList);
		model.addAttribute("team", new Team());
		return "team_player";
	}
	
	@RequestMapping(value = "/players", method = RequestMethod.POST)
	public String listPlayers(@ModelAttribute(value = "team") Team team, Model model) {
		List<Player> listPlayer =  soccerService.getAllTeamPlayers(team.getName());
		if(listPlayer != null) {
			System.out.println(listPlayer);
			model.addAttribute("listPlayer", listPlayer);
			model.addAttribute("teamName", team.getName());
			return "player_show";
		}
		return "not_found";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String listTeam(Model model) {
		List<Team> teamList = soccerService.findAllTeam();
		model.addAttribute("teamList", teamList);
		model.addAttribute("player", new Player());
		return "sign_up_player";
	}
	
	@RequestMapping(value = "/signup_player", method = RequestMethod.POST)
	public String savePlayer(@ModelAttribute(value = "player") Player player, Model model) {
		System.out.println("here ");
		try {
			soccerService.addPlayer(player.getName(), player.getPosition(),player.getNum(), player.getTeam());
			model.addAttribute("signup_result", "success");
			return "signup_result";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("signup_result", "fail");
			return "signup_result";
		}
	}
}
