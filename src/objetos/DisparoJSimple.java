package objetos;

import java.awt.Graphics;

import base.ColDisparoJugador;
import base.Colisionador;
import entidades.Entity;

public class DisparoJSimple extends DisparoJugador {

	public DisparoJSimple(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		velocidadY = 5;
		daño = 10;
		loadImage("resources/missile.png");
		getImageDimensions();
		col = new ColDisparoJugador(this);
	}

	public void update() {
		y -= velocidadY;
		if (y <= 0)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	@Override
	public void serChocado(Colisionador col) {
		col.chocaDisparoJugador(this);
	}

	@Override
	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		destruir();
	}

	@Override
	public void golpear(Entity e) {
		System.out.println("hiy");
		e.quitaVida(10);
	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}
}
