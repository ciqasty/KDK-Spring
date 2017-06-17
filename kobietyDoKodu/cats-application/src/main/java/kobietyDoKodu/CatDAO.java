package kobietyDoKodu;

import java.util.ArrayList;
import java.util.List;

public class CatDAO {

	private List<Cat> cats;
	
	public CatDAO() {
		this.cats = new ArrayList<Cat>();
	}
	
	public void addCat(Cat cat) {
		this.cats.add(cat);
	}
	
	public Cat getCat(int index) {
		return cats.get(index);
	}
	
	public void listCats() {
		int number = 0;
		System.out.println("Listing all cats in collection.");
		for (Cat cat : cats) {
			number++;
			System.out.println("Nr " + number + "   " + cat.getName());
		}
	}
	
}
