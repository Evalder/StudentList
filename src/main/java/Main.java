import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String firstName, secondName;		/* Буферные переменные */
		int age, userInput, min, max, avg;
		
		/* Создание коллекции для объектов класса Student */
		ArrayList<Student> studList = new ArrayList<Student>();
		
		do {
			System.out.println("\nВыберите действие: \n1 - Добавить студента. \n2 - Показать всех студентов. \n3 - Определить min, max и avg возраст. \n4 - Выйти из программы.");
			userInput = Methods.UserInputScanner();
			
			switch (userInput) {
				case 1:
					/* Запрос данных от пользователя */
					System.out.println("\nВведите имя: ");
					firstName = Methods.StrScanner();
					System.out.println("Введите фамилию: ");
					secondName = Methods.StrScanner();		
					System.out.println("Введите возраст: ");
					age = Methods.IntScanner();
					
					/* Создание экземпляра класса Student */
					Student stud = new Student(firstName, secondName, age);
					
					/* Наполнение коллекции данными студентов с переменной типа Student */
					studList.add(stud);
					break;
				case 2:
					/* Печать списка студентов */
					if (studList.size() < 1) {
						System.out.println("Отсутствуют данные по студентам");
						break;
					}

					System.out.println("Имя" + "\t" + "Фамилия" + "\t" + "Возраст");
					for (Student temp : studList) {
					    System.out.println(temp.firstName + "\t" + temp.secondName + "\t" + temp.age);
					}
					break;
				case 3:
					/* Определеие min, max, avg возраста */
					Methods.AgeActions(studList);
					break;
				case 4:
					/* Закрыть программу */
					System.exit(0);
					
			}
		} while(true);
	}

}
