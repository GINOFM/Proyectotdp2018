package gamestates;

import builders.AleatorioBuilder;
import builders.KamikazeBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Escombro;

public class Nivel1State extends NivelState {

	public Nivel1State(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		fabrica.setEnemyBuilder(new KamikazeBuilder());
		fabrica.construirEnemigo(200, 100, this);
		Enemy enemigo = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo2 = fabrica.getEnemigo();
		fabrica.construirEnemigo(600, 10, this);
		Enemy enemigo3 = fabrica.getEnemigo();
		fabrica.construirEnemigo(100, 30, this);
		Enemy enemigo4 = fabrica.getEnemigo();
		fabrica.construirEnemigo(450, 50, this);
		Enemy enemigo5 = fabrica.getEnemigo();
		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(enemigo3);
		addEntity(enemigo4);
		addEntity(enemigo5);

		//
		Entity barrera1 = new Barricada(100, 320);
		Entity barrera2 = new Barricada(500, 320);
		Entity escombro1 = new Escombro(250, 300);
		Entity escombro2 = new Escombro(400, 320);
		Entity escombro3 = new Escombro(310, 270);
		Entity escombro4 = new Escombro(200, 290);
		addEntity(barrera1);
		addEntity(barrera2);
		addEntity(escombro1);
		addEntity(escombro2);
		addEntity(escombro3);
		addEntity(escombro4);

	}




}
