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
	
	@DataProvider (name = "firstNamesProvider")
	public Object [][] firstNamesProvider () {
		 return new Object[][] {
				 {"Petr", new Student("Petr","Nikitin",28)},
				 {"Igor", new Student("Igor","Smakotin",24)}
			};
		}

@Test (dataProvider = "firstNamesProvider")
public void firstName(String name, Student t) {
	Assert.assertEquals(name,t.getFirstName());
}
 
}

}