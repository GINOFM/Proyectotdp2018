package gamestates;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import entidades.Player;

public class DerrotaState extends GameState {

	protected Image fondo;
	protected Image boton_reiniciar;
	protected Image boton_salir;

	public DerrotaState(GameStateManager gsm) {
		gameStateManager = gsm;
	}

	public void init() {
		ImageIcon ii = new ImageIcon("resources/menu_derrota.png");
		fondo = ii.getImage();
		ii = new ImageIcon("resources/boton_reiniciar.png");
		boton_reiniciar = ii.getImage();
		ii = new ImageIcon("resources/boton_salir.png");
		boton_salir = ii.getImage();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void render(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.drawImage(boton_reiniciar, 200, 210, null);
		g.drawImage(boton_salir, 240, 310, null);
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getX() > 200 && e.getX() < 457 && e.getY() > 210 && e.getY() < 264) {
				gameStateManager.switchState(new MenuState(gameStateManager));
			} else if (e.getX() > 240 && e.getX() < 402 && e.getY() > 310 && e.getY() < 364) {
				System.exit(1);
			}
		}
	}
}