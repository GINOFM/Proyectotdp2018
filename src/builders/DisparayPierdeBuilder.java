package builders;

import inteligencias.Inteligencia;
import inteligencias.InteligenciaDirigida;
import inteligencias.InteligenciaHorizontal;

public class DisparayPierdeBuilder extends Enemybuilder {

	@Override
	public void buildInteligencia() {
		Inteligencia inteligencia0 = new InteligenciaHorizontal();
		Inteligencia inteligencia1= new InteligenciaDirigida(nivelActual.getPlayer());
		enemigo.setIntgc(inteligencia0);
	//	enemigo.setInteligenciados(inteligencia1);
	//	enemigo.setPorcentaje(30);
		enemigo.setImageActual(enemigo.getImageAt(3));
	}

}
