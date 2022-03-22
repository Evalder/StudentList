import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTest {

	Student s = new Student();
	
	/* ������������������� ����� �� ��������� � �������������� ���������� */
	@ParameterizedTest
	@Tag("positive")
	@ValueSource(ints = {18, 50, 45, Integer.MAX_VALUE})
	void testWithValueSourse(int param) {
		s.setAge(param);
		assertTrue(s.getAge()>=18);
	}

	/* ������������������� ����� �� ������ */
	@ParameterizedTest
	@Tag("positive")
	@MethodSource("intMethod2")
	void testWithMethodSourse(Integer param) {
		s.setAge(param);
		assertNotEquals(18,s.getAge());
	}	

	/* ����� � ������� ����� ����� */
	static Stream <Integer> intMethod1() {
		return Stream.of(25, 50);
	}

	/* ����� � ���������� �������� */
	static IntStream intMethod2() {
		return IntStream.range(0,17);
	}
	
	/* ������������������� ���� � ���������� ������ �� ����� */
	@ParameterizedTest
	@Tag("positive")	
	@CsvFileSource(resources="name.csv")
	void testWithCsvSource(String param) {
		s.setFirstName(param);
		assertNotNull(s.getFirstName());
	}
	
	/* ������������������� ���� �� ������ ���������� ��� �������� �������� �������� */
	@ParameterizedTest
	@Tag("positive")
	@CsvSource (value = {
		"-2", "0", "18", "34", "50", "55"
	})
	void testAverageAge(int age) {
		assertTrue(age >= 18 && age <= 50);
	}
	
}
