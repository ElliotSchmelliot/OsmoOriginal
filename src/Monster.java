
public class Monster {
	private String name;
	private int attack;
	private int defense;
	private int health;
	private int exp;
	
	public Monster(String name, int attack, int defense, int health, int exp) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.exp = exp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getExp() {
		return exp;
	}
	
}
