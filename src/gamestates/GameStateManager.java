package gamestates;

import java.awt.Graphics;

public class GameStateManager {

	private GameState actualGameState;

	public GameStateManager() {
		actualGameState = new Nivel2State(this);
		actualGameState.init();
	}
	
	public void init() {
		actualGameState.init();
	}

	public void update() {
		actualGameState.update();
	}

	public void render(Graphics g) {
		actualGameState.render(g);
	}
	
	public void switchState(GameState nuevoState) {
		actualGameState = nuevoState;
		actualGameState.init();
	}
	
	public GameState getGameState() {
		return actualGameState;
	}
}
