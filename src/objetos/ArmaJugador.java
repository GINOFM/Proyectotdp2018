package objetos;

import entidades.Player;
import gamestates.NivelState;

public abstract class ArmaJugador {

	protected Player jugador;
	protected int multiplicador;

	public ArmaJugador(Player jugador) {
		this.jugador = jugador;
		multiplicador = 1;
	}

	public abstract void disparar(NivelState nivelActual);
	
	public abstract void mejorarArma();
}
