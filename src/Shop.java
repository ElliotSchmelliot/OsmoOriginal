
public class Shop {
	private int level;
	private Item[] merchandise;
	
	public Shop(int level) {
		this.level = level;
		merchandise = new Item[5];
		stockShelves();
	}
	
	public Item[] getMerchandise() {
		return merchandise;
	}
	
	public void stockShelves() {
		if (level == 1 || level ==2 || level ==3) {
			merchandise[0] = new Weapon(10, 50, "Shitty Axe", 1);
			merchandise[1] = new Armor(5, 40, "Cardboard Chest Plate", 2);
			merchandise[2] = new Shield(2, 2, "Basic Shield", 2, 2);
			merchandise[3] = new Consumable(10, "Weak Healing Potion", 25);
			merchandise[4] = new Consumable(20, "Dope", 50);
		}
	}
	
	public void printShop() {
		for(int i = 0; i < merchandise.length; i++) {
			System.out.println("#" + (i + 1) + ") " + merchandise[i].examine());
		}
	}
}
