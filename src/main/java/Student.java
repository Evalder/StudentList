
public class Student {
	String firstName, secondName;
	int age;
	
	/* Создание конструктора класса Student */
	public Student(String firstName, String secondName, int age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	/* свойство возвращения firstName */
	public String getFirstName() {
		return firstName;
	}

	/* свойство задания firstName */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* свойство возвращения secondName */
	public String getSecondName() {
		return secondName;
	}

	/* свойство задания secondName */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}	
	
	/* свойство возвращения age */
	public int getAge() {
		return age;
	}

	/* свойство задания age */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* Создание пустого конструктора класса Student */
	public Student() {
		
	}
}
