import java.util.Scanner;
import java.io.FileNotFoundException;

public class ClassicWorldMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		printIntro();
		//oi
		String name = getName(console);
		String type = getType(name, console);
		Character character = createCharacter(type, console);
		town(character, console);

	}
      
	private static void printIntro() {
		System.out.println("Welcome to ClassicWorld, created by Elliot Keder and James Murphree(3-19-2012)");
		System.out.println("Prepare to slay monsters, rescue princesses, find treasure, and");
		System.out.println("prove your honor in this classic-fashioned adventure game. . .");
		System.out.println();
	}
  
	private static String getName(Scanner console) {
		System.out.println("You awake on the bank of a swift river. You have a pounding");
		System.out.println("headache and your lower lip and cheek are bleeding. Your light");
		System.out.println("brown tunic and leather pants are thoroughly torn and there");
		System.out.println("is seaweed covering your face. As you remove the plant and your");
		System.out.println("vision clears, you can see spirals of smoke coming from the");
		System.out.println("chimneys of a nearby town. You make haste to climb the embankment,");
		System.out.println("licking your lips at the thought of fresh bread. As hard as you");
		System.out.println("try, you cannot remember the last time you ate or where you are.");
		System.out.println("As the village comes into view, a man approaches. \"You there!\"");
		System.out.println("He yells. \"How did you get here? What is your name? Explain");
		System.out.println("yourself at once!\"");
		System.out.println();
		System.out.print("Enter a character name: ");
		String name = console.nextLine();
		System.out.println();
		return name;
	}

	private static String getType(String name, Scanner console) {
		System.out.println("\"" + name + ", huh? Well I've heard worse I suppose. You don't");
		System.out.println("look too bright so I'll make sure to talk real slow for ya. It");
		System.out.println("just so happens that you're trespassing in our village. We have a");
		System.out.println("main gate, but you seem to be slipping in from the river side.");
		System.out.println("So I'm gonna have to go ahead and shoot you with one of my arrows.\"");
		System.out.println("The man unslings his bow and notches an arrow, pointing it directly");
		System.out.println("at you. \"Just out of curiosity, what do you do for a living? You");
		System.out.println("don't look like anyone I've ever seen. Everyone around here is");
		System.out.println("either a Warrior, Mage, or Rogue. What the hell are you supposed");
		System.out.println("to be?\"");
		System.out.println();
		System.out.print("Enter a class:");
		String type = console.nextLine();
		System.out.println();
		return type;
	}
  
	private static Character createCharacter(String type, Scanner console) {
		if(type.toLowerCase().startsWith("war")) {
			Warrior character = new Warrior();
			return character;
		} else if(type.toLowerCase().startsWith("mag")) {
			Mage character = new Mage();
			return character;
		} else if(type.toLowerCase().startsWith("rog")) {
			Rogue character = new Rogue();
			return character;
		} else {
			System.out.println("\"Hmm... I've never heard of one of THOSE before...");
			System.out.println("Don't waste anymore of my time with your silly games.");
			System.out.println("This arrow is itching to get let loose.\"");
			System.out.println("");
          	System.out.print("Enter a class: ");
          	type = console.nextLine();
          	return createCharacter(type, console);
		}
	}
  

	public static void town(Character character, Scanner console) throws FileNotFoundException{
		System.out.print("Where would you like to go? Shop, Inn, or Quest: ");
		String location = console.nextLine();
		if(location.toLowerCase().equals("shop")) {
			shop(character, console);
		} else if(location.toLowerCase().equals("inn")) {
		  
		} else if(location.toLowerCase().equals("quest")) {
			System.out.println();
			QuestManager QM = new QuestManager(character);
		} else {
			System.out.println("Are you lost?");
			town(character, console);
		}
	}
  
	public static void shop(Character character, Scanner console) throws FileNotFoundException {
		System.out.println();
		character.getInventoryManager().printInventory(); //////////
		System.out.println("Welcome to the shop. Feel free to browse.");
		System.out.print("Would you like to buy, sell, or exit? ");
		Scanner num = new Scanner(System.in);
		
		String response = console.nextLine();
		System.out.println();

		if(response.toLowerCase().startsWith("buy")) {
			System.out.println("Here's what we have in stock right now.");
			Shop shop = new Shop(character.getLevel());
			shop.printShop();
			System.out.println("Your current Money: " + character.getMoney());
			System.out.print("What would you like to buy? Please enter the number corresponding with the item's index: ");
			int index = num.nextInt();
			if(index <= shop.getMerchandise().length && index > -1) {
				if(character.buy(shop.getMerchandise()[index - 1]) == true) {
					System.out.println("Ah! A fine choice!");
					character.getInventoryManager().addItem(shop.getMerchandise()[index - 1]);
					System.out.println("Anything else for today?");
					shop(character, console);
				} else {
					System.out.println("I'm sorry. You dont seem to have enough money for that item.");
					shop(character, console);
				}
			} else {
				System.out.println("There's nothing there, fool.");
				shop(character, console);
			}
		} else if(response.toLowerCase().startsWith("sel")) {
			System.out.println("Here's what ya got on you. ");
			character.getInventoryManager().printInventory();
			System.out.println();
			if (character.getInventoryManager().getInventory()[0] != null) {
				System.out.print("What item would you like to sell? Enter an index: ");
				int sell = num.nextInt();
				if(sell >= character.getInventoryManager().getInventory().length) {
					if(character.getInventoryManager().getInventory()[sell - 1] != null) {
						character.sellItem(character.getInventoryManager().getInventory()[sell - 1], sell);
						System.out.println("Thank you. Someone else will want this.");
						System.out.println("You now have $" + character.getMoney());
						System.out.println("Can I do anything else for you?");
						shop(character, console);
					} else {
						System.out.println("That index seems to be empty.");
						shop(character, console);
					}
				
				} else {
					System.out.println("There's nothing there, fool.");
					shop(character, console);
				}
			} else {
				shop(character, console);
			}
		} else if(response.toLowerCase().startsWith("exi")) {
			System.out.println("Stop in again soon. Next time bring your friends.");
			town(character, console);
		} else {
			System.out.println("Sorry, I dont understand. What do you want to do?");
			shop(character, console);
		}
	}
  
	//public static void test(Character character) {
		//Item oneHandMace = new Weapon(10, 1, 100);
		//System.out.println(oneHandMace.getAttack());
		//System.out.println(oneHandMace.getBlock());
		//System.out.println(oneHandMace.getValue());
			 
		//Weapon thisThing = new Weapon(4, 3, "thisThing", 1);
		//System.out.println(thisThing.getValue());
		//character.addItem(thisThing);
			 
		//Consumable potion = new Consumable(10, 100);
		//System.out.println(potion.getPotency());
		//System.out.println(potion.getAttack());
		//character.addItem(potion);
			  
	//}
	
	public void fight(Character character, Monster creature, Scanner console) {
		int monsterHealth = creature.getHealth();
		boolean run = false;
		while (monsterHealth > 0 && character.getHealthCurrent() > 0 && run == false) {
			char action = action(console);
			if (action == 'a') {
				monsterHealth -= character.attack(creature.getDefense());
			} else {
				run = true;
			}
			character.takeDamage(creature.getAttack());
		}
		if (monsterHealth <= 0) {
			if (character.gainExp(creature.getExp())) {
				character.level(1, 1, 1, 1);
			}
		}
	}
	
	public char action(Scanner console) {
		System.out.println("Action (Attack, Use Potion, Run): ");
		String input = console.nextLine();
		if (input.toLowerCase().startsWith("a")) {
			return 'a';
		} else {
			return 'r';
		}
	}
  
	public static void gameOver() {
		System.out.println("GAME OVER MAN!");
	}
  
}


