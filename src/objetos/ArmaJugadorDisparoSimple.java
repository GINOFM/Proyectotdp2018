package objetos;

import entidades.Player;
import gamestates.NivelState;

public class ArmaJugadorDisparoSimple extends ArmaJugador {

	public ArmaJugadorDisparoSimple(int posNaveX, int posNaveY, Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 11, jugador.getY() - 8));
	}

	public void mejorarArma() {
		jugador.setArmaJugador(new ArmaJugadorDisparoTriple(jugador));
	}

}
