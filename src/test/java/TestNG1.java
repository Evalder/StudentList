import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import java.util.ArrayList;

import org.testng.annotations.*;

public class TestNG1 {
	
	Student s = new Student();
	ArrayList <Student> arr;
	
/* Initialization of collection */
@BeforeClass()
public void setUp() {
	arr = new ArrayList<Student>();
}

/* Clear data from collection */
@AfterClass()
public void teamDown() {
	arr.clear();
}

/* Simple age test 1 */
@Test(groups= {"SimpleTest"})
 public void testAge1() {
	int age = 44;
	s.setAge(age);
	int expectedAge = 44;
	AssertJUnit.assertEquals(expectedAge,s.getAge());
}
 
 /* Simple age test 2 */
@Test(groups = {"SimpleTest"})
 public void testAge2() {
	int age = 23;
	s.setAge(age);
	int expectedAge = 23;
	AssertJUnit.assertEquals(expectedAge,s.getAge());
}

/* Test array with student's data is empty */
@Test(priority = 0, groups = {"TestCollection"})
public void testEmptyCollection() {
	AssertJUnit.assertTrue(arr.isEmpty());
}

/* Test number of students in array */
@Test(priority = 1, groups = {"TestCollection"})
public void testStudentsDataCollection() {
	int k = arr.size();
	arr.add(new Student("Andrew", "Ziborov", 25));
	AssertJUnit.assertEquals(k+1,arr.size());
}

/* Test array with student's data is not empty */
@Test(priority = 2, groups = {"TestCollection"}, dependsOnMethods = {"testStudentsDataCollection"})
public void testIsNotEmptyCollection() {
	AssertJUnit.assertFalse(arr.isEmpty());
}

/* Test array nullpointer exception */
@Test(priority = 0, groups = {"TestCollection"}, expectedExceptions = {NullPointerException.class})
public void testNullPointerCollection() {
	arr = null;
	int size = arr.size();
}

/* Parametrized tests 

@Test
@Parameters({"age", "firstName", "secondName"}) {
	public void params(@Optional("0")int age, @Optional("null")String firstName, @Optional("null")String secondName) {
		Student p = new Student();
		p.setAge(age);
		p.setFirstName(firstName);
		p.setSecondName(secondName);
		assertEquals("Andrew", p.getFirstName());
		
	}
}
 */
@DataProvider(name = "Data")
	public static Object[][] getData()	{
	return new Object[][] {
		{"Boris", "Egorov"},
		{"Sergey", "Ivanov"},
		{"Mihail", "Semenov"},
};
}

@Test(dataProvider="Data")
void testNames(String input, String expectedName) {
	Student t = new Student();
	t.setFirstName(input);
	String actual = t.getFirstName();
	AssertJUnit.assertEquals(expectedName, actual);
}

}
