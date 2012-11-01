
public class Warrior extends Character {
	
	public Warrior() {
       super(50, 70, 100, 100);
   }
	
	public int getPreferredStat() {
		return getStrength();
	}
   
}
