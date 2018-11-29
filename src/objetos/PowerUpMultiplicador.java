package objetos;

import base.ColPowerUp;
import entidades.Enemy;
import entidades.Player;

public class PowerUpMultiplicador extends PowerUp implements Runnable{

	protected Player jugador;
	
	public PowerUpMultiplicador(int x, int y) {
		super(x, y);
		initCraft();
	}

	public void visitJugador(Player jugador) {
		this.jugador = jugador;
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void visitEnemigo(Enemy enemigo) {
		// TODO Auto-generated method stub
		
	}

	protected void initCraft() {
		velocidadY = 1;
		loadImage("resources/powerup_multiplicador.png");
		setImageActual(images.get(0));
		getImageDimensions();
		col = new ColPowerUp(this);
	}

	@Override
	public void aceptarPowerUp(PowerUp powerup) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		jugador.getArma().potenciar();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jugador.getArma().despotenciar();
	}

}
