package gamestates;

import base.Fondo;
import builders.AleatorioBuilder;
import builders.FabricaEnemys;
import builders.KamikazeBuilder;
import entidades.Barricada;
import entidades.Enemy;
import entidades.Entity;
import entidades.Escombro;
import entidades.Player;

public class Nivel2State extends NivelState {

	public Nivel2State(GameStateManager gsm) {
		super(gsm);
		init();
	}
	
	public Nivel2State(GameStateManager gsm, Player player, int puntaje, FabricaEnemys fabrica, Fondo fondo) {
		super(gsm, player, puntaje, fabrica, fondo);
		init();
	}

	@Override
	public void init() {
		limpiarListaEntidades();
		addEntity(player);
		fabrica.setEnemyBuilder(new KamikazeBuilder());
		fabrica.construirEnemigo(200, 100, this);
		Enemy enemigo = fabrica.getEnemigo();
		fabrica.setEnemyBuilder(new AleatorioBuilder());
		fabrica.construirEnemigo(400, 10, this);
		Enemy enemigo3 = fabrica.getEnemigo();
		fabrica.construirEnemigo(100, 30, this);
		Enemy enemigo4 = fabrica.getEnemigo();
		addEntity(enemigo);
		addEntity(enemigo3);
		addEntity(enemigo4);

		//
		Entity barrera1 = new Barricada(100, 320);
		Entity escombro1 = new Escombro(250, 300);
		Entity escombro2 = new Escombro(400, 320);

		addEntity(barrera1);
		addEntity(escombro1);
		addEntity(escombro2);
		
		

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