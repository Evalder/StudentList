
public class Student {
	String firstName, secondName;
	int age;
	
	/* Class Student */
	public Student(String firstName, String secondName, int age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	/* Getting firstName */
	public String getFirstName() {
		return firstName;
	}

	/* Setting firstName */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* Getting secondName */
	public String getSecondName() {
		return secondName;
	}

	/* Setting secondName */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}	
	
	/* Getting age */
	public int getAge() {
		return age;
	}

	/* Setting age */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* Default constructor of Class Student */
	public Student() {
		
	}
}
