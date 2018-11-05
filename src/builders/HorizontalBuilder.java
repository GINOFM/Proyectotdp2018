package builders;

import inteligencias.InteligenciaHorizontal;
import inteligencias.InteligenciaMovimiento;

public class HorizontalBuilder extends Enemybuilder{

	@Override
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaO = new InteligenciaHorizontal();
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}