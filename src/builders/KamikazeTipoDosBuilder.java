package builders;

import inteligencias.Inteligencia;
import inteligencias.InteligenciaAleatoria;
import inteligencias.InteligenciaDirigida;

public class KamikazeTipoDosBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {
		Inteligencia inteligencia0 = new InteligenciaDirigida(nivelActual.getPlayer());
		Inteligencia inteligencia1= new InteligenciaAleatoria();
		enemigo.setIntgc(inteligencia0);
	//	enemigo.setInteligenciados(inteligencia1);
	//	enemigo.setPorcentaje(20);
	}

}
