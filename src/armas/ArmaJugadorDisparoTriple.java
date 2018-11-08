package armas;

import entidades.Player;
import gamestates.NivelState;
import objetos.DisparoJSimple;

public class ArmaJugadorDisparoTriple extends ArmaJugador{

	public ArmaJugadorDisparoTriple(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 13, jugador.getY() - 10));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 4, jugador.getY() - 6));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 22, jugador.getY() - 6));		
	}

	public void mejorarArma() {
		jugador.setArmaJugador(new ArmaJugadorDisparoQuintuple(jugador));
	}

	@Override
	public void potenciar() {
		jugador.setArmaJugador(new ArmaJugDispTriplePotenciado(jugador));
	}

	@Override
	public void despotenciar() {
		// TODO Auto-generated method stub
		
	}

}
