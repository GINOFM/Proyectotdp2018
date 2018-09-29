package inteligencias;

import java.util.concurrent.ThreadLocalRandom;

import entidades.Entity;

public class Inteligenciaaleatoria implements inteligencia {

	private int puntox;
	private int puntoy;
	public Inteligenciaaleatoria()
	{
		setPuntox();
		setPuntoy();
	}
	
	public void mover(Entity entidad, Entity objetivo) {

		if(puntox>entidad.getX())
		{
			entidad.setX(entidad.getX()+1);
		}
		if(puntox<entidad.getX())
		{
			entidad.setX(entidad.getX()-1);
		}
		if(puntoy>entidad.getY())
		{
			entidad.setY(entidad.getY()+1);
		}
		if(puntoy<entidad.getY())
		{
			entidad.setY(entidad.getY()-1);
		}
		if(puntox==entidad.getX() && puntoy==entidad.getY())
		{
			
			setPuntox();
			setPuntoy();
		}
	}

	public int getPuntox() {
		return puntox;
	}

	public void setPuntox() { 
		int randomNum = ThreadLocalRandom.current().nextInt(1, 320*2 + 1);
		puntox=randomNum;
	}

	public int getPuntoy() {
		return puntoy;
	}

	public void setPuntoy() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 240*2 + 1);
		puntoy=randomNum;
	}


}
