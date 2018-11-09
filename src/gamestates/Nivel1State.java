package gamestates;

import builders.AleatorioBuilder;
import builders.KamikazeAleatorioBuilder;
import builders.KamikazeAleatorioPerdibleBuilder;
import builders.KamikazeDirigidoBuilder;
import builders.KamikazeDirigidoTemportalBuilder;
import builders.TestBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Escombro;
import entidades.Player;
import inteligencias_disparo.InteligenciaDisparoSimple;
import objetos.PowerUpArma;
import objetos.PowerUpCongelar;
import objetos.PowerUpMultiplicador;
import objetos.PowerUpPocion;

public class Nivel1State extends NivelState {

	public Nivel1State(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		cantidadEnemigos = 8;
		fabrica.setEnemyBuilder(new KamikazeAleatorioBuilder());
		fabrica.construirEnemigo(200, 100, this);
		Enemy enemigo = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo2 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new KamikazeDirigidoBuilder());
		fabrica.construirEnemigo(600, 10, this);
		Enemy enemigo3 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new KamikazeAleatorioPerdibleBuilder());
		fabrica.construirEnemigo(450, 50, this);
		Enemy enemigo4 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(300, 80, this);
		Enemy enemigo5 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(220, 150, this);
		Enemy enemigo6 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(300, 240, this);
		Enemy enemigo7 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new TestBuilder());
		fabrica.construirEnemigo(170, 20, this);
		Enemy enemigo8 = fabrica.getEnemigo();

		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(enemigo3);
		addEntity(enemigo4);
		addEntity(enemigo5);
		addEntity(enemigo6);
		addEntity(enemigo7);
		addEntity(enemigo8);

		//
		Entity barrera1 = new Barricada(100, 320);
		Entity barrera2 = new Barricada(500, 320);
		Entity escombro1 = new Escombro(250, 300);
		Entity escombro2 = new Escombro(400, 320);
		Entity escombro3 = new Escombro(310, 270);
		addEntity(barrera1);
		addEntity(barrera2);
		addEntity(escombro1);
		addEntity(escombro2);
		addEntity(escombro3);

//		Entity powerUp = new PowerUpArma(100, 300);
//		addEntity(powerUp);
//		Entity powerUp2 = new PowerUpArma(100, 100);
//		addEntity(powerUp2);
//		Entity powerUp3 = new PowerUpPocion(300, 20);
//		addEntity(powerUp3);
//		Entity powerUp4 = new PowerUpCongelar(200, 50);
//		addEntity(powerUp4);
//		Entity powerUp5 = new PowerUpMultiplicador(250, 300);
//		addEntity(powerUp5);
		
	}

	public void pasarAlSiguienteNivel() {
		gameStateManager.switchState(new Nivel2State(gameStateManager, player, puntaje, fabrica, fondo, bs,be));
	}

	public Player getPlayer() {
		return player;
	}
}