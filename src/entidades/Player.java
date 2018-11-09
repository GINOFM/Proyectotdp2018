package entidades;

import java.awt.Graphics;

import armas.ArmaJugador;
import armas.ArmaJugadorDisparoSimple;
import base.ColJugador;
import base.Colisionador;
import gamestates.NivelState;
import objetos.Escudo;
import objetos.PowerUp;

public class Player extends Entity {

	private int velocidadX;
	private Escudo miEscudo;
	private Colisionador col;
	private boolean isShooting = false;
	private int nivelNave;
	private ArmaJugador miArma;

	private boolean puedeDisparar;
	private int intervaloEntreDisparos;
	private long tiempoActivado;

	private boolean moverIzquierda, moverDerecha;

	public Player(int x, int y, NivelState nivelActual) {
		super(x, y);
		this.nivelActual = nivelActual;
		initCraft();
	}

	protected void initCraft() {
		nivelNave = 0;
		salud_maxima = 100;
		salud = 100;
		intervaloEntreDisparos = 3;
		puedeDisparar = true;
		loadImage("resources/player_spaceship_01.png");
		setImageActual(images.get(0));
		loadImage("resources/player_spaceship_02.png");
		loadImage("resources/player_spaceship_03.png");
		getImageDimensions();
		estaActivo = true;
		col = new ColJugador(this);
		velocidadX = 5;
		moverIzquierda = false;
		moverDerecha = false;
		miArma = new ArmaJugadorDisparoSimple(this);
	}

	public void update() {
		if (moverIzquierda)
			x -= velocidadX;
		else if (moverDerecha)
			x += velocidadX;

		long tiempoActual = System.currentTimeMillis();
		if (!puedeDisparar) {
			if ((tiempoActual - tiempoActivado) / 100 >= intervaloEntreDisparos) {
				puedeDisparar = true;
			}
		}

		if (x <= 0)
			x = 0;
		if (x >= 640 - 30)
			x = 640 - 30;
		
		if(salud==0)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void setVelX(int velX) {
		this.velocidadX = velX;
	}

	public void setMiEscudo(Escudo miEscudo) {
		this.miEscudo = miEscudo;
	}

	public void disparar() {
		if (puedeDisparar) {
			miArma.disparar(nivelActual);
			puedeDisparar = false;
			tiempoActivado = System.currentTimeMillis();
		}
	}

	public void serChocado(Colisionador col) {
		col.chocaJugador(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void golpear(Entity e) {
		e.quitaVida(1000);
	}

	public void quitaVida(int daño) {
		int saludRestante = salud - daño;
		if (saludRestante > 0)
			salud = saludRestante;
		else {
			salud = 0;
		}
	}

	public boolean getIsShooting() {
		return isShooting;
	}

	public void setIsShooting(boolean valor) {
		isShooting = valor;
	}

	public int obtenerPuntaje() {
		return 0;
	}

	public void setRight(boolean right) {
		this.moverDerecha = right;
	}

	public void setLeft(boolean left) {
		this.moverIzquierda = left;
	}

	public void mejorarNave() {
		nivelNave++;
		imagenActual = images.get(nivelNave);
		miArma.mejorarArma();
	}

	public void setNivelActual(NivelState nivelActual) {
		this.nivelActual = nivelActual;
	}

	public void setArmaJugador(ArmaJugador nuevaArma) {
		miArma = nuevaArma;
	}

	public void aceptarPowerUp(PowerUp powerup) {
		powerup.visitJugador(this);
	}

	public void setSalud(int salud) {
		if (salud > salud_maxima) {
			this.salud = salud_maxima;
		} else {
			this.salud = salud;
		}
	}

	public ArmaJugador getArma() {
		return miArma;
	}
	
	public Escudo getMiEscudo() {
		return miEscudo;
	}
}
