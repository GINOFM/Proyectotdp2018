package builders;

import inteligencias.Inteligencia;
import inteligencias.InteligenciaDirigida;

public class KamikazeBuilder extends Enemybuilder {

	public void buildInteligencia() {

		Inteligencia inteligenciaO = new InteligenciaDirigida(nivel.getPlayer());
		enemigo.setIntgc(inteligenciaO);
	}

}
