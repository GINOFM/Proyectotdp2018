package builders;

import entidades.EnemyHorizontalDirigido;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoDirigido;
import inteligencias_movimiento.InteligenciaHorizontal;
import inteligencias_movimiento.InteligenciaMovimiento;

public class HorizontalBuilder extends Enemybuilder{

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyHorizontalDirigido(x,y, nivelActual);
	}
	
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaHorizontal();
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoDirigido();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}