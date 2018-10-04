package builders;

import inteligencias.Inteligencia;
import inteligencias.Inteligenciaaleatoria;

public class AleatorioBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {
		Inteligencia inteligenciaO=new Inteligenciaaleatoria();
		enemigo.setIntgc(inteligenciaO);
		
	}

}
