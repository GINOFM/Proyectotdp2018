package objetos;

import base.Colisionador;
import entidades.Entity;

public abstract class DisparoJugador extends Entity {

	protected int velocidadY;
	protected int daño;
	protected Colisionador col;

	public DisparoJugador(int x, int y) {
		super(x, y);
	}
	
	public int getDaño() {
		return daño;
	}

}
