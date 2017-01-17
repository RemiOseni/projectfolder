/**
 * 
 */
package com.rockpaperscissor.model;
import org.springframework.stereotype.Component;


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
