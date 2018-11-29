package entidades;

import base.ColEnemigo;
import gamestates.NivelState;

public class EnemyHorizontalDirigido extends Enemy{
	
	public EnemyHorizontalDirigido(int x, int y, NivelState na) {
		super(x, y, na);
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 120;
		salud = 120;
		loadImage("resources/alien_armado_01.png");
		col = new ColEnemigo(this);
		setImageActual(getImageAt(0));
		getImageDimensions();
	}
}
