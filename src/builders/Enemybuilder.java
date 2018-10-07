package builders;

import base.Controller;
import entidades.Enemy;

public abstract class Enemybuilder {
	
	protected Enemy enemigo;
	
	public Enemy getEnemigo()
	{
		return enemigo;
	}
	
	public void crearEnemigo(int x,int y,Controller c)
	{
		enemigo = new Enemy(x,y,c);
	}
	
	public abstract void buildInteligencia();
}
