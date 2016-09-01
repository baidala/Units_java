
public class Soldier extends Unit {

	public Soldier() {
		super(UnitType.SOLDIER, new State(100), null);
		ability = new CloseQuarterAttack(AbilityType.SWORD, this, 30);
	}
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.notifyObservers();
			this.deleteObservers();
			throw new UnitIsDeadException();
		}
	}

	@Override
	void attack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.action(enemy);
		
		
	}

	@Override
	void counterAttack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.reaction(enemy);
		
	}

	@Override
	void destroy() throws Throwable {
		state = null;
		ability = null;
		this.finalize();
		
	} 
	
	

}
