package base;

import entidades.Entity;
import entidades.Obstaculo;

public class ColEscombro extends Colisionador {

	public ColEscombro(Obstaculo escombro) {
		entidad = escombro;
	}

	@Override
	public void chocaEnemigo(Entity e) {
		// TODO Auto-generated method stub

	}

	public void chocaDisparoJugador(Entity e) {
		entidad.golpear(e);
	}

	public void chocaDisparoEnemigo(Entity e) {
		entidad.golpear(e);
	}

	@Override
	public void chocaJugador(Entity e) {
		
	}

	public void chocaBarricada(Entity e) {
		// TODO Auto-generated method stub

	}

	public void chocaEscombro(Entity e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void chocaPowerUp(Entity e) {
		// TODO Auto-generated method stub
		
	}

}
