/**
 * 
 */
package com.rockpaperscissor.model;

/**
 * @author RemiOseni
 *
 */
public class Score {
	
	private int gameNo;
	private String message;
	private int playerScore;
	private int alScore;
	
	/**
	 * @return the gameNo
	 */
	public int getGameNo() {
		return gameNo;
	}
	/**
	 * @param gameNo the gameNo to set
	 */
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the palyerScore
	 */
	public int getPlayerScore() {
		return playerScore;
	}
	/**
	 * @param playerScore the playerScore to set
	 */
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	/**
	 * @return the alScore
	 */
	public int getAlScore() {
		return alScore;
	}
	/**
	 * @param alScore the alScore to set
	 */
	public void setAlScore(int alScore) {
		this.alScore = alScore;
	}
	
	

}
