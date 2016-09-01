
public class State {

	private int hitPoints;
	private int hitPointsLimit;
	private int manaPoints;
	private int manaPointsLimit;
	
	public State(int hitPoints, int manaPoints) {
		super();
		this.hitPoints = hitPoints;
		this.hitPointsLimit = hitPoints;
		this.manaPoints = manaPoints;
		this.manaPointsLimit = manaPoints;
	}

	public State(int hitPoints) {
		super();
		this.hitPoints = hitPoints;
		this.hitPointsLimit = hitPoints;
		this.manaPoints = 0;
		this.manaPointsLimit = 0;
	}

	public final int getHitPoints() {
		return hitPoints;
	}

	public final void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public final int getHitPointsLimit() {
		return hitPointsLimit;
	}

	public final void setHitPointsLimit(int hitPointsLimit) {
		this.hitPointsLimit = hitPointsLimit;
	}

	public final int getManaPoints() {
		return manaPoints;
	}

	public final int getManaPointsLimit() {
		return manaPointsLimit;
	}

	public final void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}

	public final void setManaPointsLimit(int manaPointsLimit) {
		this.manaPointsLimit = manaPointsLimit;
	}

	
	

}
