package kobietyDoKodu;

import java.util.Date;

public class Cat {
	private String name;
	private Date birthDate;
	private Float weight;
	private String ownerName;
	
	public Cat() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String introduceYourself() {
		return "My name is " + name + ", I was born at " + birthDate + ", I weight " + weight + " kg and my owner's name is " + ownerName + " :)";
	}
}
