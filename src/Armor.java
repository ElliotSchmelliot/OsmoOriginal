//TODO: add durability

public class Armor extends Item {
	private int defense;
	private int strReq;
	
	public Armor(int defense, int value, String name, int strReq) {
		super(value, name);
		this.defense = defense;
		this.strReq = strReq;
	}
	
	public int getDefense() {
		System.out.println();
		return defense;
	}
	
	public int getStrReq() {
		return strReq;
	}
	
	public String examine() {
		return super.examine() + " Defense=" + defense + " StrReq=" + strReq;
	}
	
	public boolean isArmor() {
		return true;
	}
}
