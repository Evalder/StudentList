import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String firstName, secondName;		/* �������� ���������� */
		int age, userInput, min, max, avg;
		
		/* �������� ��������� ��� �������� ������ Student */
		ArrayList<Student> studList = new ArrayList<Student>();
		
		do {
			System.out.println("\n�������� ��������: \n1 - �������� ��������. \n2 - �������� ���� ���������. \n3 - ���������� min, max � avg �������. \n4 - ����� �� ���������.");
			userInput = Methods.UserInputScanner();
			
			switch (userInput) {
				case 1:
					/* ������ ������ �� ������������ */
					System.out.println("\n������� ���: ");
					firstName = Methods.StrScanner();
					System.out.println("������� �������: ");
					secondName = Methods.StrScanner();		
					System.out.println("������� �������: ");
					age = Methods.IntScanner();
					
					/* �������� ���������� ������ Student */
					Student stud = new Student(firstName, secondName, age);
					
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
					/* ������� ��������� */
					System.exit(0);
					
			}
		} while(true);
	}

}
