package objetos;

import base.ColPowerUp;
import base.Colisionador;
import entidades.Entity;

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

}
