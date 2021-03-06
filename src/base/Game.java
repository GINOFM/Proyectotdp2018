package base;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import gamestates.GameStateManager;

public class Game extends Canvas implements Runnable {

	private static final int WIDTH = 320;
	private static final int HEIGHT = WIDTH / 12 * 9;
	private static final int SCALE = 2;
	private final String title = "Aerial";

	private boolean running = false;
	private Thread thread;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	private GameStateManager gameStateManager;

	public void init() {
		requestFocus();
		gameStateManager = new GameStateManager();
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
	}

	private synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Updates, Fps " + frames);
				updates = 0;
				frames = 0;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop();
	}

	private void update() {
		gameStateManager.update();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		gameStateManager.render(g);
		//
		g.dispose();
		bs.show();
	}

	public static int getScale() {
		return SCALE;
	}

	public static void main(String args[]) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.title);

		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);

		game.start();
	}

	public void keyPressed(KeyEvent e) {
		gameStateManager.getGameState().keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		gameStateManager.getGameState().keyReleased(e);
	}

	public void mouseClicked(MouseEvent e) {
		gameStateManager.getGameState().mouseClicked(e);
	}
}
