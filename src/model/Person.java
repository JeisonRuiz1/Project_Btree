package model;

public class Person {
	// nomreb , id , de quien es hijo, fecha nacimiento
	private int id;
	private String name;
	private String dateOfBirth;

	public Person(int id, String name, String dateOfBirth){
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
