package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

	private Controller c;

	public KeyInput(Controller c) {
		this.c = c;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			c.getPlayer().setVelX(5);
		} else if (key == KeyEvent.VK_LEFT) {
			c.getPlayer().setVelX(-5);
		} else if (key == KeyEvent.VK_SPACE && !c.getPlayer().getIsShooting()) {
			c.getPlayer().setIsShooting(true);
			c.getPlayer().disparar(c);
		//	game.getControler().addEntity(new DisparoSimple(game.getPlayer().getX() + 16, game.getPlayer().getY() - 12));
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			c.getPlayer().setVelX(0);
		} else if (key == KeyEvent.VK_LEFT) {
			c.getPlayer().setVelX(0);
		} else if (key == KeyEvent.VK_SPACE) {
			c.getPlayer().setIsShooting(false);
		}
	}
}
