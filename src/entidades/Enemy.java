package entidades;

import java.awt.Graphics;

import base.ColDisparoJugador;
import base.ColEnemigo;
import base.Colisionador;
import gamestates.NivelState;
import inteligencias.Inteligencia;
import inteligencias.InteligenciaAleatoria;
import objetos.DisparoEnemigoSimple;

public class Enemy extends Entity {

	private int direccion;
	private int salud;
	private long lastTime;
	private NivelState nivel;
	protected Colisionador col;

	private Inteligencia intgc;

	public Enemy(int x, int y, NivelState nivel) {
		super(x, y);
		direccion = -1;
		salud = 30;
		initCraft();
		this.nivel = nivel;
	}

	protected void initCraft() {

		loadImage("resources/alien.png");
		getImageDimensions();
		col = new ColEnemigo(this);
	}

	public void update() {

		if (outOfBounds()) {
			y = 0;
			intgc = new InteligenciaAleatoria();
		}
		intgc.mover(this);

		long now = System.currentTimeMillis();
		if ((now - lastTime) / 60 > 22) {
			lastTime = now;
			disparar();
		}

	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void cambiarDireccion() {
		direccion = direccion * (-1);
	}

	public void disparar() {
		nivel.addEntity(new DisparoEnemigoSimple(x, y + 15));
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
			nivel.descontarUnEnemigo();
			destruir();
		}
	}

	@Override
	public void golpear(Entity e) {
		e.quitaVida(1);
	}

	public void setIntgc(Inteligencia intgc) {
		this.intgc = intgc;
	}

	@Override
	public int obtenerPuntaje() {
		return 10;
	}

	

}
