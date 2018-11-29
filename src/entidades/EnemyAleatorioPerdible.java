package entidades;

import base.ColEnemigo;
import gamestates.NivelState;

public class EnemyAleatorioPerdible extends Enemy{
	
	public EnemyAleatorioPerdible(int x, int y, NivelState na) {
		super(x, y, na);
		initCraft();
	}

	protected void initCraft() {
		salud_maxima = 80;
		salud = 80;
		loadImage("resources/alien.png");
		setImageActual(images.get(0));
		loadImage("resources/alien_02.png");
		loadImage("resources/alien_03.png");
		loadImage("resources/alien_04.png");
		loadImage("resources/alien_armado_01.png");
		getImageDimensions();
		col = new ColEnemigo(this);
	}
}
