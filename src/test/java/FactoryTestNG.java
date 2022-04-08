import java.util.ArrayList;

import org.junit.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTestNG {

Student s = new Student();
ArrayList <Student> arr;

/* Simple age test 1 */
@Test(groups= {"SimpleTestAge"})
public void testAge1() {
	int age = 44;
	s.setAge(age);
	int expectedAge = 44;
	AssertJUnit.assertEquals(expectedAge,s.getAge());
}

/* Simple firstName test 1 */
@Test(groups= {"SimpleTestFirstName"})
public void testFirstName1() {
	String fname = "Ivan";
	s.setFirstName(fname);
	String expectedFirstName = "Ivan";
	AssertJUnit.assertEquals(expectedFirstName,s.getFirstName());
}

/* Simple secondName test 1 */
@Test(groups= {"SimpleTestSecondName"})
public void testSecondName1() {
	String sname = "Ivanov";
	s.setSecondName(sname);
	String expectedSecondName = "Ivanov";
	AssertJUnit.assertEquals(expectedSecondName,s.getSecondName());
}

@Factory
public Object[] TestFactory() {
		return new Object [] {new FirstNameTest()};		
	}

class FirstNameTest {
	
	@DataProvider (name = "firstNamesProvider", parallel=true)
	public Object [][] firstNamesProvider () {
		 return new Object[][] {
				 {"Petr", new Student("Petr","Nikitin",28)},
				 {"Igor", new Student("Igor","Smakotin",24)},
				 {"Alina", new Student("Alina","Ivanova",23)},
				 {"Elena", new Student("Elena","Markova",26)}
			};
		}

/* With parallel streams */	
@Test (dataProvider = "firstNamesProvider", threadPoolSize=4)
public void firstName(String name, Student t) {
	long id = Thread.currentThread().getId();
	System.out.println("thread=" + id);
	Assert.assertEquals(name,t.getFirstName());
}

@DataProvider (name = "secondNamesProvider", parallel=true)
public Object [][] secondNamesProvider () {
	 return new Object[][] {
			 {"Nikitin", new Student("Petr","Nikitin",28)},
			 {"Smakotin", new Student("Igor","Smakotin",24)},
			 {"Ivanova", new Student("Alina","Ivanova",23)},
			 {"Markova", new Student("Elena","Markova",26)}
		};
	}

/* With parallel streams */	
@Test (dataProvider = "secondNamesProvider", threadPoolSize=4)
public void secondName(String sname, Student t) {
	long id = Thread.currentThread().getId();
	System.out.println("thread=" + id);
	Assert.assertEquals(sname,t.getSecondName());
}

@DataProvider (name = "ageProvider", parallel=true)
public Object [][] ageProvider () {
	 return new Object[][] {
			 {28, new Student("Petr","Nikitin",28)},
			 {24, new Student("Igor","Smakotin",24)},
			 {23, new Student("Alina","Ivanova",23)},
			 {26, new Student("Elena","Markova",26)}
		};
	}

/* With parallel streams */	
@Test (dataProvider = "ageProvider", threadPoolSize=4)
public void age(int age, Student t) {
long id = Thread.currentThread().getId();
System.out.println("thread=" + id);
Assert.assertEquals(age,t.getAge());
}

}

}