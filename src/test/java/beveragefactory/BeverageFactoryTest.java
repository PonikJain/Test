package beveragefactory;

import com.tavisca.beveragefactory.BeverageFactoryMain;
import com.tavisca.beveragefactory.cafe.CafeMenu;
import com.tavisca.beveragefactory.cafe.MenuIngradientPriceList;
import com.tavisca.beveragefactory.exceptions.InvalidIngredientException;
import com.tavisca.beveragefactory.exceptions.InvalidOrderException;

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
	
	@Test
	public void invalidOrderTest() {
		String [] s = {"Mojito,-sugar","Apple Shake,-water"};
		assertEquals(7.0, BeverageFactoryMain.getBillAmount(s),0.0);
	}
	
	@Test
	public void allInvalidOrderTest() {
		String [] s = {"Juice,-sugar","Apple Shake,-water"};
		assertEquals(0.0, BeverageFactoryMain.getBillAmount(s),0.0);
	}
	
	@Test(expected = InvalidOrderException.class)
	public void invalidMenuTest() throws InvalidOrderException {
		CafeMenu.getMenu().getBeveragePrice("Coke");
	}
	
	@Test
	public void validMenuTest() throws InvalidOrderException {
		assertEquals(4.0,CafeMenu.getMenu().getBeveragePrice("Chai"),0.0);
	}
	
	@Test
	public void validIngradientTest() throws InvalidIngredientException {
		assertEquals(0.5,MenuIngradientPriceList.getPriceList().getPrice("sugar"),0.0);
	}
	
	@Test(expected = InvalidIngredientException.class)
	public void inValidIngradientTest() throws InvalidIngredientException {
		MenuIngradientPriceList.getPriceList().getPrice("brown sugar");
	}
}
