
public class WolfState extends MonstersState {
	static WolfState ws_instance = null;
	
	private WolfState() {
		super(200, 0);
		isWolf = true;

	}
	
	public static WolfState getInstance() {
		if( ws_instance == null ) {
			ws_instance = new WolfState();
		}		
		return ws_instance;
	}
	
}
