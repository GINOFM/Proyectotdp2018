package inteligencias;

import java.util.Random;

import entidades.Entity;
import objetos.DisparoEnemigoSimple;

public class InteligenciaDisparoDirigido implements InteligenciaDisparo {

	private long tiempoActivado;
	private int intervaloEntreDisparos;
	private Random random;

	public InteligenciaDisparoDirigido() {
		tiempoActivado = System.currentTimeMillis();
		random = new Random();
		generarNuevoIntervalo();
	}

	public void disparar(Entity entidad) {
		
		long tiempoActual = System.currentTimeMillis();
		if ((tiempoActual - tiempoActivado) / 1000 >= intervaloEntreDisparos) {
			tiempoActivado = tiempoActual;
			entidad.getNivel().addEntity(new DisparoEnemigoSimple(entidad.getX() + 6, entidad.getY() + 15));
			generarNuevoIntervalo();
		}
	}
	
	public void generarNuevoIntervalo() {
		int chance = random.nextInt(3) + 3;
		intervaloEntreDisparos = chance;
	}
}