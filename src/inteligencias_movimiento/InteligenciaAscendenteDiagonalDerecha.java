package inteligencias_movimiento;

import entidades.Entity;

public class InteligenciaAscendenteDiagonalDerecha implements InteligenciaMovimiento{

	public void mover(Entity entidad) {
		entidad.setY(entidad.getY() - entidad.getVelocidadY());
		entidad.setX(entidad.getX() + 3);
	}

}
