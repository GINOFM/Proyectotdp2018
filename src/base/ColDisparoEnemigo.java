package base;

import entidades.Entity;
import objetos.DisparoEnemigoSimple;

public class ColDisparoEnemigo extends Colisionador{

	
	public ColDisparoEnemigo(DisparoEnemigoSimple disparoESimple) {
		entidad = disparoESimple;
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

}
