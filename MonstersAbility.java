
public abstract class MonstersAbility extends Ability {
	
	public MonstersAbility(AbilityType type, Monsters owner, int damage) {
		super(type, owner, damage);
	}
	
	
	abstract void action(Unit target) throws UnitIsDeadException;
	abstract void reaction(Unit target) throws UnitIsDeadException;
	abstract Monsters bite(Unit target) throws CloneNotSupportedException, UnitIsDeadException, Throwable;
	

}
