
public class Consumable extends Item {
	private int potency;
	
	public Consumable(int potency, String name, int value) {
		super(value, name);
		this.potency = potency;
	}
	
	// WHTF
	public int getPotency() {
		return potency;
	}
	
	public String examine() {
		return super.examine() + " Potency=" + potency;
	}
	
	public boolean isConsumable() {
		return true;
	}
	
	
}
