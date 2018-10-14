package gamestates;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import entidades.Player;

public class MenuState extends GameState {

	protected Image fondo;
	protected Image boton_jugar;
	protected Image boton_salir;

	public MenuState(GameStateManager gsm) {
		gameStateManager = gsm;
	}

	public void init() {
		ImageIcon ii = new ImageIcon("resources/menu_principal.png");
		fondo = ii.getImage();
		ii = new ImageIcon("resources/boton_jugar.png");
		boton_jugar = ii.getImage();
		ii = new ImageIcon("resources/boton_salir.png");
		boton_salir = ii.getImage();
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.drawImage(boton_jugar, 240, 210, null);
		g.drawImage(boton_salir, 240, 310, null);
		
	}

	public Player getPlayer() {
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
			if (e.getX() > 240 && e.getX() < 402 && e.getY() > 210 && e.getY() < 264) {
				gameStateManager.switchState(new Nivel1State(gameStateManager));
			} else if (e.getX() > 240 && e.getX() < 402 && e.getY() > 310 && e.getY() < 364) {
				System.exit(1);
			}

		}
	}

}
