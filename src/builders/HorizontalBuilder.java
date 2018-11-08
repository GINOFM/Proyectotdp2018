package builders;

import inteligencias_movimiento.InteligenciaHorizontal;
import inteligencias_movimiento.InteligenciaMovimiento;

public class HorizontalBuilder extends Enemybuilder{

	@Override
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaO = new InteligenciaHorizontal();
		enemigo.setInteligenciaMovimiento(inteligenciaO);
	}
}