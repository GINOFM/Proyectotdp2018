package objetos;

import base.Colisionador;
import entidades.Entity;
import inteligencias.Inteligencia;

public abstract class DisparoJugador extends Entity {

	protected int da�o;
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

	public int getDa�o() {
		return da�o;
	}

	public void activarMultiplicar() {
		multiplicar = true;
	}
	
	public void setMultiplicador(int valorMult) {
		multiplicador = valorMult;
	}
}
