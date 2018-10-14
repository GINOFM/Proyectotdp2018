package builders;

import entidades.Enemy;
import gamestates.NivelState;

public abstract class Enemybuilder {
	
	protected Enemy enemigo;
	protected NivelState nivel;
	
	public Enemy getEnemigo()
	{
		return enemigo;
	}
	
	public void crearEnemigo(int x,int y, NivelState nivel)
	{
		this.nivel = nivel;
		
		enemigo = new Enemy(x,y, nivel);
	}
	
	public abstract void buildInteligencia();
}
