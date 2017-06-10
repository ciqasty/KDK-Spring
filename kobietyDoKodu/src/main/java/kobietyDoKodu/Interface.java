package kobietyDoKodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interface {
	static Scanner userInput = new Scanner(System.in);
	public static final SimpleDateFormat catBDateformat = new SimpleDateFormat("yyyy.MM.dd");
	public static final String dateRegEx = "([0-1][0-9]{3}||[2][0][0-1][0-7])\\.([0][1-9]||[1][0-2])\\.([0-2][0-9]||[3][0-1])"; // YYYY.MM.DD
	public static final String weightRegEx = "[0-9]{1,}\\.{0,1}[0-9]*"; // could use weight limitation
	
	public static void main(String[] args) {
		boolean quit = false;
		CatDAO catsCollection = new CatDAO();
		do {
			showMainMenu();
			int choice = -1;
			if (userInput.hasNextInt()) choice = getUserChoice();
			switch (choice) {
			case 1:
				Cat kitten = new Cat();
				addNewCat(kitten);
				catsCollection.addCat(kitten);
				System.out.println("New cat was added to collection");
				break;
			case 2:
				catsCollection.listCats();
				do {
					System.out.println("Choose cat's number for more information, or 0 to go to main menu: ");
					if (userInput.hasNextInt()) choice = getUserChoice();
					if (choice !=0) {
						try {
							System.out.println(catsCollection.getCat(choice-1).introduceYourself());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("There is no cat with this number.");
						} finally {
							choice = 0;
						}
					}
				} while (choice != 0);
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Invalid choice, choose again.");
				break;
			}
		} while (!quit);
	}
	
	public static String getUserInput() {
		return userInput.nextLine().trim();
	}
	
	public static Integer getUserChoice() {
		return Integer.parseInt(getUserInput());
	}
	
	public static void showMainMenu() {
		System.out.println("*   *   *MAIN MENU*   *   *");
		System.out.println("[1] Add a cat");
		System.out.println("[2] Print cat's data");
		System.out.println("[0] Quit");
		System.out.print("Your choice: ");
	}
	public static Cat addNewCat(Cat kitten) {	
		System.out.println("Type cat name: ");
		kitten.setName(getUserInput());
		System.out.println("Type owner's name: ");
		kitten.setOwnerName(getUserInput());
		//DATE
		Pattern datePattern = Pattern.compile(dateRegEx);
		Date catBDate = null;
		Matcher dateMatcher = null;
		do {
			System.out.println("Please write cat's birth date in format YYYY.MM.DD: ");
			String bDayInput = getUserInput();
			dateMatcher = datePattern.matcher(bDayInput);
			if (dateMatcher.matches()) {
				try {
					catBDate = catBDateformat.parse(bDayInput);
					kitten.setBirthDate(catBDate);
				} catch (ParseException pe) {
					System.out.println("Something's wrong, please try again.");
				}	
			}
			else {
				System.out.println("Date format was not correct, or your cat is from the future, try again :).");
			}
				
		} while (!dateMatcher.matches());
		//WEIGHT
		Pattern weightPattern = Pattern.compile(weightRegEx);
		Float weight = null;
		Matcher weightMatcher = null;
		do {
			System.out.println("Please input cat's weight, use . as separator for decimal place: ");
			String weightInput = getUserInput();
			weightMatcher = weightPattern.matcher(weightInput);
			if (weightMatcher.matches()) {
				weight = Float.parseFloat(weightInput);
				kitten.setWeight(weight);
			}
			else {
				System.out.println("Something's wrong with number you provided.");
			}
		} while (!weightMatcher.matches());
		return kitten;
	}

}
