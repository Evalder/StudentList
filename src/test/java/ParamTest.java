import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTest {

	Student s = new Student();
	
	@ParameterizedTest
	@Tag("positive")
	@ValueSource(ints = {18, 50, 45, Integer.MAX_VALUE})
	void testWithValueSourse(int param) {
		s.setAge(param);
		assertTrue(s.getAge()>=18);
	}
	
	@ParameterizedTest
	@Tag("positive")
	@MethodSource("intMethod")
	void testWithMethodSourse(Integer param) {
		s.setAge(param);
		assertNotEquals(18,s.getAge());
	}	

	static IntStream intMethod() {
		return IntStream.range(0,17);
	}
	
}
