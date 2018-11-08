package builders;

import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaDisparoDummy;
import inteligencias.InteligenciaKamikazeDirigidoTemportal;
import inteligencias.InteligenciaMovimiento;

public class KamikazeDirigidoTemportalBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaKamikazeDirigidoTemportal(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoDummy();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		enemigo.setImageActual(enemigo.getImageAt(1));
	}
}