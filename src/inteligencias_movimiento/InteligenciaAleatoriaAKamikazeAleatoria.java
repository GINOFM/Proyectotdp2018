package inteligencias_movimiento;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;
import entidades.Player;
import inteligencias_disparo.InteligenciaDisparoDummy;

public class InteligenciaAleatoriaAKamikazeAleatoria implements InteligenciaMovimiento {

	private int puntox;
	private int puntoy;
	private Player jugador;
	private int duracion;
	private long tiempoActivado;

	public InteligenciaAleatoriaAKamikazeAleatoria(Player jugador) {
		this.jugador = jugador;
		setPuntox();
		setPuntoy();
		duracion = 10;
		tiempoActivado = System.currentTimeMillis();
	}

	public InteligenciaAleatoriaAKamikazeAleatoria() {
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
		long tiempoActual = System.currentTimeMillis();
		long segundosTranscurridos = (tiempoActual - tiempoActivado) / 1000;
		if (segundosTranscurridos >= duracion) {
			entidad.setInteligenciaMovimiento(new InteligenciaKamikazeAleatoria(jugador));
			entidad.setInteligenciaDisparo(new InteligenciaDisparoDummy());
			entidad.setImageActual(entidad.getImageAt(2));
		}
	}

	public int getPuntox() {
		return puntox;
	}

	public void setPuntox() {
		int randomNum = ThreadLocalRandom.current().nextInt(10, 630 + 1);
		puntox = randomNum;
	}

	public int getPuntoy() {
		return puntoy;
	}

	public void setPuntoy() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 250 + 1);
		puntoy = randomNum;
	}
}
