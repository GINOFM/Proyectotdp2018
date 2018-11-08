package builders;

import inteligencias.InteligenciaAleatoriaPerdible;
import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaDisparoSimple;
import inteligencias.InteligenciaMovimiento;

public class KamikazeAleatorioPerdibleBuilder  extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaPerdible(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}