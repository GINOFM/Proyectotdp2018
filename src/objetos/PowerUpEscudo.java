package objetos;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Player;

public class PowerUpEscudo extends PowerUp {

	public PowerUpEscudo(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_escudo.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	public void visitJugador(Player jugador) {
		jugador.setMiEscudo(new Escudo(jugador.getX(), jugador.getY() - 20, jugador.getNivel()));
		jugador.getNivel().getBarraEscudo().setEscudo(jugador.getMiEscudo());
		jugador.getNivel().addEntity(jugador.getMiEscudo());
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
