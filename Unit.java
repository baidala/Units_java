import java.util.Observable;


public abstract class Unit extends  Observable {
	
	protected State state;
	protected Ability ability;
	protected UnitType unitType;
	
	public Unit(UnitType unitType, State state, Ability ability ) {
		super();
		this.state = state;
		this.ability = ability;
		this.unitType = unitType;
	}
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			throw new UnitIsDeadException();
		}

	}
	       
	public final State getState() {
		return state;
	}

	public final Ability getAbility() {
		return ability;
	}

	public final UnitType getUnitType() {
		return unitType;
	}

	public void addHitPoints(int hp) throws UnitIsDeadException {
		int hpNeeded = state.getHitPointsLimit() - state.getHitPoints();
	    
	    this.isAlive();

	    if ( hpNeeded > hp ) {
	    	state.setHitPoints(state.getHitPoints() + hp);
	    } else {
	    	state.setHitPoints(state.getHitPoints() + hpNeeded);
	    }
	}  
	
	public void takeDamage(int damage) throws UnitIsDeadException{
		this.isAlive();
		
		if ( state.getHitPoints() > damage ) {
			state.setHitPoints(state.getHitPoints() - damage);
		} else {
		    state.setHitPoints(0);
		}

	}      
	
	public void takeMagicDamage(int damage) throws UnitIsDeadException{
		takeDamage(damage);
	}
	
	abstract void attack(Unit enemy) throws UnitIsDeadException;        
	abstract void counterAttack(Unit enemy) throws UnitIsDeadException;
	abstract void destroy() throws Throwable;

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
    	
    	str.append("Unit: " + this.getUnitType() + "\n");
    	str.append("hitPoints/hitPointsLimit: " + state.getHitPoints() + "/" + state.getHitPointsLimit() + "\n");
    	str.append("damage: " + ability.getDamage() + "\n");
    	    	
		return str.toString();
	}
	
	

}
