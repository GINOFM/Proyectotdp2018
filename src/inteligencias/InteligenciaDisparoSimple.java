package inteligencias;

import entidades.Entity;
import objetos.DisparoEnemigoSimple;

public class InteligenciaDisparoSimple implements InteligenciaDisparo {
	private long lastTime;
	
	public void disparar(Entity entidad) {
		long now = System.currentTimeMillis();
		if ((now - lastTime) / 60 > 22) {
			lastTime = now;
			entidad.getNivel().addEntity(new DisparoEnemigoSimple(entidad.getX()+6, entidad.getY() + 15));
		}
	}
}
