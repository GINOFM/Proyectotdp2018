package entidades;

import java.awt.Graphics;
import base.ColJugador;
import base.Colisionador;
import gamestates.NivelState;
import objetos.ArmaJugador;
import objetos.ArmaJugadorDisparoSimple;
import objetos.DisparoJSimple;
import objetos.Escudo;
import objetos.PowerUp;

public class Player extends Entity {

	private int velocidadX;
	private Escudo miEscudo;
	private int salud;
	private int salud_maxima;
	private boolean activo;
	private Colisionador col;
	private boolean isShooting = false;
	private int nivelNave;
	private ArmaJugador miArma;

	private boolean moverIzquierda, moverDerecha;
	private NivelState nivelActual;

	public Player(int x, int y, NivelState nivelActual) {
		super(x, y);
		this.nivelActual = nivelActual;
		initCraft();
	}

	protected void initCraft() {
		nivelNave = 0;
		salud_maxima = 100;
		salud = 100;
		loadImage("resources/player_spaceship_01.png");
		setImageActual(images.get(0));
		loadImage("resources/player_spaceship_02.png");
		loadImage("resources/player_spaceship_03.png");
		getImageDimensions();
		activo = true;
		col = new ColJugador(this);
		velocidadX = 5;
		moverIzquierda = false;
		moverDerecha = false;
		miArma = new ArmaJugadorDisparoSimple(x, y, this);
	}

	public void update() {

		if (moverIzquierda)
			x -= velocidadX;
		else if (moverDerecha)
			x += velocidadX;

		if (x <= 0)
			x = 0;
		if (x >= 640 - 30)
			x = 640 - 30;
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
		miArma.disparar(nivelActual);
	}

	public void dañar(int daño) {
		salud = salud - daño;
		if (salud <= 0) {
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

	public void afectarPorPowerUp() {
		mejorarNave();
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

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		if (salud > salud_maxima) {
			this.salud = salud_maxima;
		} else {
			this.salud = salud;
		}
	}
	
	public NivelState getNivel() {
		return nivelActual;
	}
	
	public ArmaJugador getArma() {
		return miArma;
	}
}
