package base;

import entidades.Entity;
import objetos.DisparoEnemigo;

public class ColDisparoEnemigo extends Colisionador{

	public ColDisparoEnemigo(DisparoEnemigo disparo) {
		entidad = disparo;
	}

	public void chocaEnemigo(Entity e) {
		
	}

	@Override
	public void chocaDisparoJugador(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaDisparoEnemigo(Entity e) {
		// TODO Auto-generated method stub
		
	}

	public void chocaJugador(Entity e) {
		entidad.golpear(e);
	}

	public void chocaBarricada(Entity e) {
	}

	public void chocaEscombro(Entity e) {
		entidad.golpear(e);
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
