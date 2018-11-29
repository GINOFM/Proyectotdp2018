package objetos;

import java.awt.Graphics;

import base.ColDisparoJugador;
import base.Colisionador;
import entidades.Entity;
import inteligencias_movimiento.InteligenciaAscendenteRecta;

public class DisparoJSimple extends DisparoJugador {

	public DisparoJSimple(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 5;
		daño = 10;
		loadImage("resources/missile.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColDisparoJugador(this);
		inteligenciaMovimiento = new InteligenciaAscendenteRecta();
	}

	public void update() {
		inteligenciaMovimiento.mover(this);
		if (y <= 0)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaDisparoJugador(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		destruir();
	}

	@Override
	public void golpear(Entity e) {
		e.quitaVida(daño);
	}

	public int obtenerPuntaje() {
		return 0;
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
	}
}
