package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import base.Fondo;
import builders.FabricaEnemys;
import entidades.Entity;
import entidades.Player;

public abstract class NivelState extends GameState {

	private LinkedList<Entity> entidades = new LinkedList<Entity>();
	private LinkedList<Entity> entidadesABorrar = new LinkedList<Entity>();

	private Entity entidad;
	private Entity entidadAux;
	private Player player;
	private int puntaje;
	private Fondo fondo;
	FabricaEnemys fabrica;

	public NivelState() {
		fondo = new Fondo();
		player = new Player(200, 420, this);
		puntaje = 0;
		addEntity(player);
		fabrica = new FabricaEnemys();
	}

	public void update() {
		fondo.update();
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			entidad.update();
		}

		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			for (int j = 0; j < entidades.size(); j++) {
				if (i != j) {
					entidadAux = entidades.get(j);
					if (entidad.getBounds().intersects(entidadAux.getBounds())) {
						entidad.chocar(entidadAux);
					}
				}
			}
		}

		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			if (!entidad.estaActivo()) {
				entidadesABorrar.add(entidad);
			}
		}

		for (int i = 0; i < entidadesABorrar.size(); i++) {
			entidad = entidadesABorrar.get(i);
			puntaje = puntaje + entidad.obtenerPuntaje();
			entidades.remove(entidad);
		}

		entidadesABorrar.clear();

	}

	public void render(Graphics g) {
		fondo.render(g);
		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Puntaje: " + puntaje, 10, 460);
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			entidad.render(g);
		}
	}

	public void addEntity(Entity entity) {
		entidades.add(entity);
	}

	public Player getPlayer() {
		return player;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			player.setVelX(5);
		} else if (key == KeyEvent.VK_LEFT) {
			player.setVelX(-5);
		} else if (key == KeyEvent.VK_SPACE && !player.getIsShooting()) {
			player.setIsShooting(true);
			player.disparar();
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			player.setVelX(0);
		} else if (key == KeyEvent.VK_LEFT) {
			player.setVelX(0);
		} else if (key == KeyEvent.VK_SPACE) {
			player.setIsShooting(false);
		}

	}

}
