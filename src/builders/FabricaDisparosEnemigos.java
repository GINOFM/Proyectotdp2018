package builders;

import gamestates.NivelState;
import objetos.DisparoEnemigo;

public class FabricaDisparosEnemigos {
	private DisparoEnemigoBuilder disparoEnemigoBuilder;

	public void setEnemyBuilder(DisparoEnemigoBuilder eb) {
		disparoEnemigoBuilder = eb;
	}

	public void construirDisparo(int x, int y, NivelState nivelActual) {
		disparoEnemigoBuilder.crearDisparo(x, y, nivelActual);
		disparoEnemigoBuilder.buildInteligencia();
	}

	public DisparoEnemigo getDisparo() {
		return disparoEnemigoBuilder.getDisparo();
	}
}
