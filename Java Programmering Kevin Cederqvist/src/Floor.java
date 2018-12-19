
public class Floor {
	private int num;
	private String name;
	private String pling_sound;

	Floor(int num, String Name, String pling_sound) { //separate constructor for floor 0-3 + 13, which doesn't use normal plings
		this.setNum(num);
		this.setName(Name);
		this.setPling_sound(pling_sound); //still calls upon setPling_sound method. Just with a special pling_sound string attached.
	}

	Floor(int num) { //for 4th-12th & 14th-15th floor, creates generic suffix to the floor and pling sounds.
		this.setNum(num);
		this.setName((this.num + "th floor")); //this is because "1st, 2nd & 3rd" is different from "nth".
		this.setPling_sound("plings " + this.num + " times as you pass the " + this.num + "th floor.");
		}

	int getNum() {
		return num;
	}
	void setNum(int num) {
		this.num = num;
	}
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	String getPling_sound() {
		return pling_sound;
	}
	void setPling_sound(String pling_sound) {
		this.pling_sound = "The elevator " + pling_sound;
	}
	
}
