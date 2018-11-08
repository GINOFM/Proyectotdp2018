package armas;

import entidades.Entity;
import entidades.Player;
import gamestates.NivelState;
import inteligencias.InteligenciaAscendenteDiagonalDerecha;
import inteligencias.InteligenciaAscendenteDiagonalIzquierda;
import objetos.DisparoJSimplePotenciado;

public class ArmaJugDispQuintPotenciado extends ArmaJugador {

	public ArmaJugDispQuintPotenciado(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 16, jugador.getY() - 10));
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 7, jugador.getY() - 7));
		nivelActual.addEntity(new DisparoJSimplePotenciado(jugador.getX() + 25, jugador.getY() - 7));	
		Entity disparoDerecha = new DisparoJSimplePotenciado(jugador.getX() + 32, jugador.getY() - 5);
		disparoDerecha.setInteligenciaMovimiento(new InteligenciaAscendenteDiagonalDerecha());
		nivelActual.addEntity(disparoDerecha);
		Entity disparoIzquierda = new DisparoJSimplePotenciado(jugador.getX() + 0, jugador.getY() - 5);
		disparoIzquierda.setInteligenciaMovimiento(new InteligenciaAscendenteDiagonalIzquierda());
		nivelActual.addEntity(disparoIzquierda);
	}

	public void mejorarArma() {
	}

	@Override
	public void potenciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despotenciar() {
		jugador.setArmaJugador(new ArmaJugadorDisparoQuintuple(jugador));
	}

}
