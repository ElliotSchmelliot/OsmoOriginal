
import java.util.Arrays;
import java.util.Scanner;

public class InventoryManager {
	private Item inventory[];
	private int items;
	private Scanner input;
	private Scanner console;
	
	public InventoryManager() {
		inventory = new Item[10];
		items = 0;
		input= new Scanner(System.in);
		console = new Scanner(System.in);
	}
	
	public Item[] getInventory() {
		return inventory;
	}
	
	public void addItem(Item newItem) {
		if (items == inventory.length) {
			swap(newItem);
		} else {
			inventory[items] = newItem;
			items++;
		}
	}
	
	public void swap(Item newItem) {
		System.out.print("Inventory full. Would you like to swap an item? ");
		if (console.nextLine().toLowerCase().startsWith("yes")) {
			printInventory();	
			System.out.println("Which item would you like to swap with?");
			System.out.print("Enter a number: ");
			inventory[input.nextInt() - 1] = newItem;
		}
	}
	
	public void printInventory() {
		if(inventory[0] == null) {
			System.out.println("Inventory Empty.");
		} else {
			System.out.println("Inventory:");
			for (int i = 0; i < items; i++) {
				System.out.println("#" + (i + 1) + ") " + inventory[i].examine());
			}
		}
	}
	
	public void remove(Item item) {
		if (!contains(item)) {
			System.out.println("You do not have " + item.getName());
		} else {
			boolean gone = false;
			int i = 0;
			while (gone) {
				if (inventory[i].getName().equals(item)) {
					inventory[i] = inventory[items - 1];
					inventory[items - 1] = null;
					items--;
					gone = true;
				}
				i++;
			}
		}
	}
	
	public boolean contains(Item item) {
		for (int i = 0; i < items; i++) {
			if (item.getName().equals(inventory[i].getName())) {
				return true;
			}
		}
		return false;
	}
}






/*
import java.util.ArrayList;
public class InventoryManager {
	private ArrayList inventory;
	private int maxSize;
	
	public InventoryManager() {
		inventory = new ArrayList();
		maxSize = 10;
	}
	
	public ArrayList getInventory() {
		return inventory;
	}
	
	public void printInventory() {
		if (inventory.size() == 0) {
			System.out.println("Inventory Empty.");
		} else {
		System.out.println(inventory);
		}
	}
	
	public void addItem(Item x) {
		inventory.add(x);
	}
}*/