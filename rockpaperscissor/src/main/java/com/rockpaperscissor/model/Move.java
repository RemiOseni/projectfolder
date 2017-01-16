/**
 * 
 */
package com.rockpaperscissor.model;

/**
 * @author RemiOseni
 *
 */
public enum Move {
	 ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
	 
        
     /**
      * Compares this move with another move to determining a tie, a win, or
      * a loss.
      * 
      * @param otherMove
      *            move to compare to
      * @return 1 if this move beats the other move, -1 if this move loses to
      *         the other move, 0 if these moves tie
      */
     public int compareMoves(Move otherMove) {
         // Tie
         if (this == otherMove)
             return 0;

         switch (this) {
	         case ROCK:
	             return (otherMove == SCISSORS || otherMove == LIZARD ? 1 : -1);
	         case PAPER:
	             return (otherMove == ROCK || otherMove == SPOCK ? 1 : -1);
	         case SCISSORS:
	             return (otherMove == PAPER || otherMove == LIZARD ? 1 : -1);
	         case LIZARD:
	             return (otherMove == PAPER || otherMove == SPOCK ? 1 : -1);
	         case SPOCK:
	             return (otherMove == SCISSORS || otherMove == ROCK ? 1 : -1);    	
         }

         // Should never reach here
         return 0;
     }

}
