package objetos;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Player;

public class PowerUpPocion extends PowerUp {

	public PowerUpPocion(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_pocion.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	public void visitJugador(Player jugador) {
		jugador.setSalud(jugador.getSalud() + 20);
	}

	@Override
	public void visitEnemigo(Enemy enemigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub

	}

}
