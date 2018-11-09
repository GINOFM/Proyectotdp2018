package objetos;

import java.awt.Graphics;
import base.Colisionador;
import base.ColEscudo;
import entidades.Entity;
import gamestates.NivelState;

public class Escudo extends Entity {

	private Colisionador ColEscudo;
	private NivelState nivelActual;

	public Escudo(int x, int y, NivelState na) {
		super(x, y);
		nivelActual = na;
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 30;
		salud = 30;
		loadImage("resources/escudo_inmunidadChoque2.png");
		setImageActual(images.get(0));
		getImageDimensions();
		ColEscudo = new ColEscudo(this);
	}

	public void update() {
		setX(nivelActual.getPlayer().getX() - 25);
		if (salud == 0)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	@Override
	public void serChocado(Colisionador col) {
		col.chocaEscudo(this);

	}

	@Override
	public void chocar(Entity e) {
		e.serChocado(ColEscudo);

	}

	@Override
	public void quitaVida(int dmg) {
		int saludRestante = salud - dmg;
		if (saludRestante > 0)
			salud = saludRestante;
		else {
			salud = 0;
		}

	}

	@Override
	public void golpear(Entity e) {
		e.quitaVida(1000);

	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub

	}

	@Override
	public int obtenerPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

}
