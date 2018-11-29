package objetos;

import entidades.Entity;

public abstract class DisparoJugador extends Entity {

	protected int daño;

	public DisparoJugador(int x, int y) {
		super(x, y);

	}

	public int getDaño() {
		return daño;
	}

}
