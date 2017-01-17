/**
 * 
 */
package com.rockpaperscissor.model;


/**
 * @author RemiOseni
 *
 */
@Component
public class AIComputer {
	
	public Move getMove(int index) {       
        return Move.values()[index];
    }

}
