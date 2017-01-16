/**
 * 
 */
package com.rockpaperscissor.model;


/**
 * @author RemiOseni
 *
 */
public class User {

	public Move getMove(String selection) {

		Move move = Move.ROCK;

		switch (selection) {		
			case "rock":
				return Move.ROCK;
			case "paper":
				return Move.PAPER;
			case "scissors":
				return Move.SCISSORS;
			case "lizard":
				return Move.LIZARD;
			case "spock":
				return Move.SPOCK;
		}

		return move;
	}

}
