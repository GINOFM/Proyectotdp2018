package objetos;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Player;

public class PowerUpArma extends PowerUp{

	public PowerUpArma(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_arma.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	public void visitJugador(Player jugador) {
		jugador.mejorarNave();
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
