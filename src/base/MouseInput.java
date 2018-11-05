package base;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	
	private Game juego;

	public MouseInput(Game juego) {
		this.juego = juego;
	}
	
	public void mouseClicked(MouseEvent e) {
		juego.mouseClicked(e);
	}
}