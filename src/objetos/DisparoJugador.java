package objetos;

import base.Colisionador;
import entidades.Entity;
import inteligencias.Inteligencia;

public abstract class DisparoJugador extends Entity {

	protected int daño;
	protected Colisionador col;
	

	public DisparoJugador(int x, int y) {
		super(x, y);
	}

	public int getDaño() {
		return daño;
	}

	
}
