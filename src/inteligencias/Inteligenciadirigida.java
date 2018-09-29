package inteligencias;

import entidades.Entity;

public class Inteligenciadirigida implements inteligencia {
	
	
	public Inteligenciadirigida() {}
	
	public void mover(Entity entidad,Entity objetivo)
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
