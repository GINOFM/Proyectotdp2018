package inteligencias;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;
import entidades.Player;

public class InteligenciaAleatoriaAKamikazeDirigido implements InteligenciaMovimiento{

	private int puntox;
	private int puntoy;
	private Player jugador;
	private int contadorDeMovimientos;

//	private boolean cambioSprite = false;
	
	public InteligenciaAleatoriaAKamikazeDirigido(Player jugador) {
		this.jugador = jugador;
		contadorDeMovimientos = 3;
		setPuntox();
		setPuntoy();
	}

	public InteligenciaAleatoriaAKamikazeDirigido() {
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
			contadorDeMovimientos--;
		}
		if(contadorDeMovimientos <= 0) {
			entidad.setInteligenciaMovimiento(new InteligenciaKamikazeDirigidoAAleatoria(jugador));
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
