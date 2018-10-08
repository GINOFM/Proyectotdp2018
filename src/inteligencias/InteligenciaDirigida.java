package inteligencias;

import entidades.Entity;

public class InteligenciaDirigida implements Inteligencia {

	public InteligenciaDirigida() {
	}

	public void mover(Entity entidad, Entity objetivo) {

		int objetivoX = objetivo.getX();

		if (objetivoX > entidad.getX()) {
			entidad.setX(entidad.getX() + 4);
		}
		if (objetivoX < entidad.getX()) {
			entidad.setX(entidad.getX() - 4);
		}
		entidad.setY(entidad.getY() + 4);

	}

}
