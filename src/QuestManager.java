import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class QuestManager {
	Scanner number;
	Scanner QIscan;
	Scanner Qscan;
	Scanner input;
	String[] quests;
	Random dice;

	public QuestManager(Character hero) throws FileNotFoundException {
		number = new Scanner(new File("QuestIndex.txt"));
		quests = new String[number.nextInt()];
		QIscan = new Scanner(new File("QuestIndex.txt"));
		input = new Scanner(System.in);
		dice = new Random();
		int i = 0;
		int j = 1;
		QIscan.nextLine();
		System.out.println();
		System.out.println("PICK A QUEST FROM THE LIST");
		while (QIscan.hasNextLine()) {
			String next = QIscan.nextLine();
			if (next.startsWith("Quest")) {
				quests[i] = "Quest" + j + ".txt";
				i++;
				j++;
			}
			System.out.println(next);
		}
		System.out.print("Pick a quest (enter a number): ");
		String getQuest = quests[input.nextInt() - 1];
		Qscan = new Scanner(new File(getQuest));
		storyReader(hero);
	}
	
	private void storyReader(Character hero) {
		String nextLine = Qscan.nextLine();
		while (!nextLine.startsWith("end")) {
			
			// monster encounter
			if (nextLine.equals("<>")) {
				String monsterName = Qscan.nextLine();
				String monsterStats = Qscan.nextLine();
				Scanner Mscan = new Scanner(monsterStats);
				Monster creature = new Monster(monsterName,Mscan.nextInt(),Mscan.nextInt(),Mscan.nextInt(),Mscan.nextInt());
				fight(hero, creature, input);
			if (hero.getHealthCurrent() <= 0) {
				System.out.println("You're Dead!");
			}
			
			// player choice (???)
			} else if (nextLine.equals("???")) {
			
			// find something (...)
			} else if (nextLine.equals("...")) {
				
			// continue story
			} else {
				System.out.println(nextLine);
			}
			if (hero.getHealthCurrent() > 0) {
				nextLine = Qscan.nextLine();
			} else {
				System.out.println("AH HE DEAD HE DEAD");
				nextLine = "end";
			}
		}
	}
	
	public void fight(Character hero, Monster creature, Scanner input) {
		int monsterHealth = creature.getHealth();
		boolean run = false;
		while (monsterHealth > 0 && hero.getHealthCurrent() > 0 && run == false) {
			char action = action(input);
			if (action == 'a') {
				monsterHealth -= hero.attack(creature.getDefense());
//			} else if (action == 'p') {
//				
			} else {
				if (dice.nextInt(20) + 1 > 10) {
					run = true;
				}
			}
			hero.takeDamage(creature.getAttack());
		}
		if (monsterHealth <= 0) {
			if (hero.gainExp(creature.getExp())) {
				hero.level(1, 1, 1, 1);
			}
		}
	}
	
	public char action(Scanner input) {
		System.out.println("Action (Attack, Use Potion, Run): ");
		String action = input.next();
		if (action.toLowerCase().startsWith("a")) {
			return 'a';
//		} else if (input.toLowerCase().startsWith("p")) {
//			return 'p';
		} else {
			return 'r';
		}
	}
	
}
