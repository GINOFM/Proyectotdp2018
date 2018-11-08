package entidades;

import java.awt.Graphics;
import base.ColEnemigo;
import base.Colisionador;
import gamestates.NivelState;
import objetos.PowerUp;

public class Enemy extends Entity {

	private int direccion;
	protected Colisionador col;

	public Enemy(int x, int y, NivelState nivelActual) {
		super(x, y);
		direccion = -1;
		salud_maxima = 100;
		salud = 100;
		this.nivelActual = nivelActual;
		initCraft();
	}

	protected void initCraft() {
		loadImage("resources/alien.png");
		setImageActual(images.get(0));
		loadImage("resources/alien_02.png");
		loadImage("resources/alien_03.png");
		loadImage("resources/alien_04.png");
		loadImage("resources/alien_armado_01.png");
		getImageDimensions();
		col = new ColEnemigo(this);
	}

	public void update() {
		if (outOfBounds()) {
			y = 0;
		}
		inteligenciaMovimiento.mover(this);
		inteligenciaDisparo.disparar(this);
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void cambiarDireccion() {
		direccion = direccion * (-1);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void serChocado(Colisionador col) {
		col.chocaEnemigo(this);
	}

	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if (salud <= 0) {
			nivelActual.descontarUnEnemigo();
			destruir();
		}
	}

	public void golpear(Entity e) {
		e.quitaVida(30);
	}

	public int obtenerPuntaje() {
		return 10;
	}

	public void aceptarPowerUp(PowerUp powerup) {
		powerup.visitEnemigo(this);
	}
}
