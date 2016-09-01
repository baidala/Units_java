
public class Main {

	/**
	 * @param args
	 * @throws NotTheDemonException 
	 */
	public static void main(String[] args) throws NotTheDemonException {
		
		Warlock warlock = new Warlock();
		Azazel azazel = (Azazel) warlock.callInTheDemon(UnitType.AZAZEL);
		Baalzebul baal = (Baalzebul) warlock.callInTheDemon(UnitType.BAALZEBUL);
			
		Berserker bers = new Berserker();
		Healer healer = new Healer();
		Necromancer necro = new Necromancer();
		Priest priest = new Priest();
		Rogue rogue = new Rogue();
		Soldier sold = new Soldier();
		Vampire vamp = new Vampire();
		Werewolf wolf = new Werewolf();
		Wizard wiz = new Wizard();
		
		System.out.println(warlock.toString());
		System.out.println(azazel.toString());
		System.out.println(baal.toString());
		System.out.println(bers.toString());
		System.out.println(healer.toString());
		System.out.println(necro.toString());
		System.out.println(priest.toString());
		System.out.println(rogue.toString());
		System.out.println(sold.toString());
		System.out.println(vamp.toString());
		System.out.println(wolf.toString());
		System.out.println(wiz.toString());
		

	}

}
