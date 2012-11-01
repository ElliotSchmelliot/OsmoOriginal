//TODO: incorporate difficulty
//TODO: wallet object? (copper, silver, gold)
//TODO: Equipment array[Item] instead of 7 fields?

import java.util.ArrayList;
import java.util.Scanner;

public class Character {
	private int level;
	private int experience;
	private int money;
	private int magic;
	private int agility;
	private int strength;
	private int healthMax;
	private int healthCurrent;
	private int inventoryCount;
	private InventoryManager inventory;
	private Weapon weapon;
	private Shield shield;
	private Armor head;
	private Armor chest;
	private Armor legs;
	private Armor boots;
	private Armor gloves;
  	
	public Character(int magic, int agility, int strength, int healthMax) {
		level = 1;
		experience = 0;
		money = 100;
		this.magic = magic;
		this.agility = agility;
		this.strength = strength;
		this.healthMax = healthMax;
		healthCurrent = healthMax;
		inventory = new InventoryManager();
		inventoryCount = 0;
		head = new Armor(1,1,"Viking Helmet",1);
		chest = new Armor(1,1,"BadAss Chest Piece",1);
		legs = new Armor(1,1,"BadAss Legs",1);
		boots = new Armor(1,1,"BadAss Viking Boots of Swiftness",1);
		gloves = new Armor(1,1,"Newbie Gloves",1);
		shield = new Shield(1,1,"Oslo Shield",1,1);
		weapon = new Weapon(1,1,"BadAss Walrus LongSword",1);
	}
  
	public int getLevel() {
		return level;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getMagic() {
		return magic;
	}
	
	public int getAgility() {
		return agility;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getHealthMax() {
		return healthMax;
	}
	
	public int getHealthCurrent() {
		return healthCurrent;
	}
	
	public InventoryManager getInventoryManager() {
		return inventory;
	}
	/*
	public void printInventory() {
		if(inventory[0] == null) {
			System.out.println("Inventory Empty");
		} else {
			for(int i = 0; i < inventoryCount; i++) {
				if(inventory[i] != null) {
					System.out.println(i + ") " + inventory[i].examine());
				}
			}
		}
	}
	
	public void addItem(Item x, Scanner console) {
		if (inventoryCount == inventory.length) {
			System.out.println("Inventory Full");
			System.out.println("Would you like to swap an item (yes/no)? ");
			String answer = console.nextLine();
			if (answer.toLowerCase().startsWith("y")) {
				swap(x);
			}
		} else {
			inventory[inventoryCount] = x;
			inventoryCount++;
		}
	}
	
	public void swap(Item x) {
		printInventory();
		Scanner input = new Scanner(System.in);
		System.out.println("what would you like to swap with the item " + x.getName() + "? (enter number)");
		int replace = input.nextInt();
		inventory[replace - 1] = x;
	}
	*/
	public void sellItem(Item item, int index) {
		money += item.getValue();
		inventory.getInventory()[index] = null;
	}

	public boolean buy(Item item) {
		if(money >= item.getValue()) {
			money -= item.getValue();
			return true;
		} else {
			return false;
		}
	}
	
	public void examine() {
		System.out.println(head.examine());
		System.out.println(chest.examine());
		System.out.println(legs.examine());
		System.out.println(boots.examine());
		System.out.println(gloves.examine());
		System.out.println(weapon.examine());
		System.out.println(shield.examine());
	}
	
	public boolean gainExp(int exp) {
		experience += exp;
		if (experience >= level * 100) {
			return true;
		}
		return false;
	}
	
	public int attack(int creatureDefense) {
		return 10 - creatureDefense;
	}
	
	public void level(int magic, int agility, int strength, int healthMax) {
		this.magic += magic;
		this.agility += agility;
		this.strength += strength;
		this.healthMax += healthMax;
		healthCurrent = healthMax;
		level++;
		experience = 0;
	}
  
	public void takeDamage(int damage) {
		healthCurrent -= damage;
		if(healthCurrent <= 0) {
			//DEAD (needs to be checked in ClassicWorldMain)
		}
	}
  
	public void heal(int heal) {
		healthCurrent += heal;
		if(healthCurrent > healthMax) {
			healthCurrent = healthMax;
		}
	}
	
	
	// NEED AN INVENTORYMANAGER
//	public boolean usePot(Consumable pot) {
//		if (inventory.)
//		healthCurrent += pot.getPotency();
//		if (healthCurrent > healthMax) {
//			healthCurrent = healthMax;
//		}
//	}
  
}



