
public class HumanState extends MonstersState {
	static HumanState hs_instance = null;
	
	private HumanState() {
		super(150, 0);
		isWolf = false;
	}
	
	private HumanState(int hitPoints, int manaPoints) {
		super(hitPoints, manaPoints);
		isWolf = false; 
	}

	public static HumanState getInstance() {
		if( hs_instance == null ) {
			hs_instance = new HumanState();
		}		
		return hs_instance;
	}

}
