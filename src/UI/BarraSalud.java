package UI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import entidades.Player;

public class BarraSalud {

	private Image barraSalud;
	private Image saludIcon;
	private Image saludIcon_01;
	private Image saludIcon_02;
	private Image aMostrar;
	private int cantidad;
	private Player jugador;

	public BarraSalud(Player jugador) {
		this.jugador = jugador;
		initCraft();
	}

	private void initCraft() {
		ImageIcon ii = new ImageIcon("resources/barraSalud.png");
		barraSalud = ii.getImage();
		ii = new ImageIcon("resources/saludIcon.png");
		saludIcon = ii.getImage();
		ii = new ImageIcon("resources/saludIcon_01.png");
		saludIcon_01 = ii.getImage();
		ii = new ImageIcon("resources/saludIcon_02.png");
		saludIcon_02 = ii.getImage();
		cantidad = 10;
	}

	public void update() {
		cantidad = (jugador.getSalud() * 10 / jugador.getSaludMaxima());
	}

	public void render(Graphics g) {
		g.drawImage(barraSalud, 500, 436, null);
		aMostrar = saludIcon;
		if (cantidad <= 5 && cantidad >= 3) {
			aMostrar = saludIcon_01;
		} else if (cantidad <= 2)
			aMostrar = saludIcon_02;
		for (int i = 0; i < cantidad; i++)
			g.drawImage(aMostrar, 504 + (i * 12), 440, null);
	}
}
