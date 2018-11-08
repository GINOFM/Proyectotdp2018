package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoDirigido;
import inteligencias_movimiento.InteligenciaAleatoria;
import inteligencias_movimiento.InteligenciaHorizontal;
import inteligencias_movimiento.InteligenciaMovimiento;

public class TestBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaHorizontal();
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoDirigido();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		enemigo.setImageActual(enemigo.getImageAt(4));
	}
}
