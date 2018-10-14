package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entidades.Player;

public abstract class GameState {

	protected GameStateManager gameStateManager;
	
	public abstract void init();

	public abstract void update();

	public abstract void render(Graphics g);

	public abstract Player getPlayer();
	
	public abstract void keyPressed(KeyEvent e);
	
	public abstract void keyReleased(KeyEvent e);

	public abstract void mouseClicked(MouseEvent e);
	
}
