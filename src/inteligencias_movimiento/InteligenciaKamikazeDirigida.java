package inteligencias_movimiento;

import entidades.Entity;
import entidades.Player;

public class InteligenciaKamikazeDirigida extends InteligenciaMovimientoPlayerRelated {

	protected int velocidadX;
	protected int velocidadY;

	public InteligenciaKamikazeDirigida(Player jugador) {
		this.jugador = jugador;
	}

	public void mover(Entity entidad) {
		velocidadX = (int) (jugador.getX() - entidad.getX()) / 5;
		velocidadY = (int) (jugador.getY() - entidad.getY()) / 5;
		float factor = (float) (3 / Math.sqrt(velocidadX * velocidadX + velocidadY * velocidadY));
		velocidadX = (int) (velocidadX * factor);
		velocidadY = (int) (velocidadY * factor);

		entidad.setX(entidad.getX() + velocidadX);
		entidad.setY(entidad.getY() + 2);
		if(entidad.getY() > 480) {
			entidad.setY(0);
		}
	}
}
