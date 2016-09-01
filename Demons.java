

public abstract class Demons extends Unit {

	protected Unit master;
	
	protected Demons(UnitType demon, State state, Ability ability){
		super(demon, state, ability );
	}
	
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.notifyObservers();
			this.deleteObservers();
			throw new UnitIsDeadException();
		}
	}
	
	abstract void attack(Unit enemy) throws UnitIsDeadException;        
	abstract void counterAttack(Unit enemy) throws UnitIsDeadException;
	abstract void destroy() throws Throwable;

}
