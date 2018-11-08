package inteligencias;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;
import entidades.Player;

public class InteligenciaAleatoriaPerdible implements InteligenciaMovimiento {

	private int puntox;
	private int puntoy;
	private Player jugador;

	public InteligenciaAleatoriaPerdible(Player jugador) {
		this.jugador = jugador;
		setPuntox();
		setPuntoy();
	}

	public void mover(Entity entidad) {

		if (puntox > entidad.getX()) {
			entidad.setX(entidad.getX() + 1);
		}
		if (puntox < entidad.getX()) {
			entidad.setX(entidad.getX() - 1);
		}
		if (puntoy > entidad.getY()) {
			entidad.setY(entidad.getY() + 1);
		}
		if (puntoy < entidad.getY()) {
			entidad.setY(entidad.getY() - 1);
		}
		if (puntox == entidad.getX() && puntoy == entidad.getY()) {
			setPuntox();
			setPuntoy();
		}
		if (entidad.getSalud() <= (entidad.getSaludMaxima() * 0.2)) {
			entidad.setInteligenciaMovimiento(new InteligenciaKamikazeDirigida(jugador));
			entidad.setInteligenciaDisparo(new InteligenciaDisparoDummy());
			entidad.setImageActual(entidad.getImageAt(1));
		}
	}

	public int getPuntox() {
		return puntox;
	}

	public void setPuntox() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 320 * 2 + 1);
		puntox = randomNum;
	}

	public int getPuntoy() {
		return puntoy;
	}

	public void setPuntoy() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 250 + 1);
		puntoy = randomNum;
	}

	public boolean dispara() {
		return false;
	}

}