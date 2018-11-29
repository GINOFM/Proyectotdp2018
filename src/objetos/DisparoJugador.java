package objetos;

import entidades.Entity;

public abstract class DisparoJugador extends Entity {

	protected int da�o;

	public DisparoJugador(int x, int y) {
		super(x, y);

	}

	public int getDa�o() {
		return da�o;
	}

}
