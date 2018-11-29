package objetos;

import java.awt.Graphics;

import base.ColDisparoEnemigo;
import base.Colisionador;
import entidades.Entity;
import inteligencias_movimiento.InteligenciaDescendienteRecta;
import inteligencias_movimiento.InteligenciaDirigida;

public class DisparoEnemigoSimple extends DisparoEnemigo {

	public DisparoEnemigoSimple(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 5;
		daño = 5;
		loadImage("resources/disparo_alien.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColDisparoEnemigo(this);
		inteligenciaMovimiento = new InteligenciaDescendienteRecta();
	}
		
	public void update() {
		inteligenciaMovimiento.mover(this);
		if (y >= 480)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaDisparoEnemigo(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		destruir();
	}

	public void golpear(Entity e) {
		e.quitaVida(5);
	}

	public int obtenerPuntaje() {
		return 0;
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
	}
}
