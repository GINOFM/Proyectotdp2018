package inteligencias;

import entidades.Entity;
import entidades.Player;

public class InteligenciaKamikazeDirigida implements InteligenciaMovimiento {

	protected Player jugador;

	public InteligenciaKamikazeDirigida(Player jugador) {
		this.jugador = jugador;
	}

	public void mover(Entity entidad) {
		int objetivoX = jugador.getX();
		if (objetivoX > entidad.getX()) {
			entidad.setX(entidad.getX() + 3);
		}
		if (objetivoX < entidad.getX()) {
			entidad.setX(entidad.getX() - 3);
		}
		entidad.setY(entidad.getY() + 2);
		if(entidad.getY() > 480) {
			entidad.setY(0);
		}
	}
}
