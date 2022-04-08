import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderTestNG {

@DataProvider (name = "StudentsData")
	public static Object [] firstNamesProvider () {
		return new Object[] {
			new Student("Petr","Nikitin",28),
			new Student("Igor","Smakotin",24),
			new Student("Alina","Semenova",25)
			};
		}

@DataProvider (name = "StudentsAge")
public Object [][] ageProvider () {
	 return new Object[][] {
			 {(28), new Student("Petr","Nikitin",28)},
			 {(24), new Student("Igor","Smakotin",24)},
			 {(25),new Student("Alina","Semenova",25)}
		};
	}

	private Student u;
	private int age;

	@Factory(dataProvider = "StudentsData")
	public DataProviderTestNG(Student u) {
		this.u = u;
		age = u.getAge();
	}

	@Test (dataProvider = "StudentsData")
	public void firstName() {
		Assert.assertNotNull(u.getFirstName());
	}
	
	@Test (dataProvider = "StudentsData")
	public void age() {
		Assert.assertEquals(age, u.getAge());
	}
	
}
