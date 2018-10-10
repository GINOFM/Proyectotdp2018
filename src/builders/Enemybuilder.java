package builders;

import base.Controller;
import entidades.Enemy;

public abstract class Enemybuilder {
	
	protected Enemy enemigo;
	protected Controller controlador;
	
	public Enemy getEnemigo()
	{
		return enemigo;
	}
	
	public void crearEnemigo(int x,int y,Controller c)
	{
		controlador=c;
		
		enemigo = new Enemy(x,y,controlador);
	}
	
	public abstract void buildInteligencia();
}
