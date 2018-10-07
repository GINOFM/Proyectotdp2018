package builders;

import inteligencias.Inteligencia;
import inteligencias.InteligenciaAleatoria;

public class AleatorioBuilder extends Enemybuilder {

	public void buildInteligencia() {
		Inteligencia inteligenciaO = new InteligenciaAleatoria();
		enemigo.setIntgc(inteligenciaO);
	}

}
