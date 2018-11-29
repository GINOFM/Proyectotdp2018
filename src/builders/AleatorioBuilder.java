package builders;

import entidades.EnemyAleatorio;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoria;
import inteligencias_movimiento.InteligenciaMovimiento;

public class AleatorioBuilder extends Enemybuilder {

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyAleatorio(x,y, nivelActual);
	}
	
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoria();
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
		
	}
}
