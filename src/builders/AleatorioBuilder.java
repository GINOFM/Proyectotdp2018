package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoria;
import inteligencias_movimiento.InteligenciaMovimiento;

public class AleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoria();
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		enemigo.setImageActual(enemigo.getImageAt(3));
	}
}
