package objetos;

import java.util.LinkedList;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Entity;
import entidades.Player;

public class PowerUpCongelar extends PowerUp {

	protected boolean activo;

	public PowerUpCongelar(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_freeze.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
		activo = false;
	}

	public void visitJugador(Player jugador) {
		if (!activo) {
			activo = true;
			LinkedList<Entity> entidades = jugador.getNivel().getEntities();
			for (Entity e : entidades) {
				e.aceptarPowerUp(this);
			}
		}
	}

	public void visitEnemigo(Enemy enemigo) {
		enemigo.congelar();
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub

	}

}
