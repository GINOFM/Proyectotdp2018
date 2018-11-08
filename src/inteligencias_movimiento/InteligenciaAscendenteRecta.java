package inteligencias_movimiento;

import entidades.Entity;

public class InteligenciaAscendenteRecta implements InteligenciaMovimiento{

	public void mover(Entity entidad) {
		entidad.setY(entidad.getY() - entidad.getVelocidadY());
	}

}
