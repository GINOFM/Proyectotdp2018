package objetos;

import java.awt.Graphics;
import base.Colisionador;
import base.Visitor;
import entidades.Entity;

public abstract class PowerUp extends Entity implements Visitor{

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
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}
	
	public void serChocado(Colisionador col) {
		col.chocaPowerUp(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		destruir();
	}

	public void golpear(Entity e) {
		e.aceptarPowerUp(this);
	}

	public int obtenerPuntaje() {
		return 8;
	}

	@Override
	public void afectarPorPowerUp() {
		// TODO Auto-generated method stub
		
	}

}
