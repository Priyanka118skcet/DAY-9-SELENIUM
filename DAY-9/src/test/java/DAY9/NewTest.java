package DAY9;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
public class NewTest {
	
	int c;
	
  @Test(dataProvider = "dp")
  public void add(Integer n, Integer m) {
	    c=n+m;
		System.out.println("Addition :"+c);
		 
  }
  
  @Test(dataProvider = "dp")
  public void sub(Integer n, Integer m) {
	    c=n-m;
		System.out.println("Substration :"+c);
		 
  }
  
  @Test(dataProvider = "dp")
  public void mul(Integer n, Integer m) {
	    c=n*m;
		System.out.println("Multiplication :"+c);
		 
  }
  
  @Test(dataProvider = "dp")
  public void div(Integer n, Integer m) {
	    c=n/m;
		System.out.println("Division :"+c);
		 
  }
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, 5 },
      new Object[] { 2, 6 },
    };
  }
}
