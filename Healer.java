
public class Healer extends Healers {

	public Healer() {
		super(UnitType.HEALER, new State(70, 100), null);
		ability = new CloseQuarterAttack(AbilityType.STICK, this, 8);
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

	@Override
	public void destroy() throws Throwable {
		spellbook.clear();
		state = null;
		ability = null;
		fr = null;
		heal = null;
		spellbook = null;
		this.finalize();
		
	}

}
