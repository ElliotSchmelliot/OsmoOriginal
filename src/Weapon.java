
public class Weapon extends Item {
	private int attack;
	private int strReq;
	
	public Weapon(int attack, int value, String name, int strReq) {
		super(value, name);
		this.attack = attack;
		this.strReq = strReq;
	}

	public int getAttack() {
		return attack;
	}
	
	public int getStrReq() {
		return strReq;
	}
	
	public String examine() {
		return super.examine() + " Attack=" + attack + " StrReq=" + strReq;
	}
	
	public boolean isWeapon() {
		return true;
	}
}
