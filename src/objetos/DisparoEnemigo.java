package objetos;

import base.Colisionador;
import entidades.Entity;

public abstract class DisparoEnemigo extends Entity{

	protected int da�o;
	protected Colisionador col;

	public DisparoEnemigo(int x, int y) {
		super(x, y);
	}
	
	public int getDa�o() {
		return da�o;
	}
	
}
