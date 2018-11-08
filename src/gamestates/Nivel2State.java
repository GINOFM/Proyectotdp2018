package gamestates;

import UI.BarraSalud;
import base.Fondo;
import builders.AleatorioBuilder;
import builders.FabricaEnemys;
import builders.KamikazeAleatorioBuilder;
import builders.KamikazeAleatorioPerdibleBuilder;
import builders.KamikazeDirigidoBuilder;
import builders.TestBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Escombro;
import entidades.Player;

public class Nivel2State extends NivelState {

	public Nivel2State(GameStateManager gsm) {
		super(gsm);
	}

	public Nivel2State(GameStateManager gsm, Player player, int puntaje, FabricaEnemys fabrica, Fondo fondo,
			BarraSalud bs) {
		super(gsm, player, puntaje, fabrica, fondo, bs);
	}

	@Override
	public void init() {
		limpiarListaEntidades();
		addEntity(player);
	
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
		fabrica.setEnemyBuilder(new KamikazeAleatorioPerdibleBuilder());
		fabrica.construirEnemigo(300, 80, this);
		Enemy enemigo5 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new KamikazeAleatorioPerdibleBuilder());
		fabrica.construirEnemigo(220, 150, this);
		Enemy enemigo6 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(300, 240, this);
		Enemy enemigo7 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new TestBuilder());
		fabrica.construirEnemigo(470, 20, this);
		Enemy enemigo8 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new TestBuilder());
		fabrica.construirEnemigo(120, 70, this);
		Enemy enemigo9 = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new KamikazeDirigidoBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo10 = fabrica.getEnemigo();

		addEntity(enemigo);
		addEntity(enemigo2);
		addEntity(enemigo3);
		addEntity(enemigo4);
		addEntity(enemigo5);
		addEntity(enemigo6);
		addEntity(enemigo7);
		addEntity(enemigo8);
		addEntity(enemigo9);
		addEntity(enemigo10);

		//
		Entity barrera1 = new Barricada(280, 280);
		Entity escombro1 = new Escombro(220, 300);
		Entity escombro2 = new Escombro(70, 320);
		Entity escombro3 = new Escombro(120, 300);
		Entity escombro4 = new Escombro(160, 320);
		Entity escombro5 = new Escombro(420, 300);
		Entity escombro6 = new Escombro(470, 320);
		Entity escombro7 = new Escombro(520, 300);
		Entity escombro8 = new Escombro(580, 320);

		addEntity(barrera1);
		addEntity(escombro1);
		addEntity(escombro2);
		addEntity(escombro3);
		addEntity(escombro4);
		addEntity(escombro5);
		addEntity(escombro6);
		addEntity(escombro7);
		addEntity(escombro8);

		cantidadEnemigos = 3;
	}

	@Override
	public void pasarAlSiguienteNivel() {
		// TODO Auto-generated method stub
	}

	@Override
	public Player getPlayer() {
		return player;
	}
}