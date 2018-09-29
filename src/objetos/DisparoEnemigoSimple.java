package objetos;

import java.awt.Graphics;

import base.ColDisparoEnemigo;
import base.Colisionador;
import entidades.Entity;

public class DisparoEnemigoSimple extends DisparoEnemigo {

	public DisparoEnemigoSimple(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 5;
		da�o = 5;
		loadImage("resources/disparo_alien.png");
		getImageDimensions();
		col = new ColDisparoEnemigo(this);
	}

	public void update() {
		y += velocidadY;
	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaDisparoEnemigo(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		destruir();
	}

	public void golpear(Entity e) {
		e.quitaVida(5);
	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

}
