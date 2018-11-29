package builders;

import entidades.EnemyKamikazeAleatorio;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaAKamikazeAleatoria;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeAleatorioBuilder extends Enemybuilder {

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyKamikazeAleatorio(x,y, nivelActual);
	}
	
	public void buildInteligencia() {

		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeAleatoria(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
