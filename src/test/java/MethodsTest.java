import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class MethodsTest {
	/* Объект тестового класса Student */
	private Student s = new Student();
	
	/* Проверка возраста студента, входящего в диапазон */
	@Test
	@Tag("positive")
	void StudentAgeCorrectCheck1() {
		int age = 30;
		s.setAge(age);
		int expectedAge = 30;
		int actualsAge = s.getAge();
		assertEquals(expectedAge, actualsAge);
	}
	
	@Test
	@Tag("positive")
	void StudentAgeCorrectCheck2() {
		int age = 50;
		s.setAge(age);
		int expectedAge = 50;
		int actualsAge = s.getAge();
		assertEquals(expectedAge, actualsAge);
	}

	/* Проверка возраста студента, выходящего за диапазон */
	@Test
	@Tag("negative")
	void StudentAgeUncorrectCheck1() {
		int age = 51;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();
		assertNotEquals(expectedAge, actualsAge);
	}	

	/* Проверка возраста студента, с отрицательным значением */
	@Test
	@Tag("negative")
	void StudentAgeUncorrectCheck2() {
		int age = -20;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();
		assertNotEquals(expectedAge, actualsAge);
	}	
	
	/* Проверка фамилии студента */
	@Test
	@Tag("positive")
	void StudentSecondNameCorrectCheck1() {
		String secondName = "Сидоров-Никитин";
		s.setSecondName(secondName);
		String expectedSecondName = "Сидоров-Никитин";
		String actualsSecondName = s.getSecondName();
		assertEquals(expectedSecondName, actualsSecondName);
	}
	
	/* Проверка ввода номера сценария */
	@Test
	@Tag("negative")
	void ScenarioUncorrectCheck1() {
		int userInput = 10;
		int expectedInput = 1;
		int actualsInput = userInput;
		assertNotEquals(expectedInput, actualsInput);
	}	

	
}
