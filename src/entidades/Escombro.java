package entidades;

import java.awt.Graphics;
import java.util.Random;

import base.ColEscombro;
import base.Colisionador;
import objetos.PowerUp;

public class Escombro extends Obstaculo {

	public Escombro(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		salud = 100;
		Random random = new Random();
		int chance = random.nextInt(100);
		if(chance >= 66)
			loadImage("resources/asteroide.png");
		else if(chance >= 33 && chance < 66)
			loadImage("resources/asteroide_02.png");
		else if(chance >= 0 && chance < 33)
			loadImage("resources/asteroide_03.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColEscombro(this);
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaEscombro(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if(salud <= 0) {
			destruir();
		}
	}

	public void golpear(Entity e) {
		e.quitaVida(10);
	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
	}
}