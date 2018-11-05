package builders;

import inteligencias.InteligenciaKamikazeDirigidoTemportal;
import inteligencias.InteligenciaMovimiento;

public class KamikazeDirigidoTemportalBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaO = new InteligenciaKamikazeDirigidoTemportal(nivelActual.getPlayer());
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}