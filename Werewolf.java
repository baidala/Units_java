
public class Werewolf extends Monsters implements Cloneable {

	public Werewolf() {
		super(UnitType.WEREWOLF, HumanState.getInstance(), null);
		ability = HumanAttack.getInstance(this);
	}
	
	public MonstersState getWerewolfState() {
		return (MonstersState) state;
	}
	
	public MonstersAbility getWerewolfAbility() {
		return (MonstersAbility)ability;
	}

	public void changeState() {
		if( getWerewolfState().isWolf ) {
			this.state = HumanState.getInstance();
			this.ability = HumanAttack.getInstance(this);
		} else {
			this.state = WolfState.getInstance();
			this.ability = WolfAttack.getInstance(this);
		}
		
	}

	public Monsters biteWound(Unit enemy) throws Throwable {
		Monsters wf = null;
		
		isAlive();
		if ( getWerewolfState().isWolf ) { 
			wf = getWerewolfAbility().bite(enemy);	
		}
		return wf;
	}

	public void takeMagicDamage(int damage) throws UnitIsDeadException {	
		if( getWerewolfState().isWolf ) {
			takeDamage(damage+5);
		} else {
			takeDamage(damage);
		}
	}
	
	

	@Override
	protected Werewolf clone() throws CloneNotSupportedException {
		return (Werewolf) super.clone();
	}

	@Override
	void destroy() throws Throwable {
		state = null;
		ability = null;
		this.finalize();
		
	}

}
