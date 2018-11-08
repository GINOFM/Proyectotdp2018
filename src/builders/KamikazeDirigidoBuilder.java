package builders;

import inteligencias.InteligenciaAleatoriaAKamikazeDirigido;
import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaDisparoSimple;
import inteligencias.InteligenciaMovimiento;

public class KamikazeDirigidoBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeDirigido(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
