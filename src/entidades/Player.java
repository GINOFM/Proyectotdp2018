package entidades;

import java.awt.Graphics;
import base.ColJugador;
import base.Colisionador;
import base.Controller;
import objetos.DisparoJSimple;

public class Player extends Entity{

	private int velocidadX = 0;
	private Escudo miEscudo;
	private int nivelDisparo;
	private int salud;
	private boolean activo;
	private Colisionador col;
	private boolean isShooting=false;
	
	public Player(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {

		loadImage("resources/player_spaceship.png");
		getImageDimensions();
		nivelDisparo = 1;
		salud = 20;
		activo = true;
		col = new ColJugador(this);
	}

	public void update() {
		x += velocidadX;

		if (x <= 0)
			x = 0;
		if (x >= 640 - 20)
			x = 640 - 20;
	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void setVelX(int velX) {
		this.velocidadX = velX;
	}

	public void setMiEscudo(Escudo miEscudo) {
		this.miEscudo = miEscudo;
	}
	
	public void disparar(Controller c) {
		c.addEntity(new DisparoJSimple(x + 16, y - 12));
		if(nivelDisparo > 1) {
			c.addEntity(new DisparoJSimple(x, y - 4));
			c.addEntity(new DisparoJSimple(x + 32, y - 4));
		}
	}
	
	public void dañar(int daño) {
		salud = salud - daño;
		if(salud <= 0) {
			destruir();
		}
	}
	
	public void destruir() {
		activo = false;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void serChocado(Colisionador col) {
		col.chocaJugador(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void golpear(Entity e) {
		e.quitaVida(30);
	}

	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if (salud <= 0) {
			destruir();
		}
	}


	public boolean getIsShooting() {
		return isShooting;
	}

	public void setIsShooting(boolean valor) {
		isShooting = valor;
	}

	@Override
	public int obtenerPuntaje() {
		return 0;
	}
}
