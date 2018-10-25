package entidades;

import java.awt.Graphics;
import base.ColDisparoJugador;
import base.ColEnemigo;
import base.Colisionador;
import gamestates.NivelState;
import inteligencias.Inteligencia;
import inteligencias.InteligenciaAleatoria;
import objetos.DisparoEnemigoSimple;
import objetos.PowerUp;

public class Enemy extends Entity {

	private int direccion;
	private int salud;
	private long lastTime;
	private long lastTimeCongelar;
	private NivelState nivelActual;
	protected Colisionador col;

	private Inteligencia intgc;
	private Inteligencia intgcGuardada;

	protected boolean congelado;
	protected int tiempoCongelado;

	private Inteligencia inteligenciados;
	private int porcentaje=0;
	
	public Enemy(int x, int y, NivelState nivelActual) {
		super(x, y);
		direccion = -1;
		salud = 50;
		this.nivelActual = nivelActual;
		initCraft();
	}

	protected void initCraft() {
		loadImage("resources/alien.png");
		loadImage("resources/alien_02.png");
		loadImage("resources/alien_03.png");
		loadImage("resources/alien_04.png");
		usarImagen(0);
		getImageDimensions();
		col = new ColEnemigo(this);
		congelado = false;
		tiempoCongelado = 200;
	}

	public void update() {
		chequear();
		if (!congelado) {
			if (outOfBounds()) {
				y = 0;
			}
			intgc.mover(this);

			long now = System.currentTimeMillis();
			if ((now - lastTime) / 60 > 22) {
				lastTime = now;
				if(intgc.dispara())
					disparar();
			}
		} else {
			tiempoCongelado--;
			if(tiempoCongelado <= 0) {
				congelado = false;
			}
		}

	}

	public void usarImagen(int num)
	{
		
		setImageActual(images.get(num));
	}
	
	private void chequear()
	{
		if(porcentaje!=0 && porcentaje!=-1)
		{
			if(salud<=porcentaje)
			{
				setIntgc(getInteligenciados());
				porcentaje=-1;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(getImageActual(), (int) x, (int) y, null);
	}

	public void cambiarDireccion() {
		direccion = direccion * (-1);
	}

	public void disparar() {
		nivelActual.addEntity(new DisparoEnemigoSimple(x, y + 15));
	}

	public void chocar(Entity e) {
		e.serChocado(col);
	}

	@Override
	public void serChocado(Colisionador col) {
		col.chocaEnemigo(this);
	}

	@Override
	public void quitaVida(int dmg) {
		salud = salud - dmg;
		if (salud <= 0) {
			nivelActual.descontarUnEnemigo();
			destruir();
		}
	}

	@Override
	public void golpear(Entity e) {
		e.quitaVida(1);
	}

	public void setIntgc(Inteligencia intgc) {
		this.intgc = intgc;
	}

	@Override
	public int obtenerPuntaje() {
		return 10;
	}

	@Override
	public void afectarPorPowerUp() {
		// TODO Auto-generated method stub

	}

	public void aceptarPowerUp(PowerUp powerup) {
		powerup.visitEnemigo(this);
	}

	public void congelar() {
		congelado = true;
	}

	public void setInteligenciados(Inteligencia inteligencia1) {
		inteligenciados=inteligencia1;
		
	}

	public void setPorcentaje(int i) {
		porcentaje=i;
		
	}
	
	public Inteligencia getInteligenciados()
	{
		return inteligenciados;
	}
}
