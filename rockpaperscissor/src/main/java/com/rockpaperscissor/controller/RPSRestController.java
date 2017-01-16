package com.rockpaperscissor.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockpaperscissor.model.AIComputer;
import com.rockpaperscissor.model.Move;
import com.rockpaperscissor.model.Score;
import com.rockpaperscissor.model.User;

/**
 * @author RemiOseni
 *
 */
@RestController
public class RPSRestController{
	
	private Score scoreBoard = new Score(); 
	private User user = new User();
	private AIComputer computer = new AIComputer();
	private boolean rpsFlag = true;
	
	@RequestMapping(value = "/play/{playerChoice}", method = RequestMethod.GET, headers="Accept=application/json")
	public Score play(@PathVariable String playerChoice){			
		playGame(playerChoice);	
		return scoreBoard;
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
		return scoreBoard;		
	}
	
	@RequestMapping(value="/reset",  method=RequestMethod.GET, headers="Accept=application/json")
	public Score reset(){	
		return scoreBoard = new Score(); 		
	}

	
	private void playGame(String personPlay){
		
		Random rand = new Random();
		
		 // Get moves
        Move userMove = user.getMove(personPlay);
        Move computerMove = computer.getMove( rand.nextInt(rpsFlag ? 3 : 5));
       
        // Compare moves and determine winner
        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
        case 0: // Tie
            scoreBoard.setMessage("You and AI Computer tie !!");
            break;
        case 1: // User wins           
            scoreBoard.setMessage(userMove + " beats " + computerMove + ". You won!");
			scoreBoard.setPlayerScore(scoreBoard.getPlayerScore() + 1);
            break;
        case -1: // Computer wins            
            scoreBoard.setMessage(computerMove + " beats " + userMove + ". You lost.");
			scoreBoard.setAlScore(scoreBoard.getAlScore() + 1);
            break;
        }
        
        scoreBoard.setGameNo(scoreBoard.getGameNo() + 1);
	}

	public AIComputer getComputer() {
		return computer;
	}

	public User getUser() {
		return user;
	}	

}
