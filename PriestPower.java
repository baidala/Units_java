
public class PriestPower extends Ability {

	public PriestPower(AbilityType type, Unit owner, int damage) {
		super(type, owner, damage);
		
	}

	@Override
	void action(Unit target) throws UnitIsDeadException {
		UnitType unitType = this.getOwner().getUnitType();
		
		if ( unitType == UnitType.VAMPIRE || unitType == UnitType.NECROMANCER ) {
			target.takeDamage(damage*2);
			target.isAlive();
			target.counterAttack(this.getOwner());
		} else {
			target.takeDamage(damage);
			target.isAlive();
			target.counterAttack(this.getOwner());
		} 
		
	}

	@Override
	void reaction(Unit target) throws UnitIsDeadException {
		UnitType unitType = this.getOwner().getUnitType();
		
		target.isAlive();
		if ( unitType == UnitType.VAMPIRE || unitType == UnitType.NECROMANCER ) {
			target.takeDamage(this.getDamage());
		} else {
			target.takeDamage(this.getDamage() / 2);
		} 
		
	}

}
