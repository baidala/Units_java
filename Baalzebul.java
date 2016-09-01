
public class Baalzebul extends Demons {

	public Baalzebul(Unit master) {
		super(UnitType.BAALZEBUL, new State(100), null);
		ability =  new CloseQuarterAttack(AbilityType.AXE, this, 40);
		this.master = master; 
	}
	
	@Override
	void attack(Unit enemy) throws UnitIsDeadException {
		isAlive();
		try {
			if ( enemy != master ) {	
				ability.action(enemy);
			}
		} catch (Exception e) {
			throw new UnitIsDeadException(); 
		} 
		
	}

	@Override
	void counterAttack(Unit enemy) throws UnitIsDeadException {
		isAlive();
		if ( enemy != master ) {	
			ability.reaction(enemy);
		} 
		
	}

	@Override
	void destroy() throws Throwable {
		state = null;
		ability = null;
		master = null;
		this.finalize();
				
	}
	

}
