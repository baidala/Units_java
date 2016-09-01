import java.util.Observable;
import java.util.Observer;
import java.util.Vector;


public class Necromancer extends Warlocks implements UnitObserver {
	private Vector<Observable> targetsList;
	
	public Necromancer() {
		super(UnitType.NECROMANCER, new State(70, 100), null);
		ability = new CloseQuarterAttack(AbilityType.STICK, this, 10);
	}
	
	public void isAlive() throws UnitIsDeadException {
		if ( state.getHitPoints() < 1 ) {
			this.detachAll();
			throw new UnitIsDeadException();
		}
	}
	
	public void cast(Spellname spellname, Unit target) throws OutOfManaException, UnitIsDeadException {
		Spell spell = spellbook.get(spellname);
		
		if ( spell != null ) {
			spendMana( spell.getCost() );
			spell.action(target);
			addTarget(target); 
		}
	} 
	
	public synchronized void addTarget(Observable target) {
        if (target == null)
            throw new NullPointerException();
        if (!targetsList.contains(target)) {
        	targetsList.addElement(target);
        }
    }
	
	public void detachAll() {
		Object[] arrLocal;
		
		arrLocal = targetsList.toArray();
		for (int i = arrLocal.length-1; i>=0; i--){
            ((Observable)arrLocal[i]).deleteObserver((Observer)this);
		}
		targetsList.removeAllElements(); 
	} 

	@Override
	public synchronized void update(Observable target) throws UnitIsDeadException {
		
		try {
			this.addHitPoints(((Unit)target).getState().getHitPointsLimit() / 5);
		} catch (UnitIsDeadException e) {
			this.addHitPoints(1);
		}
		targetsList.removeElement(target); 

	}
	
	@Override
	public void attack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.action(enemy);
		addTarget(enemy);
		
	}

	@Override
	public void counterAttack(Unit enemy) throws UnitIsDeadException {
		isAlive();	
		ability.reaction(enemy);
		addTarget(enemy);
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
