
public class Priest extends Healers {
	private Fireball fr;
	private Heal heal;
	
	public Priest() {
		super(UnitType.PRIEST, new State(70, 100), null);
		
		ability = new PriestPower(AbilityType.STICK, this, 6);
		fr = new Fireball(30, 20);
		heal = new Heal();
			
		spellbook.put(Spellname.FIREBALL, fr);
		spellbook.put(Spellname.HEAL, heal);
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
		spellbook.clear();
		state = null;
		ability = null;
		fr = null;
		heal = null;
		spellbook = null;
		this.finalize();
		
	}

}
