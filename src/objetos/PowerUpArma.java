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
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	@Override
	public void serChocado(Colisionador col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocar(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitaVida(int dmg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpear(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

}
