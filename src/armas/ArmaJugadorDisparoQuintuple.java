package armas;

import entidades.Entity;
import entidades.Player;
import gamestates.NivelState;
import inteligencias.InteligenciaAscendenteDiagonalDerecha;
import inteligencias.InteligenciaAscendenteDiagonalIzquierda;
import objetos.DisparoJSimple;

public class ArmaJugadorDisparoQuintuple extends ArmaJugador {

	public ArmaJugadorDisparoQuintuple(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 16, jugador.getY() - 10));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 7, jugador.getY() - 7));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 25, jugador.getY() - 7));
		Entity disparoDerecha = new DisparoJSimple(jugador.getX() + 32, jugador.getY() - 5);
		disparoDerecha.setInteligenciaMovimiento(new InteligenciaAscendenteDiagonalDerecha());
		nivelActual.addEntity(disparoDerecha);
		Entity disparoIzquierda = new DisparoJSimple(jugador.getX() + 0, jugador.getY() - 5);
		disparoIzquierda.setInteligenciaMovimiento(new InteligenciaAscendenteDiagonalIzquierda());
		nivelActual.addEntity(disparoIzquierda);
	}

	@Override
	public void mejorarArma() {

	}

	@Override
	public void potenciar() {
		jugador.setArmaJugador(new ArmaJugDispQuintPotenciado(jugador));
	}

	@Override
	public void despotenciar() {
		// TODO Auto-generated method stub
	}
}
