package builders;

import inteligencias.Inteligencia;
import inteligencias.Inteligenciadirigida;

public class KamikazeBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {

		Inteligencia inteligenciaO = new Inteligenciadirigida();
		enemigo.setIntgc(inteligenciaO);
	}

}
