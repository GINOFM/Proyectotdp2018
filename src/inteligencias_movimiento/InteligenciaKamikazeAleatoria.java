package inteligencias_movimiento;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;
import entidades.Player;
import inteligencias_disparo.InteligenciaDisparoSimple;

public class InteligenciaKamikazeAleatoria extends InteligenciaMovimientoPlayerRelated {

	private int puntox;

	public InteligenciaKamikazeAleatoria(Player jugador) {
		this.jugador = jugador;
	}

	public void mover(Entity entidad) {
		if (puntox > entidad.getX()) {
			entidad.setX(entidad.getX() + 1);
		}
		if (puntox < entidad.getX()) {
			entidad.setX(entidad.getX() - 1);
		}
		entidad.setY(entidad.getY() + 3);
		if(entidad.getY() > 480) {
			entidad.setY(0);
			entidad.setInteligenciaMovimiento(new InteligenciaAleatoriaAKamikazeAleatoria(jugador));
			entidad.setInteligenciaDisparo(new InteligenciaDisparoSimple());
			entidad.setImageActual(entidad.getImageAt(0));
		}
	}

	public int getPuntox() {
		return puntox;
	}

	public void setPuntox() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 320 * 2 + 1);
		puntox = randomNum;
	}
}
