import java.util.ArrayList;

import org.testng.AssertJUnit;
import org.testng.annotations.*;

public class ParamTestNG {
	
	Student s = new Student();
	ArrayList <Student> arr;

/* Initialization of collection */
@BeforeClass()
public void setUp() {
	arr = new ArrayList<Student>();
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

}
