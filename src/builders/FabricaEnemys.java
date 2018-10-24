package builders;

import entidades.Enemy;
import gamestates.NivelState;

public class FabricaEnemys {

	private Enemybuilder enemigoBuilder;

	public void setEnemyBuilder(Enemybuilder eb) {
		enemigoBuilder = eb;
	}

	public void construirEnemigo(int x, int y, NivelState nivelActual) {
		enemigoBuilder.crearEnemigo(x, y, nivelActual);
		enemigoBuilder.buildInteligencia();
	}

	public Enemy getEnemigo() {
		return enemigoBuilder.getEnemigo();
	}
}
