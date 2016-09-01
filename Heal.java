
public class Heal extends Spell {
	
	public Heal() {
		super(30, 40);
	}
	
	public Heal(int cost, int spellpower) {
		super(cost, spellpower);
	}

	@Override
	void action(Unit target) throws UnitIsDeadException {
		target.addHitPoints(spellpower); 

	}

}
