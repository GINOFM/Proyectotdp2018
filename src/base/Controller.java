package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import builders.AleatorioBuilder;
import builders.FabricaEnemys;
import builders.KamikazeBuilder;
import entidades.Enemy;
import entidades.Entity;
import entidades.Player;

public class Controller {

	private LinkedList<Entity> entidades = new LinkedList<Entity>();
	private LinkedList<Entity> entidadesABorrar = new LinkedList<Entity>();

	private Entity entidad;
	private Entity entidadAux;
	private Player player;
	private int puntaje;
	private Fondo fondo;

	public Controller() {
		fondo = new Fondo();
		player = new Player(200, 420);
		puntaje = 0;

		addEntity(player);
		FabricaEnemys fabrica = new FabricaEnemys();
		fabrica.setEnemyBuilder(new KamikazeBuilder());
		fabrica.construirEnemigo(200, 100, this);
		Enemy enemigo = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo2 = fabrica.getEnemigo();
		fabrica.construirEnemigo(600, 10, this);
		Enemy enemigo3 = fabrica.getEnemigo();
		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(enemigo3);

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
		g.drawString("Puntaje: " + puntaje, 10, 470);
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

}