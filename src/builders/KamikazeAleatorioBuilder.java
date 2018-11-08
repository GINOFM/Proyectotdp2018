package builders;

import inteligencias.InteligenciaAleatoriaAKamikazeAleatoria;
import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaDisparoSimple;
import inteligencias.InteligenciaMovimiento;

public class KamikazeAleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {

		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeAleatoria(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
