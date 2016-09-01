
public abstract class Monsters extends Unit implements Cloneable {

	public Monsters(UnitType monster, MonstersState state, MonstersAbility ability) {
		super(monster, state, ability);
	}
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.notifyObservers();
			this.deleteObservers();
			throw new UnitIsDeadException();
		}
	}
	
	public void attack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.action(enemy);
	}

	public void counterAttack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.reaction(enemy);
	} 
	
	abstract void destroy() throws Throwable;

}
