package beveragefactory;

import com.tavisca.beveragefactory.BeverageFactoryMain;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeverageFactoryTest {
	
	@Test
	public void singleMenuTest() {
		String [] s = {"Chai"};
		assertEquals(4.0, BeverageFactoryMain.getBillAmount(s),0.0);
	}

	@Test
	public void multipleMenuTest() {
		String [] s = {"Chai","Coffee"};
		assertEquals(9.0, BeverageFactoryMain.getBillAmount(s),0.0);
	}
	
	@Test
	public void multipleMenuIngredirentExclusionTest() {
		String [] s = {"Chai,-sugar","Strawberry Shake,-water"};
		assertEquals(10.0, BeverageFactoryMain.getBillAmount(s),0.0);
	}
}
