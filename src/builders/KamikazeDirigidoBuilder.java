package builders;

import entidades.EnemyKamikazeDirigido;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoSimple;
import inteligencias_movimiento.InteligenciaAleatoriaAKamikazeDirigido;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeDirigidoBuilder extends Enemybuilder {

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyKamikazeDirigido(x,y, nivelActual);
	}
	
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaAleatoriaAKamikazeDirigido(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoSimple();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}
