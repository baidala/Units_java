
public abstract class Spell {
	protected int cost;
	protected int spellpower; 
		
	public Spell(int cost, int spellpower) {
		this.cost = cost;
		this.spellpower = spellpower;
	}

	public final int getCost() {
		return cost;
	}

	public final int getSpellpower() {
		return spellpower;
	}

	

	abstract void action(Unit target) throws UnitIsDeadException;
}
