package builders;

import gamestates.NivelState;
import inteligencias.InteligenciaDescendienteRecta;
import objetos.DisparoEnemigoSimple;

public class DisparoSimpleDescendienteBuilder extends DisparoEnemigoBuilder {

	public void crearDisparo(int x, int y, NivelState nivelActual) {
		this.nivelActual = nivelActual;
		disparoEnemigo = new DisparoEnemigoSimple(x, y);
		buildInteligencia();
	}

	public void buildInteligencia() {
		disparoEnemigo.setInteligenciaMovimiento(new InteligenciaDescendienteRecta());
	}

}
