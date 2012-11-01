
public class Shield extends Armor {
	private int block;
	
	public Shield(int defense, int value, String name, int strReq, int block) {
		super(defense, value, name, strReq);
	}
	
	public int getBlock() {
		return block;
	}
	
	public String examine() {
		return super.examine() + "Block=" + block;
	}
	
	public boolean isShield() {
		return true;
	}
}
