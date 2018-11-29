package builders;

import entidades.EnemyAleatorioPerdible;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaPerdible;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeAleatorioPerdibleBuilder  extends Enemybuilder {

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyAleatorioPerdible(x,y, nivelActual);
	}
	
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaPerdible(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}