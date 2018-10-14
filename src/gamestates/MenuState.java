package gamestates;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import entidades.Player;

public class MenuState extends GameState {
	
	protected Image fondo;
	
	public void init() {
		ImageIcon ii = new ImageIcon("resources/menu_principal.png");
		fondo = ii.getImage();
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
	}

	public Player getPlayer() {
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
