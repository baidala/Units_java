
public class Fireball extends Spell {

	public Fireball() {
		super(30, 40);
	}
	
	public Fireball(int cost, int spellpower) {
		super(cost, spellpower);
	}

	@Override
	void action(Unit target) throws UnitIsDeadException {
		target.takeMagicDamage(spellpower); 
		
	}

}
