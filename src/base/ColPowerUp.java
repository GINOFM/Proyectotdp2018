package base;

import entidades.Entity;
import objetos.PowerUp;

public class ColPowerUp extends Colisionador{

	public ColPowerUp(PowerUp powerup) {
		entidad = powerup;
	}
	
	@Override
	public void chocaEnemigo(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaDisparoJugador(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaDisparoEnemigo(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaJugador(Entity e) {
		entidad.golpear(e);
	}

	@Override
	public void chocaEscombro(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaBarricada(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaPowerUp(Entity e) {
		// TODO Auto-generated method stub
		
	}

}
