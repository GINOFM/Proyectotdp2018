package gamestates;

import builders.AleatorioBuilder;
import builders.HorizontalBuilder;
import builders.KamikazeAleatorioBuilder;
import builders.KamikazeAleatorioPerdibleBuilder;
import builders.KamikazeDirigidoBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Escombro;

public class Nivel1State extends NivelState {

	public Nivel1State(GameStateManager gsm) {
		super(gsm);
	}

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
		fabrica.setEnemyBuilder(new HorizontalBuilder());
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

	}

	public void pasarAlSiguienteNivel() {
		gameStateManager.switchState(new Nivel2State(gameStateManager, player, puntaje, fabrica, fondo, bs, be));

	}

}