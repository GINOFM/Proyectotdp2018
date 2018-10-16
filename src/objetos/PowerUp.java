package objetos;

import java.awt.Graphics;
import base.Colisionador;
import entidades.Entity;

public abstract class PowerUp extends Entity {

	protected int velocidadX;
	protected int velocidadY;
	protected Colisionador col;

	public PowerUp(int x, int y) {
		super(x, y);
	}

	public void update() {
		y = y + velocidadY;
	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

}
