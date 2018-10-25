package objetos;

import base.Colisionador;
import entidades.Entity;
import inteligencias.Inteligencia;

public abstract class DisparoJugador extends Entity {

	protected int daño;
	protected Colisionador col;
	protected int multiplicador;
	protected boolean multiplicar;
	protected int tiempoMultiplicar;

	public DisparoJugador(int x, int y) {
		super(x, y);
		multiplicador = 1;
		tiempoMultiplicar = 400;
		multiplicar = false;
	}

	public int getDaño() {
		return daño;
	}

	public void activarMultiplicar() {
		multiplicar = true;
	}
	
	public void setMultiplicador(int valorMult) {
		multiplicador = valorMult;
	}
}
