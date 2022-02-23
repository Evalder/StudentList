import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	
	static Scanner Scan = new Scanner(System.in);
	
	/* Метод для запроса числовых данных */
	public static int IntScanner() {
		int Z;
		do {
			System.out.println("Введите целое число в интервале от 18 до 50 включительно: ");
			Z = Scan.nextInt();
				if ((Z < 18) || (Z > 50)) {
				Z = 18;
				}	
	    } while ((Z < 18) || (Z > 50));
		return(Z);
		}
	
	/* Метод для запроса текстовых данных */
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
	
	/* Метод для запуска определённого сценария программы */
	public static int UserInputScanner() {
		int Z;
		do {
			Z = Scan.nextInt();
				if ((Z < 1) || (Z > 4)) {
				System.out.println("Неверное значение, введите 1, 2, 3, 4");
				}	
	    } while ((Z < 1) || (Z > 4));
		return(Z);
		}
	
	/* Метод для определения min, max, avg возраста */
	public static void AgeActions(ArrayList<Student> studList) {
		int min = 0, max = 0, avg = 0;
		if (studList.size() < 1) {
			System.out.println("Отсутствуют данные по студентам");
			return;
		}
		min = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			if (studList.get(i).age < min) {
				min = studList.get(i).age;	/* Доступ к i-тому элементу */
			}
		}
		max = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			if (studList.get(i).age > max) {
				max = studList.get(i).age;	/* Доступ к i-тому элементу */
			}
		}
		avg = studList.get(0).age;
		for (int i = 1; i < studList.size(); i++) {
			avg += studList.get(i).age;		/* Добавляет значение к самой переменной */
			}
		avg /= studList.size();				/* Делим значение переменной */
		System.out.println("Минимальный возраст: " + min + "\nМаксимальный возраст: " + max + "\nСредний возраст: " + avg);
		}

}