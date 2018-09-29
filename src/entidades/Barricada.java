package entidades;

import java.awt.Graphics;

import base.Colisionador;

public class Barricada extends Obstaculo {

	public Barricada(int x, int y) {
		super(x, y);
		initCraft();
	}

	protected void initCraft() {
		salud = 20;
		loadImage("resources/obstaculo.png");
		getImageDimensions();
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		
	}

	@Override
	public void chocar(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitaVida(int dmg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpear(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

}
