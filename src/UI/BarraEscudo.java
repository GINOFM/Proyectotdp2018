package UI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import entidades.Player;
import objetos.Escudo;

public class BarraEscudo {

	private Image barraEscudo;
	private Image escudoIcon;
	private Image aMostrar;
	private int cantidad;
	private Escudo escudo;

	public BarraEscudo(Escudo escudo) {
		this.escudo = escudo;
		initCraft();
	}

	private void initCraft() {
		ImageIcon ii = new ImageIcon("resources/barraEscudo.png");
		barraEscudo = ii.getImage();
		ii = new ImageIcon("resources/escudoIcon.png");
		escudoIcon = ii.getImage();
		cantidad = 10;
	}

	public void update() {
		if (escudo.getSalud() < 10 && escudo.getSalud() > 0)
			cantidad = 1;
		else
			cantidad = (escudo.getSalud() * 10 / escudo.getSaludMaxima());

	}

	public void render(Graphics g) {
		g.drawImage(barraEscudo, 500, 416, null);
		aMostrar = escudoIcon;
		for (int i = 0; i < cantidad; i++)
			g.drawImage(aMostrar, 504 + (i * 12), 420, null);
	}
	
	public void setEscudo(Escudo escudo)
	{
		this.escudo=escudo;
	}
}
