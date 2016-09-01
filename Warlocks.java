
public abstract class Warlocks extends Spellcaster {
	protected Fireball fr;
	protected Heal heal;
	
	public Warlocks(UnitType unitType, State state, Ability ability) {
		super(unitType, state, ability);
		
		Fireball fr = new Fireball();
	    Heal heal = new Heal(30,20); 
	    
	    spellbook.put(Spellname.FIREBALL, fr);
		spellbook.put(Spellname.HEAL, heal);
	}
	
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.notifyObservers();
			this.deleteObservers();
			throw new UnitIsDeadException();
		}
	}
	
	public void cast(Spellname spellname, Unit target) throws OutOfManaException, UnitIsDeadException {
		Spell spell = spellbook.get(spellname);
		
		if ( spell != null ) {
			spendMana( spell.getCost() );
			spell.action(target);
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
	
	abstract void destroy() throws Throwable;

}
