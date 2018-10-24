package inteligencias;

import entidades.Entity;

public class InteligenciaAscendenteRecta implements Inteligencia{

	public void mover(Entity entidad) {
		entidad.setY(entidad.getY() - entidad.getVelocidadY());
	}

}
