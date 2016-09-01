import java.util.Observable;



public interface UnitObserver {
	
	void update(Observable o) throws UnitIsDeadException;

}
