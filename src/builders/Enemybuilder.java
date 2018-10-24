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
	
	public void crearEnemigo(int x,int y, NivelState nivelActual)
	{
		this.nivelActual = nivelActual;
		enemigo = new Enemy(x,y, nivelActual);
	}
	
	public abstract void buildInteligencia();
}
