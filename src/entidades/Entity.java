package entidades;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import base.Colisionador;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean estaActivo;

	protected Image image;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		estaActivo = true;
	}

	protected abstract void initCraft();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public abstract void serChocado(Colisionador col);
	
	public abstract void chocar(Entity e);
	
	public abstract void quitaVida(int dmg);
	
	public abstract void golpear(Entity e);

	protected void getImageDimensions() {

		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	protected void loadImage(String imageName) {

		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int newx) {
		x=newx;
	}

	public void setY(int newy) {
		y=newy;
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

}
