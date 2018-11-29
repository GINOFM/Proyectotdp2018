package objetos;

import base.Colisionador;
import entidades.Entity;

public abstract class DisparoEnemigo extends Entity{

	protected int daño;
	protected Colisionador col;

	public DisparoEnemigo(int x, int y) {
		super(x, y);
	}
	
	public int getDaño() {
		return daño;
	}
	
}
