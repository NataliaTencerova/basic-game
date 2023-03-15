package Basic_game;

public class Weapon { 
	public String name;
	public int attack;
	public int defense;
	
	public Weapon(String name, int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}
	
	public int getAttack() { 
		return attack;
	}
	
	public int getDefense() { 
		return defense;
	}
	
	public String toString() {
		return name+" ("+attack+"/"+defense+")";
	}
}
