package builders;

import base.Controller;
import entidades.Enemy;

public class FabricaEnemys {

	private Enemybuilder EnemigoB;

	public void setEnemyBuilder(Enemybuilder eb) {
		EnemigoB = eb;
	}

	public void construirEnemigo(int x, int y, Controller c) {
		EnemigoB.crearEnemigo(x, y, c);
		EnemigoB.buildInteligencia();
	}

	public Enemy getEnemigo() {
		return EnemigoB.getEnemigo();
	}
}
