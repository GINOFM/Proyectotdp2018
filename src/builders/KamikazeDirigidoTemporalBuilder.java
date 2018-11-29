package builders;

import entidades.EnemyDirigidoTemporal;
import gamestates.NivelState;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoDummy;
import inteligencias_movimiento.InteligenciaKamikazeDirigidoTemporal;
import inteligencias_movimiento.InteligenciaMovimiento;

public class KamikazeDirigidoTemporalBuilder extends Enemybuilder {

	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new EnemyDirigidoTemporal(x,y, nivelActual);
	}
	
	public void buildInteligencia() {
		InteligenciaMovimiento inteligenciaMovimiento = new InteligenciaKamikazeDirigidoTemporal(nivelActual.getPlayer());
		InteligenciaDisparo inteligenciaDisparo = new InteligenciaDisparoDummy();
		enemigo.setInteligenciaMovimiento(inteligenciaMovimiento);
		enemigo.setInteligenciaDisparo(inteligenciaDisparo);
	}
}