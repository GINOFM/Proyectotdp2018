package objetos;

import entidades.Entity;
import gamestates.NivelState;

public abstract class Escudo extends Entity {

	protected NivelState nivelActual;

	public Escudo(int x, int y, NivelState na) {
		super(x, y);
		this.nivelActual = na;
	}

}
