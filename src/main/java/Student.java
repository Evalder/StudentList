
public class Student {
	String firstName, secondName;
	int age;
	
	/* �������� ������������ ������ Student */
	public Student(String firstName, String secondName, int age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	/* �������� ����������� firstName */
	public String getFirstName() {
		return firstName;
	}

	/* �������� ������� firstName */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* �������� ����������� secondName */
	public String getSecondName() {
		return secondName;
	}

	/* �������� ������� secondName */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}	
	
	/* �������� ����������� age */
	public int getAge() {
		return age;
	}

	/* �������� ������� age */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* �������� ������� ������������ ������ Student */
	public Student() {
		
	}
}
