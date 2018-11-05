package base;

import entidades.Entity;
import entidades.Obstaculo;

public class ColBarricada extends Colisionador {

	public ColBarricada(Obstaculo barricada) {
		entidad = barricada;
	}

	@Override
	public void chocaEnemigo(Entity e) {
		// TODO Auto-generated method stub

	}

	public void chocaDisparoJugador(Entity e) {
		entidad.golpear(e);
	}

	@Override
	public void chocaDisparoEnemigo(Entity e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chocaJugador(Entity e) {
		// TODO Auto-generated method stub

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
