
public abstract class Ability {
	
	protected int damage;	
	protected AbilityType type;	
	protected Unit owner;
	
	
	public Ability(AbilityType type, Unit owner, int damage) {
		super();
		this.damage = damage;
		this.type = type;
		this.owner = owner;
	}
	
	public final int getDamage() {
		return damage;
	}
	public final AbilityType getType() {
		return type;
	}
	public final Unit getOwner() {
		return owner;
	}
	
	abstract void action(Unit target) throws UnitIsDeadException;
	abstract void reaction(Unit target) throws UnitIsDeadException;	
	
	
	
}
