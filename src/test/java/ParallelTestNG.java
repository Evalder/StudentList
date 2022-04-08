import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.Tag;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTestNG {
	/* ������ ��������� ������ Student */
	private Student s = new Student();
	
/* Checking age */
@Test
void StudentAgeCorrectCheck1() {
	int age = 30;
	s.setAge(age);
	int expectedAge = 30;
	int actualsAge = s.getAge();
	long id = Thread.currentThread().getId();
	System.out.println("thread=" + id);
	assertEquals(expectedAge, actualsAge);
}
	
@Test
void StudentAgeCorrectCheck2() {
	int age = 32;
	s.setAge(age);
	int expectedAge = 32;
	int actualsAge = s.getAge();
	long id = Thread.currentThread().getId();
	System.out.println("thread=" + id);
	assertEquals(expectedAge, actualsAge);
}	

@Test
void StudentAgeCorrectCheck3() {
	int age = 35;
	s.setAge(age);
	int expectedAge = 35;
	int actualsAge = s.getAge();
	long id = Thread.currentThread().getId();
	System.out.println("thread=" + id);
	assertEquals(expectedAge, actualsAge);
}
	
}
