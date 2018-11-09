package base;

import entidades.Entity;
import objetos.DisparoJugador;

public class ColDisparoJugador extends Colisionador {

	public ColDisparoJugador(DisparoJugador disparoJSimple) {
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

	public void chocaEscombro(Entity e) {
		entidad.golpear(e);
	}

	public void chocaBarricada(Entity e) {
		entidad.golpear(e);
	}

	@Override
	public void chocaPowerUp(Entity e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void chocaEscudo(Entity e) {
		// TODO Auto-generated method stub
		
	}
}
