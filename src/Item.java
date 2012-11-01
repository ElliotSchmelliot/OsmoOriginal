
public class Item {
	private int value;
	private String name;
	
	public Item(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	// returns cost
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String examine() {
		return name + ": " + "Value=" + value;
	}
	
	public boolean isWeapon() {
		return false;
	}
	
	public boolean isArmor() {
		return false;
	}
	
	public boolean isShield() {
		return false;
	}
	
	public boolean isConsumable() {
		return false;
	}
}
