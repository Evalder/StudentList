import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTest {

	Student s = new Student();
	Student s1 = new Student();
	Student s2 = new Student();
	
	/* Параметризированные тесты из источника с фиксированными значениями */
	@ParameterizedTest
	@Tag("positive")
	@ValueSource(ints = {18, 50, 45, Integer.MAX_VALUE})
	void testWithValueSourse(int param) {
		s.setAge(param);
		assertTrue(s.getAge()>=18);
	}

	/* Параметризированные тесты из метода */
	@ParameterizedTest
	@Tag("positive")
	@MethodSource("intMethod2")
	void testWithMethodSourse(Integer param) {
		s.setAge(param);
		assertNotEquals(18,s.getAge());
	}	

	/* Тесты с данными через поток */
	static Stream <Integer> intMethod1() {
		return Stream.of(25, 50);
	}

	/* Тесты с диапазоном значений */
	static IntStream intMethod2() {
		return IntStream.range(0,17);
	}
	
	/* Параметризированный тест с источником данных из файла
	@ParameterizedTest
	@Tag("positive")	
	@CsvFileSource(resources="name.csv")
	void testWithCsvSource(String param) {
		s.setFirstName(param);
		assertNotNull(s.getFirstName());
	}
	*/
	
	/* Параметризированный тест из списка аргументов для среднего значения возраста */
	@ParameterizedTest
	@Tag("positive")
	@CsvSource (value = {
		"-2", "0", "18", "34", "50", "55"
	})
	void testAverageAge(int age) {
		assertTrue(age >= 18 && age <= 50);
	}
	
	/* Динамические тесты */
	@TestFactory
	@Tag("negative")
	Collection <DynamicTest> dynamicTestSetAge()
	{
		s1.setAge(25);
		s2.setAge(50);
		return (Collection<DynamicTest>) Arrays.asList(
				DynamicTest.dynamicTest("dTest1", ()->assertEquals(25,s1.getAge())),
				DynamicTest.dynamicTest("dTest2", ()->assertEquals(50,s2.getAge()))
				);
	}
	
	/* Динамические тесты для геттеров getFirstName(), getSecondName(), getAge() */
	@TestFactory
	Stream<DynamicTest> dynamicTestsGetters() {

	    Student[] studentsData = {new Student("Николай", "Егоров", 33),
	    						  new Student("Семён", "Петров", 36),
	    						  new Student("Андрей", "Никитин", 43),
	    						  new Student("Анна", "Дегтярёва", 37),
	    						  new Student("Полина", "Назарова", 22)};
	    String[] firstNameTest = {"Николай", "Семён", "Андрей", "Анна", "Полина"};
	    String[] secondNameTest = {"Егоров", "Петров", "Никитин", "Дегтярёва", "Назарова"};
	    Integer[] ageTest = {33, 36, 43, 37, 22};

	    List <DynamicTest> dynamicTests = new ArrayList<DynamicTest>();

	    for (int i = 0; i < studentsData.length; i++) {
	        int k = i;
	        DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", 
	        		() -> {assertEquals(firstNameTest[k], studentsData[k].getFirstName());
	        });
	        DynamicTest dynamicTestSecondName = DynamicTest.dynamicTest("DynamicTest getSecondName(" + secondNameTest[k] + ")",
	        		() -> {assertEquals(secondNameTest[k], studentsData[k].getSecondName());
	        });
	        DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")",
	        		() -> {assertEquals(ageTest[k], studentsData[k].getAge());
	        });
	        dynamicTests.add(dynamicTestFirstName);
	        dynamicTests.add(dynamicTestSecondName);
	        dynamicTests.add(dynamicTestAge);
	    }
	    return dynamicTests.stream();
	}
	
	/* Динамические тесты с контейнерами */
	@TestFactory
	Stream<DynamicNode> testDynamicContainerWithNamesAndAge() {
		List<Student> n = new ArrayList<Student>();
		n.add(new Student("Andrey", "Morozov", 22));
		n.add(new Student("Petr", "Romanov", 41));
		n.add(new Student("Alex", "Egorov", 31));
		n.add(new Student("Nikita", "Pavlov", 27));
		n.add(new Student("Nikolay", "Volodin", 19));
		
		List<DynamicNode> cont = new ArrayList<>();
		List<DynamicTest> cont1 = new ArrayList<>();
		List<DynamicTest> cont2 = new ArrayList<>(); 
		List<DynamicTest> cont3 = new ArrayList<>();
		
		for(int i=0; i < n.size(); i++) {
			String FirstName = n.get(i).getFirstName();
			cont1.add(DynamicTest.dynamicTest("firstNameTest"+i,
					() -> {assertTrue(FirstName.length() >= 0);}));
	    }
		cont.add(dynamicContainer("FirstNames",cont1.stream()));
		
		for(int i=0; i < n.size(); i++) {
			String SecondName = n.get(i).getSecondName();
			cont2.add(DynamicTest.dynamicTest("secondNameTest"+i,
					() -> {assertTrue(!SecondName.isEmpty());}));
	    }
		cont.add(dynamicContainer("SecondNames",cont2.stream()));
	  	
	  	for(int i=0; i < n.size(); i++) {  
	  		int age = n.get(i).getAge();
	  		cont3.add(DynamicTest.dynamicTest("ageTest"+i,
	  				() -> {assertTrue(age >= 18 && age <= 50);}));
	    }
	  	cont.add(dynamicContainer("Age",cont3.stream()));
	 
	return cont.stream();
	}
	
}
