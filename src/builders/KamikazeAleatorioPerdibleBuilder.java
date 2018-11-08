package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaPerdible;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeAleatorioPerdibleBuilder  extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaPerdible(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}