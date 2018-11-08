package builders;

import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoDummy;
import inteligencias_movimiento.InteligenciaKamikazeDirigidoTemportal;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeDirigidoTemportalBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaKamikazeDirigidoTemportal(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoDummy();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		enemigo.setImageActual(enemigo.getImageAt(1));
	}
}