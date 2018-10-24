package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import base.Colisionador;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean estaActivo;

	protected Image imagenActual;
	protected LinkedList<Image> images;

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

	public abstract int obtenerPuntaje();

	public boolean outOfBounds() {
		if (x < 0 || y < 0 || y > 480 || y > 640)
			return true;
		else
			return false;
	}
	
	public abstract void afectarPorPowerUp();

}
