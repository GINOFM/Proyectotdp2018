package objetos;

import java.awt.Graphics;
import base.ColDisparoEnemigo;
import base.Colisionador;
import entidades.Entity;
import entidades.Player;
import inteligencias_movimiento.InteligenciaDirigida;

public class DisparoEnemigoDirigido extends DisparoEnemigo {

	protected Player jugador;
	
	public DisparoEnemigoDirigido(int x, int y, Player jugador) {
		super(x, y);
		this.jugador = jugador;
		initCraft();
	}

	protected void initCraft() {
		daño = 5;
		loadImage("resources/disparo_alien_redondo.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColDisparoEnemigo(this);
		inteligenciaMovimiento = new InteligenciaDirigida(x, y, jugador);
	}

	public void update() {
		if (y >= 480) {
			destruir();
		}
		inteligenciaMovimiento.mover(this);
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

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
	}
}