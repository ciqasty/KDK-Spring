package kobietyDoKodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Interface {
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		Cat kitten = new Cat();
		SimpleDateFormat catBDateformat = new SimpleDateFormat("yyyy.MM.dd");
		
		System.out.println("Type cat name: ");
		kitten.setName(getUserInput());
		System.out.println("Type owner's name: ");
		kitten.setOwnerName(getUserInput());
		Date catBDate = null;
		do {
			System.out.println("Type cat's birthday date in format YYYY.MM.DD: ");
			try {
				catBDate = catBDateformat.parse(getUserInput());
				kitten.setBirthDate(catBDate);
			} catch (ParseException e) {
				System.out.println("Wrong date format, please try again.");
			}
		} while (catBDate == null);
		
		Float catWeight = null;
		do {
			System.out.println("Type cat's weight in kg: ");
			try {
				catWeight = Float.valueOf(getUserInput());
				kitten.setWeight(catWeight);
			} catch (NumberFormatException e) {
				System.out.println("Wrong weight specified, please try again.");
			}
		} while (catWeight == null);
		System.out.println(kitten.introduceYourself());
	}
	
	public static String getUserInput() {
		return userInput.nextLine().trim();
	}

}
