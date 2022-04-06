import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	
	static Scanner Scan = new Scanner(System.in);
	
	/* ����� ��� ������� �������� ������ */
	public static int IntScanner() {
		int Z;
		do {
			System.out.println("Enter an age from 18 to 50: ");
			Z = Scan.nextInt();
				if ((Z < 18) || (Z > 50)) {
				Z = 18;
				}	
	    } while ((Z < 18) || (Z > 50));
		return(Z);
		}
	
	/* ����� ��� ������� ��������� ������ */
	public static String StrScanner() {
		String Z;
		do {
			Z = Scan.next();
				Z = Z.toLowerCase();
				Z = Z.substring(0, 1).toUpperCase() + Z.substring(1);	
	    } while ((Z == null) || (Z == "")) ;
		String [] tempArray = Z.split("-");
		if (tempArray.length > 1) {
			Z = "";
			for (int i = 0; i < tempArray.length; i++) {
			Z += tempArray[i].substring(0, 1).toUpperCase() + tempArray[i].substring(1);
				if (i < tempArray.length - 1) {
					Z += "-";
				}
			}
		}
		return(Z);
		}
	
	/* ����� ��� ������� ������������ �������� ��������� */
	public static int UserInputScanner() {
		int Z;
		do {
			Z = Scan.nextInt();
				if ((Z < 1) || (Z > 5)) {
				System.out.println("�������� ��������, ������� 1, 2, 3, 4, 5");
				}	
	    } while ((Z < 1) || (Z > 4));
		return(Z);
		}
	
	/* ����� ��� ����������� min, max �������� */
	public static void AgeActions(ArrayList<Student> studList) {
		int min = 0, max = 0, avg = 0;
		if (studList.size() < 1) {
			System.out.println("����������� ������ �� ���������");
			return;
		}
		min = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			if (studList.get(i).age < min) {
				min = studList.get(i).age;	/* ������ � i-���� �������� */
			}
		}
		max = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			if (studList.get(i).age > max) {
				max = studList.get(i).age;	/* ������ � i-���� �������� */
			}
		}
		avg = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			avg += studList.get(i).age;		/* ��������� �������� � ����� ���������� */
			}
		avg /= studList.size();				/* ����� �������� ���������� */
		System.out.println("����������� �������: " + min + "\n������������ �������: " + max);
		}
	
	/* ����� ��� ����������� avg �������� */
	public static int avgAge(ArrayList<Student> studList) {
		int avg = 0;
		if (studList.size() < 1) {
			System.out.println("����������� ������ �� ���������");
			return 0;
		}
		avg = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			avg += studList.get(i).age;		/* ��������� �������� � ����� ���������� */
			}
		avg /= studList.size();				/* ����� �������� ���������� */
		return avg;
		}

}