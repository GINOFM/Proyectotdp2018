package armas;

import entidades.Player;
import gamestates.NivelState;
import objetos.DisparoJSimple;

public class ArmaJugadorDisparoSimple extends ArmaJugador {

	public ArmaJugadorDisparoSimple(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 11, jugador.getY() - 8));
	}

	public void mejorarArma() {
		jugador.setArmaJugador(new ArmaJugadorDisparoTriple(jugador));
	}

	@Override
	public void potenciar() {
		jugador.setArmaJugador(new ArmaJugDispSimplePotenciado(jugador));
		
	}

	@Override
	public void despotenciar() {
		// TODO Auto-generated method stub
	}
}
