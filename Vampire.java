
public class Vampire extends Monsters {

	public Vampire() {
		super(UnitType.VAMPIRE, new MonstersState(150, 0), null);
		ability = new VampireAttack(AbilityType.FANGS, this, 10);
	}
	
	public Monsters biteWound(Unit enemy) throws Throwable {
		isAlive();
		return getVampireAbility().bite(enemy);
	} 
	
	private VampireAttack getVampireAbility() {
		return (VampireAttack)ability;
	}

	@Override
	protected Vampire clone() throws CloneNotSupportedException {
		return (Vampire) super.clone();
	}

	
	@Override
	void destroy() throws Throwable {
		state = null;
		ability = null;
		this.finalize();
		
	}

}
