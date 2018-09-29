package builders;

import inteligencias.Inteligenciaaleatoria;
import inteligencias.inteligencia;

public class AleatorioBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {
		inteligencia inteligenciaO=new Inteligenciaaleatoria();
		enemigo.setIntgc(inteligenciaO);
		
	}

}
