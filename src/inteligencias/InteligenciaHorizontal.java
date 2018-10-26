package inteligencias;

import entidades.Entity;

public class InteligenciaHorizontal implements Inteligencia {

	private int puntoXmaximo = 310 * 2;
	private int puntoXminimo = 0;
	private boolean izquierda = true;

	@Override
	public void mover(Entity entidad) {

		if (izquierda == true) {
			if (entidad.getX() < puntoXmaximo) {
				entidad.setX(entidad.getX() + 1);
			} else
				izquierda = false;
		} else if (entidad.getX() > puntoXminimo) {
			entidad.setX(entidad.getX() - 1);
		} else
			izquierda = true;

	}

	@Override
	public boolean dispara() {
		return true;
	}

}
