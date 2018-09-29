package objetos;

import base.Colisionador;
import entidades.Entity;

public abstract class DisparoJugador extends Entity {

	protected int velocidadY;
	protected int da�o;
	protected Colisionador col;

	public DisparoJugador(int x, int y) {
		super(x, y);
	}
	
	public int getDa�o() {
		return da�o;
	}

}
