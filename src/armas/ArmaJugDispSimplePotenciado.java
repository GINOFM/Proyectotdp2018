package armas;

import entidades.Player;
import gamestates.NivelState;
import objetos.DisparoJSimplePotenciado;

public class ArmaJugDispSimplePotenciado extends ArmaJugador{

	public ArmaJugDispSimplePotenciado(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 11, jugador.getY() - 8));
	}

	@Override
	public void mejorarArma() {
		jugador.setArmaJugador(new ArmaJugDispTriplePotenciado(jugador));
		
	}

	@Override
	public void potenciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despotenciar() {
		jugador.setArmaJugador(new ArmaJugadorDisparoSimple(jugador));		
	}

}
