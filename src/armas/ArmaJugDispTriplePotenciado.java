package armas;

import entidades.Player;
import gamestates.NivelState;
import objetos.DisparoJSimplePotenciado;

public class ArmaJugDispTriplePotenciado extends ArmaJugador {

	public ArmaJugDispTriplePotenciado(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 13, jugador.getY() - 10));
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 4, jugador.getY() - 6));
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 22, jugador.getY() - 6));		
	}

	@Override
	public void mejorarArma() {
		jugador.setArmaJugador(new ArmaJugDispQuintPotenciado(jugador));
	}

	@Override
	public void potenciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despotenciar() {
		jugador.setArmaJugador(new ArmaJugadorDisparoTriple(jugador));
	}

}