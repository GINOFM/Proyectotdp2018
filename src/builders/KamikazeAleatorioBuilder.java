package builders;

import inteligencias.InteligenciaAleatoriaAKamiAleatoria;
import inteligencias.InteligenciaMovimiento;

public class KamikazeAleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {

		InteligenciaMovimiento inteligenciaO = new InteligenciaAleatoriaAKamiAleatoria(nivelActual.getPlayer());
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}
