package com.rockpaperscissor;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.rockpaperscissor.controller.RPSRestController;
import com.rockpaperscissor.model.AIComputer;
import com.rockpaperscissor.model.Move;
import com.rockpaperscissor.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockpaperscissorApplicationTests {
	
	@Autowired
	@Mock
	private RPSRestController rpsRestControllerMock;
	
	@Before
    public void before() {
		 MockitoAnnotations.initMocks(this); 
    }
	
	@Test
	public void testMockCreation(){
		assertNotNull(rpsRestControllerMock);
	}
	
	@Test
	public void testRPSOptionsIsReturningMapObject() {	
		 // given
		when(rpsRestControllerMock.loadRpsOptions()).thenReturn(new HashMap<String,String>());
		
		//then
		Map<String,String> map = rpsRestControllerMock.loadRpsOptions();
		
		// assert
        assertEquals(0, map.size());       
	}
	
	@Test
	public void testRPSLSOptionsIsReturningMapObject() {	
		 // given
		when(rpsRestControllerMock.loadRpslsOptions()).thenReturn(new HashMap<String,String>());
		
		//then
		Map<String,String> map = rpsRestControllerMock.loadRpslsOptions();
		
		//assert
        assertEquals(0, map.size());       
	}
	
	@Test
	public void testRPSOptionsIsReturningValidMapSize() {	
		 // given
		when(rpsRestControllerMock.loadRpsOptions()).thenCallRealMethod();
		
		//then
		Map<String,String> map = rpsRestControllerMock.loadRpsOptions();
		
		//assert
        assertEquals(3, map.size());        
	}
	
	@Test
	public void testRPSLSOptionsIsReturningValidMapSize() {	
		 // given
		when(rpsRestControllerMock.loadRpslsOptions()).thenCallRealMethod();
		
		//then
		Map<String,String> map = rpsRestControllerMock.loadRpslsOptions();
		
		//assert
        assertEquals(5, map.size());       
	}	

	@Test
	public void testAIComputerMovesAreValid() {	
		 // given
		when(rpsRestControllerMock.getComputer()).thenReturn(new AIComputer());
		
		//then
		AIComputer computer = rpsRestControllerMock.getComputer();
		
		// assert      
		assertEquals(Move.ROCK, computer.getMove(0));	
		assertEquals(Move.PAPER, computer.getMove(1));	
		assertEquals(Move.SCISSORS, computer.getMove(2));	
		assertEquals(Move.LIZARD, computer.getMove(3));
		assertEquals(Move.SPOCK, computer.getMove(4));
	}
	
	@Test
	public void testUserMovesAreValid() {		
		
		 // given
		when(rpsRestControllerMock.getUser()).thenReturn(new User());
		
		//then
		User user = rpsRestControllerMock.getUser();	
		
		//assert
		assertEquals(Move.ROCK, user.getMove("rock"));	
		assertEquals(Move.PAPER, user.getMove("paper"));	
		assertEquals(Move.SCISSORS,user.getMove("scissors"));	
		assertEquals(Move.LIZARD,user.getMove("lizard"));
		assertEquals(Move.SPOCK, user.getMove("spock"));		
	}
	
	
	@Test
	public void testCompareMovesIsReturningCorrectResult() {		
		//given
		when(rpsRestControllerMock.getUser()).thenReturn(new User());
		when(rpsRestControllerMock.getComputer()).thenReturn(new AIComputer());
		
		//then
		AIComputer computer = rpsRestControllerMock.getComputer();
		User user = rpsRestControllerMock.getUser();		
		
		//TEST: the moves are tie
		
		//this should return ROCK moves
		Move userMove = user.getMove("rock");
		//this also should return ROCK moves
        Move computerMove = computer.getMove(0);
        
        // Compare moves 
        int compareMoves = userMove.compareMoves(computerMove);
		
		//assert, expecting 0 if these moves are tie
		assertEquals(0, compareMoves);	
		
				
		//TEST: user move beats the computer move
		
		//this should return PAPER moves
		userMove = user.getMove("paper");
		//this also should return ROCK moves
		computerMove = computer.getMove(0);
		        
		// Compare moves 
		compareMoves = userMove.compareMoves(computerMove);
				
		//assert, expecting 1 if the user move beats the computer move
		assertEquals(1, compareMoves);	
				
		
		//TEST: user move lose to computer move   
		
		//this should return PAPER moves
		userMove = user.getMove("paper");
		//this also should return ROCK moves
		computerMove = computer.getMove(2);
		        
		// Compare moves 
		compareMoves = userMove.compareMoves(computerMove);
				
		//assert, expecting -1 if the user move lose to computer move        
		assertEquals(-1, compareMoves);			
	}
	

}
