package objetos;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Player;

public class PowerUpMultiplicador extends PowerUp{

	public PowerUpMultiplicador(int x, int y) {
		super(x, y);
		initCraft();
	}

	public void visitJugador(Player jugador) {
		
	}

	@Override
	public void visitEnemigo(Enemy enemigo) {
		// TODO Auto-generated method stub
		
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_multiplicador.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
		
	}

}
