
public class RogueAttack extends Ability {

	public RogueAttack(AbilityType type, Unit owner, int damage) {
		super(type, owner, damage);
	}

	@Override
	void action(Unit target) throws UnitIsDeadException {
		target.takeDamage(damage); 
		
	}

	@Override
	void reaction(Unit target) throws UnitIsDeadException {
		target.isAlive();
	    target.takeDamage(this.getDamage() / 2); 
		
	}

}
