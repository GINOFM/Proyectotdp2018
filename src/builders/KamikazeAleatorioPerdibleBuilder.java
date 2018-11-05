package builders;

import inteligencias.InteligenciaAleatoriaPerdible;
import inteligencias.InteligenciaMovimiento;

public class KamikazeAleatorioPerdibleBuilder  extends Enemybuilder {

	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaO = new InteligenciaAleatoriaPerdible(nivelActual.getPlayer());
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}