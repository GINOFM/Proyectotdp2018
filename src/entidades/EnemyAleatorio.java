package entidades;

import base.ColEnemigo;
import gamestates.NivelState;

public class EnemyAleatorio extends Enemy{

	public EnemyAleatorio(int x, int y, NivelState na) {
		super(x, y, na);
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 80;
		salud = 80;
		loadImage("resources/alien_04.png");
		col = new ColEnemigo(this);
		setImageActual(getImageAt(0));
		getImageDimensions();
	}
}
