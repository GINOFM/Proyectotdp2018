package objetos;

import java.awt.Graphics;
import base.ColEscudo;
import base.Colisionador;
import entidades.Entity;
import gamestates.NivelState;

public class EscudoAntiKamikaze extends Escudo{

	public EscudoAntiKamikaze(int x, int y, NivelState na) {
		super(x, y, na);
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 30;
		salud = 30;
		loadImage("resources/escudo_inmunidadChoque2.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColEscudo(this);
	}

	public void update() {
		setX(nivelActual.getPlayer().getX() - 25);
		if (salud == 0)
			destruir();
	}

	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void serChocado(Colisionador col) {
		col.chocaEscudo(this);

	}

	public void chocar(Entity e) {
		e.serChocado(col);

	}

	public void quitaVida(int dmg) {
		int saludRestante = salud - dmg;
		if (saludRestante > 0)
			salud = saludRestante;
		else {
			salud = 0;
		}

	}

	public void golpear(Entity e) {
		e.quitaVida(1000);
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub

	}

	public int obtenerPuntaje() {
		return 0;
	}
}
