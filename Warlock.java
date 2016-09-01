
public class Warlock extends Warlocks {

	public Warlock() {
		super(UnitType.WARLOCK, new State(70, 100), null);
		ability = new CloseQuarterAttack(AbilityType.SWORD, this, 7);
	}
	
	Demons callInTheDemon(UnitType demon) throws NotTheDemonException {
	    if( demon == UnitType.AZAZEL ) {
			return new Azazel(this);
		}
		if( demon == UnitType.BAALZEBUL ) {
			return new Baalzebul(this);
		} else {
		    throw new NotTheDemonException();
		}
	    
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
