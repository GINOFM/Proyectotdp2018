package builders;

import entidades.Enemy;
import gamestates.NivelState;

public abstract class Enemybuilder {
	
	protected Enemy enemigo;
	protected NivelState nivelActual;
	
	public Enemy getEnemigo()
	{
		return enemigo;
	}
	
	public abstract void crearEnemigo(int x,int y, NivelState nivelActual);
	
	public abstract void buildInteligencia();
}
