
public abstract class Healers extends Spellcaster {
	protected Fireball fr;
	protected Heal heal;
	
	public Healers(UnitType healer, State state, Ability ability) {
		super(healer, state, ability);
		
		fr = new Fireball(30, 20);
		heal = new Heal();
			
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
	
	abstract void destroy() throws Throwable;

}
