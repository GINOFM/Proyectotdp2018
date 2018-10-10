package inteligencias;

import entidades.Entity;

public class InteligenciaDirigida implements Inteligencia {

	private Entity objetivo;
	
	public InteligenciaDirigida(Entity objetivo) {
		this.objetivo=objetivo;
	}
	
	public void mover(Entity entidad)
	{
		int objetivoX=objetivo.getX();
		int objetivoY=objetivo.getY();
		
		if(objetivoX>entidad.getX())
		{
			entidad.setX(entidad.getX()+5);
		}
		if(objetivoX<entidad.getX())
		{
			entidad.setX(entidad.getX()-5);
		}
		if(objetivoY>entidad.getY())
		{
			entidad.setY(entidad.getY()+5);
		}
		if(objetivoY<entidad.getY())
		{
			entidad.setY(entidad.getY()-5);
		}
	}

}
