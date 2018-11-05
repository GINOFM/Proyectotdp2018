package inteligencias;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;
import entidades.Player;

public class InteligenciaAleatoriaAKamiAleatoria implements InteligenciaMovimiento {

	private int puntox;
	private int puntoy;
	private Player jugador;
	private int duracion;
	private long tiempoActivado;

//	private boolean cambioSprite = false;

	public InteligenciaAleatoriaAKamiAleatoria(Player jugador) {
		this.jugador = jugador;
		setPuntox();
		setPuntoy();
		duracion = 10;
		tiempoActivado = System.currentTimeMillis();
	}

	public InteligenciaAleatoriaAKamiAleatoria() {
		setPuntox();
		setPuntoy();
	}

	public void mover(Entity entidad) {
//		if (cambioSprite == false) {
//			entidad.setImageActual(entidad.getImageAt(2));
//			cambioSprite = true;
//		}

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

	public boolean dispara() {
		return false;
	}

}
