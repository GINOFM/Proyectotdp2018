package base;

import entidades.Enemy;
import entidades.Entity;

public class ColEnemigo extends Colisionador {

	public ColEnemigo(Enemy enemigo) {
		entidad = enemigo;
	}

	public void chocaEnemigo(Entity e) {

	}

	public void chocaDisparoJugador(Entity e) {
		entidad.golpear(e);
	}

	@Override
	public void chocaDisparoEnemigo(Entity e) {
		// TODO Auto-generated method stub
	}

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

	@Override
	public void chocaEscudo(Entity e) {
		entidad.golpear(e);
		
	}
}
