package kobietyDoKodu;

import java.util.Scanner;

public class Interface {
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		Cat kitten = new Cat();
		
		System.out.println("Type cat name: ");
		kitten.setName(getUserInput());
		System.out.println("Type owner's name: ");
		kitten.setOwnerName(getUserInput());
		
		System.out.println(kitten.introduceYourself());
	}
	
	public static String getUserInput() {
		return userInput.nextLine().trim();
	}

}
