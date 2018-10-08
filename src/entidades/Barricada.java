package entidades;

import java.awt.Graphics;

import base.ColBarricada;
import base.Colisionador;

public class Barricada extends Obstaculo {

	public Barricada(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		salud = 50;
		loadImage("resources/barrera.png");
		getImageDimensions();
		col = new ColBarricada(this);
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaObstaculo(this);
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

}
