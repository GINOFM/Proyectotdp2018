package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import UI.BarraEscudo;
import UI.BarraSalud;
import base.Fondo;
import builders.FabricaEnemys;
import entidades.Entity;
import entidades.Player;

public abstract class NivelState extends GameState {

	private LinkedList<Entity> entidades = new LinkedList<Entity>();
	private LinkedList<Entity> entidadesABorrar = new LinkedList<Entity>();

	private Entity entidad;
	private Entity entidadAux;

	protected Player player;
	protected int puntaje;
	protected Fondo fondo; 
	protected int cantidadEnemigos;
	protected FabricaEnemys fabrica;
	protected BarraSalud bs;
	protected BarraEscudo be;

	public NivelState(GameStateManager gsm) {
		gameStateManager = gsm;
		fondo = new Fondo();
		player = new Player(310, 410, this);
		bs = new BarraSalud(player);
		be = new BarraEscudo();

		puntaje = 0;
		fabrica = new FabricaEnemys();
		gameStateManager = gsm;
		addEntity(player);
	}

	public NivelState(GameStateManager gsm, Player player, int puntaje, FabricaEnemys fabrica, Fondo fondo,
			BarraSalud bs, BarraEscudo be) {

		this.player = player;
		player.setNivelActual(this);
		this.puntaje = puntaje;
		this.fabrica = fabrica;
		this.fondo = fondo;
		this.bs = bs;
		this.be = be;
		this.gameStateManager = gsm;
	}

	public void update() {
		fondo.update();
		bs.update();
		be.update();
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
						if (entidadAux.estaActivo())
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
			sumarPuntaje(entidad.obtenerPuntaje());
			entidades.remove(entidad);
		}

		entidadesABorrar.clear();
		if (cantidadEnemigos == 0)
			pasarAlSiguienteNivel();
		if (!player.estaActivo()) {
			gameStateManager.switchState(new DerrotaState(gameStateManager, puntaje));
		}

	}

	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt0);
		g.setColor(Color.white);
		fondo.render(g);
		bs.render(g);
		be.render(g);
		for (int i = 0; i < entidades.size(); i++) {
			entidad = entidades.get(i);
			entidad.render(g);
		}
		g.drawString("Puntaje: " + puntaje, 10, 460);

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		} else if (key == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		} else if (key == KeyEvent.VK_SPACE && !player.getIsShooting()) {
			player.setIsShooting(true);
			player.disparar();
		} else if (key == KeyEvent.VK_E) {
			player.quitaVida(10);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		} else if (key == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		} else if (key == KeyEvent.VK_SPACE) {
			player.setIsShooting(false);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public abstract void pasarAlSiguienteNivel();

	public void addEntity(Entity entity) {
		entidades.add(entity);
	}

	public Player getPlayer() {
		return player;
	}

	public FabricaEnemys getFabrica() {
		return fabrica;
	}

	public void sumarPuntaje(int puntos) {
		puntaje = puntaje + puntos;
	}

	public void descontarUnEnemigo() {
		cantidadEnemigos--;
	}

	public void limpiarListaEntidades() {
		entidades.clear();
	}

	public LinkedList<Entity> getEntities() {
		return entidades;
	}

	public BarraEscudo getBarraEscudo() {
		return be;
	}
}
