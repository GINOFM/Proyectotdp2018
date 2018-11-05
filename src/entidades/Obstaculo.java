package entidades;

import base.Colisionador;

public abstract class Obstaculo extends Entity{

	protected int salud;
	protected Colisionador col;
	
	public Obstaculo(int x, int y) {
		super(x, y);
	}
}
