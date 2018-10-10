package inteligencias;

import entidades.Entity;

public class InteligenciaDirigida implements Inteligencia {

	private Entity objetivo;

	public InteligenciaDirigida(Entity objetivo) {
		this.objetivo = objetivo;
	}

	public void mover(Entity entidad) {
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
