package base;

import entidades.Entity;
import objetos.DisparoJSimple;

public class ColDisparoJugador extends Colisionador{

	public ColDisparoJugador(DisparoJSimple disparoJSimple) {
		entidad = disparoJSimple;
	}

	public void chocaEnemigo(Entity e) {
		entidad.golpear(e);
	}

	public void chocaDisparoJugador(Entity e) {
		
	}

	public void chocaDisparoEnemigo(Entity e) {
		
	}

	public void chocaJugador(Entity e) {
		
	}

	@Override
	public void chocaObstaculo(Entity e) {
		// TODO Auto-generated method stub
		
	}

}
