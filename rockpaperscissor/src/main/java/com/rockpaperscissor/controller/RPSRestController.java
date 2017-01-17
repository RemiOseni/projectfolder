package com.rockpaperscissor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockpaperscissor.model.Score;
import com.rockpaperscissor.service.RPSService;

/**
 * @author RemiOseni
 *
 */
@RestController
public class RPSRestController{
	
	@Autowired
	RPSService rpsService;
	
	private boolean rpsFlag;
	
	@RequestMapping(value = "/play/{playerChoice}", method = RequestMethod.GET, headers="Accept=application/json")
	public Score play(@PathVariable String playerChoice){
		return rpsService.playGame(playerChoice, rpsFlag);	
	}
	
	@RequestMapping(value="/loadrps", method=RequestMethod.GET , headers="Accept=application/json")
	public Map<String,String> loadRpsOptions(){	
		
		rpsFlag=true;
		Map<String,String> rpsOptions = new HashMap<String,String>();
		rpsOptions.put("rock", "Rock");
		rpsOptions.put("paper", "Paper");
		rpsOptions.put("scissors", "Scissors");
		
		return rpsOptions;		
	}
	
	@RequestMapping(value="/loadrpsls", method=RequestMethod.GET, headers="Accept=application/json")
	public Map<String,String> loadRpslsOptions(){	
		
		rpsFlag=false;
		Map<String,String> rpslsOptions = new HashMap<String,String>();
		rpslsOptions.put("rock", "Rock");
		rpslsOptions.put("paper", "Paper");
		rpslsOptions.put("scissors", "Scissors");
		rpslsOptions.put("lizard", "Lizard");
		rpslsOptions.put("spock", "Spock");
		
		return rpslsOptions;			
	}
		
	@RequestMapping(value="/score",  method=RequestMethod.GET, headers="Accept=application/json")
	public Score score(){	
		return rpsService.getScoreBoard();		
	}
	
	@RequestMapping(value="/reset",  method=RequestMethod.GET, headers="Accept=application/json")
	public Score reset(){	
		rpsService.setScoreBoard(new Score());
		return rpsService.getScoreBoard();
	}

}
