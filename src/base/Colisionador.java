package base;

import entidades.Entity;

public abstract class Colisionador {
	
	protected Entity entidad;

	public abstract void chocaEnemigo(Entity e);
	
	public abstract void chocaDisparoJugador(Entity e);
	
	public abstract void chocaDisparoEnemigo(Entity e);
	
	public abstract void chocaJugador(Entity e);
	
	public abstract void chocaEscombro(Entity e);
	
	public abstract void chocaBarricada(Entity e);
	
}
