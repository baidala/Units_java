import java.util.HashMap;


public abstract class Spellcaster extends Unit {
	protected HashMap<Spellname, Spell> spellbook;
	
	public Spellcaster(UnitType unitType, State state, Ability ability) {
		super(unitType, state, ability);
		spellbook = new HashMap<Spellname, Spell>(); 
	}
	
	public void spendMana(int amount) throws OutOfManaException {
		int newMP = state.getManaPoints() - amount;
		if ( newMP < 0 ) {
			throw new OutOfManaException();
		}
		state.setManaPoints(newMP); 
	}
	
	abstract void cast(Spellname spellname, Unit target) throws OutOfManaException, UnitIsDeadException;
	abstract void destroy() throws Throwable; 

}
