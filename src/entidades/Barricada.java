package entidades;

import java.awt.Graphics;

import base.ColBarricada;
import base.Colisionador;
import objetos.PowerUp;

public class Barricada extends Obstaculo {

	public Barricada(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 100;
		salud = 100;
		loadImage("resources/barrera.png");
		setImageActual(images.get(0));
		loadImage("resources/barrera_02.png");
		loadImage("resources/barrera_03.png");
		getImageDimensions();
		col = new ColBarricada(this);
	}

	public void update() {

	}

	public void render(Graphics g) {
		int porcentajeSalud = ((salud * 10) / salud_maxima);
		if (porcentajeSalud > 5)
			imagenActual = images.get(0);
		else if (porcentajeSalud > 2 && porcentajeSalud <= 5)
			imagenActual = images.get(1);
		else if (porcentajeSalud >= 0 && porcentajeSalud <= 2)
			imagenActual = images.get(2);
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaBarricada(this);
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if (salud <= 0) {
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
