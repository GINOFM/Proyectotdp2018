package builders;

import gamestates.NivelState;
import objetos.DisparoEnemigo;

public abstract class DisparoEnemigoBuilder {
	
	protected DisparoEnemigo disparoEnemigo;
	protected NivelState nivelActual;
	
	public DisparoEnemigo getDisparo()
	{
		return disparoEnemigo;
	}
	
	public abstract void crearDisparo(int x,int y, NivelState nivelActual);
	
	public abstract void buildInteligencia();
}
