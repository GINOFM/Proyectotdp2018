package inteligencias;

import entidades.Entity;

public class InteligenciaDirigida implements InteligenciaMovimiento {

	private Entity objetivo;

	private int puntoXmaximo = 310 * 2;
	private int puntoXminimo = 0;
	private boolean izquierda = true;
	private boolean dirigir = false;
	private long lastTime = System.currentTimeMillis();;
	private int yInicial = -1;
	private boolean puedeDisparar = true;

	public InteligenciaDirigida(Entity objetivo) {
		this.objetivo = objetivo;
	}

	public void mover(Entity entidad) {
		if (yInicial == -1) {
			entidad.setImageActual(entidad.getImageAt(1));
			yInicial = entidad.getY();
		}

		if (dirigir == true) {
			movimientodirigido(entidad);
			puedeDisparar = false;
		} else {
			movimientohorizontal(entidad);
			puedeDisparar = true;
		}
	}

	private void movimientohorizontal(Entity entidad) {
		long now = System.currentTimeMillis();
		if ((now - lastTime) > 6000) {
			dirigir = true;
		}
		if (entidad.getY() != yInicial) {
			entidad.setY(entidad.getY() + 1);
		}
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

	private void movimientodirigido(Entity entidad) {
		int objetivoX = objetivo.getX();
		if (objetivoX > entidad.getX()) {
			entidad.setX(entidad.getX() + 4);
		}
		if (objetivoX < entidad.getX()) {
			entidad.setX(entidad.getX() - 4);
		}
		entidad.setY(entidad.getY() + 4);

		if (entidad.outOfBounds()) {
			lastTime = System.currentTimeMillis();
			dirigir = false;
		}
	}
}
