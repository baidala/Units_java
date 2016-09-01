
public class Berserker extends Unit {

	public Berserker() {
		super(UnitType.BERSERKER, new State(100), null);
		ability =  new CloseQuarterAttack(AbilityType.AXE, this, 50);
	}
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.notifyObservers();
			this.deleteObservers();
			throw new UnitIsDeadException();
		}
	} 

	@Override
	public void attack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.action(enemy);
	}

	@Override
	public void counterAttack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.reaction(enemy); 
		
	}
	
	public void takeMagicDamage(int damage) {
		return;
	}

	@Override
	void destroy() throws Throwable {
		state = null;
		ability = null;
		this.finalize();
		
	}

}
