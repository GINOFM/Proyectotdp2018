package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaAKamikazeDirigido;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeDirigidoBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeDirigido(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
