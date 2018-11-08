package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import base.Colisionador;
import gamestates.NivelState;
import inteligencias.InteligenciaDisparo;
import inteligencias.InteligenciaMovimiento;
import objetos.PowerUp;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean estaActivo;
	protected int salud;
	protected int salud_maxima;

	protected Image imagenActual;
	protected LinkedList<Image> images;
	protected InteligenciaMovimiento inteligenciaMovimiento;
	protected InteligenciaDisparo inteligenciaDisparo;
	
	protected int velocidadY;
	protected NivelState nivelActual;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		estaActivo = true;
		images = new LinkedList<Image>();
	}

	protected abstract void initCraft();

	public abstract void update();

	public abstract void render(Graphics g);

	public abstract void serChocado(Colisionador col);

	public abstract void chocar(Entity e);

	public abstract void quitaVida(int dmg);

	public abstract void golpear(Entity e);

	public abstract void aceptarPowerUp(PowerUp powerup);
	
	public abstract int obtenerPuntaje();
	
	protected void getImageDimensions() {

		width = imagenActual.getWidth(null);
		height = imagenActual.getHeight(null);
	}

	protected void loadImage(String imageName) {

		ImageIcon ii = new ImageIcon(imageName);
		images.add(ii.getImage());
	}

	public Image getImageActual() {
		return imagenActual;
	}

	public Image getImageAt(int indiceImagen) {
		return images.get(indiceImagen);
	}

	public void setImageActual(Image imagenActual) {
		this.imagenActual = imagenActual;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int newx) {
		x = newx;
	}

	public void setY(int newy) {
		y = newy;
	}

	public void destruir() {
		estaActivo = false;
	}

	public boolean estaActivo() {
		return estaActivo;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public boolean outOfBounds() {
		if (x < 0 || y < 0 || y > 480 || y > 640)
			return true;
		else
			return false;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int valor) {
		velocidadY = valor;
	}

	public void setInteligenciaMovimiento(InteligenciaMovimiento inteligencia) {
		this.inteligenciaMovimiento = inteligencia;
	}

	public InteligenciaMovimiento getInteligencia() {
		return inteligenciaMovimiento;
	}

	public int getSalud() {
		return salud;
	}

	public int getSaludMaxima() {
		return salud_maxima;
	}

	public NivelState getNivel() {
		return nivelActual;
	}

	public InteligenciaDisparo getInteligenciaDisparo() {
		return inteligenciaDisparo;
	}

	public void setInteligenciaDisparo(InteligenciaDisparo inteligenciaDisparo) {
		this.inteligenciaDisparo = inteligenciaDisparo;
	}
}
