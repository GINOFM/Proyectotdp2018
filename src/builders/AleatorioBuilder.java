package builders;

import inteligencias.InteligenciaAleatoria;
import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaDisparoSimple;
import inteligencias.InteligenciaMovimiento;

public class AleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoria();
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		enemigo.setImageActual(enemigo.getImageAt(3));
	}
}
