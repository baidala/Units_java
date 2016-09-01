
public class WolfAttack extends MonstersAbility {
	private static WolfAttack wa_instance;
	
	private WolfAttack(Monsters owner) {
		super(AbilityType.FANGS, owner, 20);
		wa_instance = null;
	}
	
	public final Werewolf getMonster() {
		return (Werewolf) owner;
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
	Werewolf bite(Unit target) throws Throwable {
		UnitType unitType = target.getUnitType();
		
		target.takeDamage(target.getState().getHitPointsLimit());
		if (unitType == UnitType.VAMPIRE || unitType == UnitType.WEREWOLF) {
			return null;
		}
		target.destroy();
		
		return (Werewolf) this.getMonster().clone(); 
	}
	
	public static WolfAttack getInstance(Monsters owner) {
		if( wa_instance == null ) {
			wa_instance = new WolfAttack(owner);
		}		
		return wa_instance;
	}

}
