package objetos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import base.ColPowerUp;
import entidades.Enemy;
import entidades.Entity;
import entidades.Player;
import inteligencias_disparo.InteligenciaDisparo;
import inteligencias_disparo.InteligenciaDisparoDummy;
import inteligencias_movimiento.InteligenciaDummy;
import inteligencias_movimiento.InteligenciaMovimiento;

public class PowerUpCongelar extends PowerUp implements Runnable {

	protected boolean activo;
	protected LinkedList<Entity> entidades;
	protected Map<Entity, InteligenciaMovimiento> mapeoEntIntMovimiento;
	protected Map<Entity, InteligenciaDisparo> mapeoEntIntDisparo;

	public PowerUpCongelar(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 1;
		loadImage("resources/powerup_freeze.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
		activo = false;
		entidades = new LinkedList<Entity>();
		mapeoEntIntMovimiento = new HashMap<Entity, InteligenciaMovimiento>();
		mapeoEntIntDisparo = new HashMap<Entity, InteligenciaDisparo>();
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
			mapeoEntIntMovimiento.put(entidad, entidad.getInteligencia());
			mapeoEntIntDisparo.put(entidad, entidad.getInteligenciaDisparo());
			entidad.setInteligenciaMovimiento(new InteligenciaDummy());
			entidad.setInteligenciaDisparo(new InteligenciaDisparoDummy());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			entidad.setInteligenciaMovimiento(mapeoEntIntMovimiento.get(entidad));
			entidad.setInteligenciaDisparo(mapeoEntIntDisparo.get(entidad));
		}
	}

}
