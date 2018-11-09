package base;

import entidades.Entity;

public class ColEscudo extends Colisionador {

	private Entity entidad;
	
	public ColEscudo(Entity entidad)
	{
		this.entidad=entidad;
	}
	@Override
	public void chocaEnemigo(Entity e) {
		entidad.golpear(e);
		
	}

	@Override
	public void chocaDisparoJugador(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaDisparoEnemigo(Entity e) {
		entidad.golpear(e);
		
	}

	@Override
	public void chocaJugador(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaEscombro(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaBarricada(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocaPowerUp(Entity e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chocaEscudo(Entity e) {
		// TODO Auto-generated method stub
		
	}

}
