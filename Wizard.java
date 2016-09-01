
public class Wizard extends Warlocks {

	public Wizard() {
		super(UnitType.WIZARD, new State(70, 100), null);
		
		ability = new CloseQuarterAttack(AbilityType.STICK, this, 10);
	}
	
	

	@Override
	void destroy() throws Throwable {
		spellbook.clear();
		state = null;
		ability = null;
		fr = null;
		heal = null;
		spellbook = null;
		this.finalize();
		
	}
	
	

}
