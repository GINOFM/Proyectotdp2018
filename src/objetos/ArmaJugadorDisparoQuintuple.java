package objetos;

import entidades.Entity;
import entidades.Player;
import gamestates.NivelState;
import inteligencias.InteligenciaAscendenteDiagonalDerecha;
import inteligencias.InteligenciaAscendenteDiagonalIzquierda;

public class ArmaJugadorDisparoQuintuple extends ArmaJugador{

	public ArmaJugadorDisparoQuintuple(Player jugador) {
		super(jugador);
	}

	public void disparar(NivelState nivelActual) {
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 16, jugador.getY() - 10));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 7, jugador.getY() - 7));
		nivelActual.addEntity(new DisparoJSimple(jugador.getX() + 25, jugador.getY() - 7));	
		Entity disparoDerecha = new DisparoJSimple(jugador.getX() + 32, jugador.getY() - 5);
		disparoDerecha.setInteligencia(new InteligenciaAscendenteDiagonalDerecha());
		nivelActual.addEntity(disparoDerecha);
		Entity disparoIzquierda = new DisparoJSimple(jugador.getX() + 0, jugador.getY() - 5);
		disparoIzquierda.setInteligencia(new InteligenciaAscendenteDiagonalIzquierda());
		nivelActual.addEntity(disparoIzquierda);
	}

	@Override
	public void mejorarArma() {
		
	}

}
