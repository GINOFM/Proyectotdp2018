package base;

import entidades.Entity;
import entidades.Player;

public class ColJugador extends Colisionador{

	public ColJugador(Player player) {
		entidad = player;
	}

	@Override
	public void chocaEnemigo(Entity e) {
		entidad.golpear(e);
		
	}

	@Override
	public void chocaDisparoJugador(Entity e) {
		// TODO Auto-generated method stub
		
	}

	public void chocaDisparoEnemigo(Entity e) {
		entidad.golpear(e);
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

}
