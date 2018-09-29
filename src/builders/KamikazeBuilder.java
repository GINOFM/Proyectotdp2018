package builders;

import inteligencias.Inteligenciadirigida;
import inteligencias.inteligencia;

public class KamikazeBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {
		
		inteligencia inteligenciaO=new Inteligenciadirigida();
		enemigo.setIntgc(inteligenciaO);
	}

}
