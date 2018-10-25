package builders;

import inteligencias.Inteligencia;
import inteligencias.InteligenciaHorizontal;

public class HorizontalBuilder extends Enemybuilder{

	@Override
	public void buildInteligencia() {
		Inteligencia inteligenciaO = new InteligenciaHorizontal();
		enemigo.setIntgc(inteligenciaO);
	}

}
