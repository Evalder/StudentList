import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class MethodsTest {
	/* ������ ��������� ������ Student */
	private Student s = new Student();
	
	/* �������� �������� ��������, ��������� � �������� */
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

	/* �������� �������� ��������, ���������� �� �������� */
	@Test
	@Tag("negative")
	void StudentAgeUncorrectCheck1() {
		int age = 51;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();
		assertNotEquals(expectedAge, actualsAge);
	}	

	/* �������� �������� ��������, � ������������� ��������� */
	@Test
	@Tag("negative")
	void StudentAgeUncorrectCheck2() {
		int age = -20;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();
		assertNotEquals(expectedAge, actualsAge);
	}	
	
	/* �������� ������� �������� */
	@Test
	@Tag("positive")
	void StudentSecondNameCorrectCheck1() {
		String secondName = "�������-�������";
		s.setSecondName(secondName);
		String expectedSecondName = "�������-�������";
		String actualsSecondName = s.getSecondName();
		assertEquals(expectedSecondName, actualsSecondName);
	}
	
	/* �������� ����� ������ �������� */
	@Test
	@Tag("negative")
	void ScenarioUncorrectCheck1() {
		int userInput = 10;
		int expectedInput = 1;
		int actualsInput = userInput;
		assertNotEquals(expectedInput, actualsInput);
	}	

	
}
