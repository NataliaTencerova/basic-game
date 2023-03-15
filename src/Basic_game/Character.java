package Basic_game;

public class Character { 
	public String name;
	public int strength;
	public int agility;
	public int vitality;
	public int health;
	public boolean left;
	public boolean right;
	
	public Character(String name, int strength, int agility, int vitality) {
		this.name = name;
		this.strength = strength;
		this.agility = agility;
		this.vitality = vitality;
		this.health = vitality;
		this.left = false;
		this.right = false;
		
	}
	
	public boolean takeWeapon(Hand hand, Weapon weapon) { 
		if(hand == Hand.LEFT && left == false) {
			left = true;
			strength += weapon.getAttack();
			agility += weapon.getDefense();
			
			return left;
		}
		if(hand == Hand.RIGHT && right == false) {
			right = true;
			strength += weapon.getAttack();
			agility += weapon.getDefense();
			
			return right;
		}
		
		return false;
	}
	
//	public void weaponStrength(Hand hand, Weapon weapon) { 
//		if(hand == Hand.LEFT && left == true) {
//			strength += weapon.getAttack();
//			agility += weapon.getDefense();
//		}
//		if (hand == Hand.RIGHT && right == true) {
//			strength += weapon.getAttack();
//			agility += weapon.getDefense();
//		}
//	}
//	
	public int defend(int attack) { 
		int dmg = attack - agility;
		if(dmg > 0) {
			health -= dmg;
			
			return dmg;
		}
		
		return 0;
	}
	
	public int attack() { 
		return strength;
	}
	
	public boolean isAlive() { 
		if (health > 0) {
			return true;
		}
		
		return false;
	}
	
	public String toString() { 
		return ""+name+" ["+health+"/"+vitality+"] ("+strength+"/"+agility+")";
	}
}