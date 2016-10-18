package com.MagePVP.Utils;

public enum GameState {
	
	IN_LOBBY(true), IN_GAME(false), POST_GAME(false), RESETTING(false);
	
	private boolean joinable;
	private static GameState currentState;
	
	GameState(boolean joinable) {
		
		this.joinable = joinable;
		
	}
	
	public boolean isJoinable() {
		
		return this.joinable;
	}
	
	public static void setCurrentState(GameState state) {
		
		GameState.currentState = state;
	}
	
	public static boolean isCurrentState(GameState state) {
		
		return GameState.currentState == state;
	}
	
	public static GameState getCurrentState() {
		
		return GameState.currentState;
	}
	
}