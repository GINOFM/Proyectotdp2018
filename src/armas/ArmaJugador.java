package armas;

import entidades.Player;
import gamestates.NivelState;

public abstract class ArmaJugador {

	protected Player jugador;

	public ArmaJugador(Player jugador) {
		this.jugador = jugador;
	}

	public abstract void disparar(NivelState nivelActual);
	
	public abstract void mejorarArma();
	
	public abstract void potenciar();
	
	public abstract void despotenciar();
}
