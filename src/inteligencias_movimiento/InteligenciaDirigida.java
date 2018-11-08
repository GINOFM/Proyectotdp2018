package inteligencias_movimiento;

import entidades.Entity;
import entidades.Player;

public class InteligenciaDirigida implements InteligenciaMovimiento {
	protected Player jugador;
	protected int velocidadX;
	protected int velocidadY;

	public InteligenciaDirigida(int x, int y, Player jugador) {
		this.jugador = jugador;
		velocidadX = (int) (jugador.getX() - x);
		velocidadY = (int) (jugador.getY() - y);
		float factor = (float) ( 5 / Math.sqrt(velocidadX * velocidadX + velocidadY * velocidadY));
		velocidadX = (int) (velocidadX * factor);
		velocidadY = (int) (velocidadY * factor);


	}

	public void mover(Entity entidad) {
		if (entidad.getY() >= 480) {
			entidad.setY(0);
		}
		entidad.setX(entidad.getX() + velocidadX);
		entidad.setY(entidad.getY() + velocidadY);

	}
}
