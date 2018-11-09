package entidades;

import java.awt.Graphics;
import java.util.Random;

import base.ColEnemigo;
import base.Colisionador;
import gamestates.NivelState;
import objetos.PowerUp;
import objetos.PowerUpArma;
import objetos.PowerUpCongelar;
import objetos.PowerUpEscudo;
import objetos.PowerUpMultiplicador;
import objetos.PowerUpPocion;

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

	public void destruir() {
		estaActivo = false;
		if (dropea()) {
			generarDrop();
		}
	}

	private boolean dropea() {
		Random random = new Random();
		int chance = random.nextInt(10) + 1;
		if (chance <= 3)
			return true;
		else
			return false;
	}

	private void generarDrop() {
		Random random = new Random();
		int chance = random.nextInt(10) + 1;
		PowerUp powerUpADropear = null;
		if (chance <= 2)
			powerUpADropear = new PowerUpArma(x, y);
		else if (chance > 2 && chance <= 4)
			powerUpADropear = new PowerUpMultiplicador(x, y);
		else if (chance > 4 && chance <= 7)
			powerUpADropear = new PowerUpPocion(x, y);
		else if (chance == 8)
			powerUpADropear = new PowerUpEscudo(x, y);
		else if (chance > 8 && chance <= 10)
			powerUpADropear = new PowerUpCongelar(x, y);
		nivelActual.addEntity(powerUpADropear);
	}
}
