import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String firstName, secondName;		/*  */
		int age, userInput, min, max, avg;
		
		/* �������� ��������� ��� �������� ������ Student */
		ArrayList<Student> studList = new ArrayList<Student>();
		
		/* �������� ���������� ������ Student */
		Student stud = new Student();
		stud = new Student("Egor", "Semenov", 20);
		studList.add(stud);
		stud = new Student("Andrey", "Nikitin", 22);
		studList.add(stud);
		
		do {
			System.out.println("\nChoose an option: \n1 - Add a student. \n2 - �������� ���� ���������. \n3 - Calculate min, max and avg age. \n4 - ������������� �������� ������ �� ���������. \n5 - Exit.");
			userInput = Methods.UserInputScanner();
			
			switch (userInput) {
				case 1:
					/* Adding new student data */
					System.out.println("\nEnter name: ");
					firstName = Methods.StrScanner();
					System.out.println("Enter surname: ");
					secondName = Methods.StrScanner();		
					System.out.println("Enter age: ");
					age = Methods.IntScanner();
					
					/* �������� ���������� ������ Student */
					stud = new Student(firstName, secondName, age);
					
					/* ���������� ��������� ������� ��������� � ���������� ���� Student */
					studList.add(stud);
					break;
				case 2:
					/* ������ ������ ��������� */
					if (studList.size() < 1) {
						System.out.println("����������� ������ �� ���������");
						break;
					}

					System.out.println("���" + "\t" + "�������" + "\t" + "�������");
					for (Student temp : studList) {
					    System.out.println(temp.firstName + "\t" + temp.secondName + "\t" + temp.age);
					}
					break;
				case 3:
					/* ���������� min, max, avg �������� */
					Methods.AgeActions(studList);
					break;
				case 4:	
					/* ��������� �������� ������ */
					/* �������� ���������� ������ Student */
					stud = new Student("����", "��������", 20);
					studList.add(stud);
					stud = new Student("�����", "������", 22);
					studList.add(stud);
					break;
				case 5:
					/* Exiting */
					System.exit(0);
					
			}
		} while(true);
	}

}
