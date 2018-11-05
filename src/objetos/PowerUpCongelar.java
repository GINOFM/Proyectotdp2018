package objetos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import base.ColPowerUp;
import entidades.Enemy;
import entidades.Entity;
import entidades.Player;
import inteligencias.InteligenciaDummy;
import inteligencias.InteligenciaMovimiento;

public class PowerUpCongelar extends PowerUp implements Runnable {

	protected boolean activo;
	protected LinkedList<Entity> entidades;
	protected Map<Entity, InteligenciaMovimiento> mapeoEntidadInteligencia;

	public PowerUpCongelar(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		velocidadX = 3;
		loadImage("resources/powerup_freeze.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
		activo = false;
		entidades = new LinkedList<Entity>();
		mapeoEntidadInteligencia = new HashMap<Entity, InteligenciaMovimiento>();
	}

	public void visitJugador(Player jugador) {
		if (!activo) {
			activo = true;
			LinkedList<Entity> entidades = jugador.getNivel().getEntities();
			for (Entity e : entidades) {
				e.aceptarPowerUp(this);
			}
			Thread hilo = new Thread(this);
			hilo.start();
		}
	}

	public void visitEnemigo(Enemy enemigo) {
		entidades.add(enemigo);
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {

	}

	public void run() {
		Entity entidad;
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			mapeoEntidadInteligencia.put(entidad, entidad.getInteligencia());
			entidad.setInteligenciaMovimiento(new InteligenciaDummy());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			entidad.setInteligenciaMovimiento(mapeoEntidadInteligencia.get(entidad));
		}
	}

}
