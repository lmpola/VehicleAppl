import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * @author muralipola
 *
 */
public class Tests {
	
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

	
}
