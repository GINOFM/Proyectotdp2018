package inteligencias_movimiento;

import entidades.Entity;
import entidades.Player;

public abstract class InteligenciaMovimientoPlayerRelated implements InteligenciaMovimiento{
	
	protected Player jugador;
	
	public abstract void mover(Entity entidad);

}
