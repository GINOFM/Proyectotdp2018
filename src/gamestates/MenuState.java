package gamestates;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import entidades.Player;

public class MenuState extends GameState {

	protected Image fondo;

	public MenuState(GameStateManager gsm) {
		gameStateManager = gsm;
	}

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

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getX() > 220 && e.getX() < 390 && e.getY() > 190 && e.getY() < 250) {
				gameStateManager.switchState(new Nivel1State(gameStateManager));
			} else if (e.getX() > 220 && e.getX() < 390 && e.getY() > 300 && e.getY() < 360) {
				System.exit(1);
			}

		}
	}

}
