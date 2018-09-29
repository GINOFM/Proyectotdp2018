package entidades;

import java.awt.Graphics;

import base.ColDisparoJugador;
import base.ColEnemigo;
import base.Colisionador;
import base.Controller;
import inteligencias.Inteligenciadirigida;
import inteligencias.inteligencia;
import objetos.DisparoEnemigoSimple;

public class Enemy extends Entity{

	private int velocidad;
	private int direccion;
	private int salud;
	private long lastTime;
	private Controller controller;
	protected Colisionador col;
	// momentaneo para tests
	private int limiteXIzq;
	private int limiteXDer;

	private inteligencia intgc;
	
	public Enemy(int x, int y, Controller c) {
		super(x, y);
		velocidad = 3;
		direccion = -1;
		salud = 30;
		initCraft();
		controller = c;
	}
	

	protected void initCraft() {

		loadImage("resources/alien.png");
		getImageDimensions();
		limiteXIzq = x - 100;
		limiteXDer = x + 100;
		col = new ColEnemigo(this);
	}
	
	public void update() {

		intgc.mover(this,controller.getPlayer());
	
		
		/*
		x += direccion * velocidad;

		hacer inteligencia
		if(x < limiteXIzq) {
			cambiarDireccion();
		} else if (x > limiteXDer) {
			cambiarDireccion();
		}
		
		long now = System.currentTimeMillis();
		if ((now - lastTime) / 60 > 22) {
			lastTime = now;
			disparar();
		}*/

	}
	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void cambiarDireccion() {
		direccion = direccion * (-1);
	}

	public void avanzar() {
		y += 20;
	}

	public void disparar() {
		controller.addEntity(new DisparoEnemigoSimple(x, y+15));
	}


	public void chocar(Entity e) {
		e.serChocado(col);
	}

	@Override
	public void serChocado(Colisionador col) {
		col.chocaEnemigo(this);
	}

	@Override
	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if (salud <= 0) {
			destruir();
		}
	}

	@Override
	public void golpear(Entity e) {
		e.quitaVida(1);
	}


	public inteligencia getIntgc() {
		return intgc;
	}


	public void setIntgc(inteligencia intgc) {
		this.intgc = intgc;
	}


	@Override
	public int obtenerPuntaje() {
		return 10;
	}

}
