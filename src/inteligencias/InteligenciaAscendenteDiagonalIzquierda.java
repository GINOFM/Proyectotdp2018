package inteligencias;

import entidades.Entity;

public class InteligenciaAscendenteDiagonalIzquierda implements Inteligencia{
	public void mover(Entity entidad) {
		entidad.setY(entidad.getY() - entidad.getVelocidadY());
		entidad.setX(entidad.getX() - 3);
	}

	@Override
	public boolean dispara() {
		// TODO Auto-generated method stub
		return false;
	}
}
