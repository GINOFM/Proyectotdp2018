package builders;

import inteligencias.InteligenciaAleatoriaAKamikazeDirigido;
import inteligencias.InteligenciaMovimiento;

public class KamikazeDirigidoBuilder extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaO = new InteligenciaAleatoriaAKamikazeDirigido(nivelActual.getPlayer());
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}
