
public class HumanAttack extends MonstersAbility {
	private static HumanAttack ha_instance;
	
	private HumanAttack(Monsters owner) {
		super(AbilityType.FANGS, owner, 20);
		ha_instance = null;
	}

	@Override
	void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage);
		target.isAlive();
		target.counterAttack(this.getOwner()); 

	}

	@Override
	void reaction(Unit target) throws UnitIsDeadException {
		target.isAlive();
	    target.takeDamage(this.getDamage() / 2); 

	}

	@Override
	Monsters bite(Unit target) {
		return null;
	}

	public static HumanAttack getInstance(Monsters owner) {
		if( ha_instance == null ) {
			ha_instance = new HumanAttack(owner);
		}		
		return ha_instance;
	}

}
