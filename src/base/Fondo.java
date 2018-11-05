package base;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Fondo {

	protected int xPosFondo1;
	protected int xPosFondo2;
	protected int yPosFondo1;
	protected int yPosFondo2;
	protected Image fondo1;
	protected Image fondo2;

	public Fondo() {
		ImageIcon ii = new ImageIcon("resources/background.png");
		fondo1 = ii.getImage();
		fondo2 = ii.getImage();
		xPosFondo1 = 0;
		yPosFondo1 = 0;
		xPosFondo2 = 0;
		yPosFondo2 = -480;
	}

	public void update() {
		yPosFondo1++;
		yPosFondo2++;

		if (yPosFondo1 >= 480)
			yPosFondo1 = -480;
		if (yPosFondo2 >= 480)
			yPosFondo2 = -480;
	}

	public void render(Graphics g) {
		g.drawImage(fondo1, (int) xPosFondo1, (int) yPosFondo1, null);
		g.drawImage(fondo2, (int) xPosFondo2, (int) yPosFondo2, null);

	}
}
