package Basic_game;

import java.util.Scanner;

public class Basic_game {
	
	static Scanner sc = new Scanner(System.in);
	public static Character loadCharacter(Scanner sc) { 
		System.out.println("Pick a name: ");
		String name = sc.nextLine();
		System.out.println("Initial strength: ");
		int strength = Integer.parseInt(sc.nextLine());
		System.out.println("Initial defense: ");
		int agility = Integer.parseInt (sc.nextLine());
		System.out.println("Health: ");
		int vitality = Integer.parseInt(sc.nextLine());
		
		Character character = new Character(name, strength, agility, vitality);
		
		return character;
	}
	
	public static Weapon loadWeapon(Scanner sc) { 
		System.out.println("Pick a weapon name: ");
		String name = sc.nextLine();
		if (name.isBlank()){
			return null;
		}
		else {
			System.out.println("Weapon strength: ");
			int attack = Integer.parseInt(sc.nextLine());
			System.out.println("Weapon defense: ");
			int defense = Integer.parseInt(sc.nextLine());
			Weapon weapon = new Weapon(name, attack, defense);
			
			return weapon;
		}
	}
	
	public static void armCharacter(Character character, Weapon left, Weapon right) { 
		if(left != null) {
			character.takeWeapon(Hand.LEFT, left);
//			character.weaponStrength(Hand.LEFT, left);
		}
		if(right != null) {
			character.takeWeapon(Hand.RIGHT, right);
//			character.weaponStrength(Hand.RIGHT, right);
		}
	}
	
	public static Character fight(Character character1, Character character2) { 
		while(true) {
			character2.defend(character1.attack());
			if(character2.isAlive() == false) {
				return character1;
			}
			
			character1.defend(character2.attack());
			if(character1.isAlive() == false) {
				return character2;
			}
		}
	}
	
	public static void main(String[] args) { 
		Character character1 = loadCharacter(sc);
		Weapon left = loadWeapon(sc);
		Weapon right = loadWeapon(sc);
		armCharacter(character1, left, right);
		
		Character character2 = loadCharacter(sc);
		Weapon left2 = loadWeapon(sc);
		Weapon right2 = loadWeapon(sc);
		armCharacter(character2, left2, right2);
		
		Character win = fight(character1, character2);
		System.out.println("Winner: "+win.toString());
	}

}
