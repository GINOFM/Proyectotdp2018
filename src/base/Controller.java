package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import builders.AleatorioBuilder;
import builders.FabricaEnemys;
import builders.KamikazeBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Player;

public class Controller {

	private LinkedList<Entity> entidades = new LinkedList<Entity>();
	private LinkedList<Entity> entidadesABorrar = new LinkedList<Entity>();

	// para que avancen
	//private int revotes;

	private Entity entidad;
	private Entity entidadAux;
	private Player player;
	private int puntaje;
	public Controller() {
		player=new Player(200,420);
		puntaje=0;
		/*
		Enemy enemigo = new Enemy(200, 10, this);
		Enemy enemigo2 = new Enemy(400, 10, this);
		inteligencia int1=new Inteligenciaaleatoria();
		enemigo.setIntgc(int1);
		inteligencia int2=new Inteligenciadirigida();
		enemigo2.setIntgc(int2);
		//revotes = 3;
		
		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(new Barricada(150, 300));
		addEntity(new Barricada(400, 300));
		*/
		addEntity(player);
		FabricaEnemys fabrica = new FabricaEnemys();
		fabrica.setEnemyBuilder(new KamikazeBuilder());
		fabrica.construirEnemigo(200, 100, this);
		Enemy enemigo = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo2=fabrica.getEnemigo();
		fabrica.construirEnemigo(600, 10, this);
		Enemy enemigo3=fabrica.getEnemigo();
		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(enemigo3);
	}

	public void update() {
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
			puntaje=puntaje+entidad.obtenerPuntaje();
			entidades.remove(entidad);
		}
		
		entidadesABorrar.clear();
		
//		for (int i = 0; i < disparosJugador.size(); i++) {
//			disparoJ = disparosJugador.get(i);
//			for (int j = 0; j < enemigos.size(); j++) {
//				enemigo = enemigos.get(j);
//				if (disparoJ.getBounds().intersects(enemigo.getBounds())) {
//					enemigo.dañar(disparoJ.getDaño());
//					disparosJugadorNoActivo.add(disparoJ);
//					if (!enemigo.getActivo()) {
//						enemigosNoActivos.add(enemigo);
//					}
//				}
//			}
//		}
//
//		if (!enemigos.isEmpty()) {
//			if (masIzquierdo().getX() < 5) {
//				for (int i = 0; i < enemigos.size(); i++) {
//					enemigos.get(i).cambiarDireccion();
//				}
//				revotes--;
//			}
//			if (masDerecho().getX() > 620) {
//				for (int i = 0; i < enemigos.size(); i++) {
//					enemigos.get(i).cambiarDireccion();
//				}
//				revotes--;
//			}
//			if (revotes == 0) {
//				for (int i = 0; i < enemigos.size(); i++) {
//					enemigos.get(i).avanzar();
//				}
//				revotes = 3;
//			}
//		}
	}

//	private Enemy masIzquierdo() {
//		Enemy masIzquierdo = null;
//		if (!enemigos.isEmpty()) {
//			masIzquierdo = enemigos.get(0);
//		}
//		for (int i = 0; i < enemigos.size(); i++) {
//			Enemy enemigoActual = enemigos.get(i);
//			if (enemigoActual.getX() < masIzquierdo.getX()) {
//				masIzquierdo = enemigoActual;
//			}
//		}
//		return masIzquierdo;
//	}
//
//	private Enemy masDerecho() {
//		Enemy masDerecho = null;
//		if (!enemigos.isEmpty()) {
//			masDerecho = enemigos.get(0);
//		}
//		for (int i = 0; i < enemigos.size(); i++) {
//			Enemy enemigoActual = enemigos.get(i);
//			if (enemigoActual.getX() > masDerecho.getX()) {
//				masDerecho = enemigoActual;
//			}
//		}
//		return masDerecho;
//	}

	public void render(Graphics g) {
		Font fnt0 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Puntaje: "+puntaje, 10, 470);
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