package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaAKamikazeAleatoria;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeAleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {

		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeAleatoria(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
