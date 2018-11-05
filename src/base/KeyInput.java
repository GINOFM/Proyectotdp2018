package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Game juego;

	public KeyInput(Game juego) {
		this.juego = juego;
	}

	public void keyPressed(KeyEvent e) {
		juego.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		juego.keyReleased(e);
	}
}