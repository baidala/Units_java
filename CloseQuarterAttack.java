
public class CloseQuarterAttack extends Ability {

	public CloseQuarterAttack(AbilityType type, Unit owner, int damage) {
		super(type, owner, damage);
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
		target.takeDamage(damage/2); 
		
	}
}
