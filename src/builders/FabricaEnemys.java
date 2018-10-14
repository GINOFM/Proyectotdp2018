package builders;

import entidades.Enemy;
import gamestates.NivelState;

public class FabricaEnemys {

	private Enemybuilder enemigoBuilder;

	public void setEnemyBuilder(Enemybuilder eb) {
		enemigoBuilder = eb;
	}

	public void construirEnemigo(int x, int y, NivelState nivel) {
		enemigoBuilder.crearEnemigo(x, y, nivel);
		enemigoBuilder.buildInteligencia();
	}

	public Enemy getEnemigo() {
		return enemigoBuilder.getEnemigo();
	}
}
