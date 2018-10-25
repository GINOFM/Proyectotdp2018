package base;

import entidades.Enemy;
import entidades.Player;

public interface Visitor {

	public void visitJugador(Player jugador);
	
	public void visitEnemigo(Enemy enemigo);
	
}
