package inteligencias;

import entidades.Entity;

public class InteligenciaAscendenteDiagonalIzquierda implements InteligenciaMovimiento{
	public void mover(Entity entidad) {
		entidad.setY(entidad.getY() - entidad.getVelocidadY());
		entidad.setX(entidad.getX() - 3);
	}

}
