import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTestNG {
	
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
 
}

}