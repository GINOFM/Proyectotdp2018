package entidades;

import java.awt.Graphics;
import base.ColEscombro;
import base.Colisionador;

public class Escombro extends Obstaculo {

	public Escombro(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		salud = 100;
		loadImage("resources/asteroide.png");
		getImageDimensions();
		col = new ColEscombro(this);
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaEscombro(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	@Override
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
