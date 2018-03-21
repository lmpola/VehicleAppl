import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	private App appTest;
	List<Cars> list;

	@Before
	public void setUp() throws Exception {
		appTest = new App();
		Cars car1 = new Cars("CRV", "Green", 2016, new BigDecimal(23845), 8f, 33);
		Cars car2 = new Cars("Escape", "Red", 2017, new BigDecimal(23590), 7.8f, 32);
		Cars car3 = new Cars("Sante Fe", "Grey", 2016, new BigDecimal(24950), 8f, 27);
		Cars car4 = new Cars("CX-5", "Red", 2017, new BigDecimal(21795), 8f, 35);
		Cars car5 = new Cars("Forester", "Blue", 2016, new BigDecimal(22395), 8.4f, 32);
		
		list = new ArrayList<Cars>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
	}

	@Test
	public void test() {
		Cars car1 = new Cars(null, null, 0, null, 0, 0);
		car1.setModel("CRV");
		car1.setColor("Green");
		
		Cars car2 = new Cars(null, null, 0, null, 0, 0);
		car2.setModel("Escape");
		car2.setColor("Red");
		//Comparable, Comparator
		//two interfaces defined by Java --> sort
		List<Cars> list = new ArrayList<Cars>();
		list.add(car1);
		list.add(car2);
		
		Collections.sort(list);
		assertThat(list.get(0).getModel(), is("CRV"));
		assertThat(list.get(1).getModel(), is("Escape"));
	}
	
	@Test
	public void test2() {
		String str1 = "escape";
		String str2 = "Crv";
		
		List<String> list = new ArrayList<String>();
		list.add(str2);
		list.add(str1);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		
		assertThat(list.get(0), is("Crv"));
		assertThat(list.get(1), is("escape"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMain() throws Exception {
		this.setUp();
		appTest.main(null);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCarSortByYear() throws Exception {
		this.setUp(); 
		appTest.carSortByYear(list); 
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCarSortByModel() throws Exception {
		this.setUp();
		appTest.carSortByModel(list);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCarSortByPrice() throws Exception {
		this.setUp();
		appTest.carSortByPrice(list);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCarGasConsumption() throws Exception {
		this.setUp();
		appTest.carGasConsumption(list,1200);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testRandomCar() throws Exception {
		this.setUp();
		appTest.randomCar(list);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCarMPGByYear() throws Exception {
		this.setUp();
		appTest.carMPGByYear(list);
	}

}
