import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author muralipola
 *
 */
class Cars implements Comparable<Cars>{
	
	private String model;
	private String color;
	private int year;
	private BigDecimal price;
	private float tccRating;
	private int mpg;
	
	
	/**
	 * @param model
	 * @param color
	 * @param year
	 * @param price
	 * @param tccRating
	 * @param mpg
	 */
	public Cars(String model, String color, int year, BigDecimal price, float tccRating, int mpg) {
		super();
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
		this.tccRating = tccRating;
		this.mpg = mpg;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public float getTccRating() {
		return tccRating;
	}
	public void setTccRating(float tccRating) {
		this.tccRating = tccRating;
	}
	public int getMpg() {
		return mpg;
	}
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	
	@Override
	public int compareTo(Cars model) {
		// +ve number -> greater, 0 -> equal , -ve number -> lesser
		return this.model.compareTo(model.getModel());
	}

	/*Comparator for sorting the list by Car Year*/
    public static Comparator<Cars> carYearComparator = new Comparator<Cars>() {

	public int compare(Cars c1, Cars c2) {
	   int carYear1 = c1.getYear();
	   int carYear2 = c2.getYear();

	   //descending order
	   return carYear2 - carYear1;
    }};

    /*Comparator for sorting the list by Car model*/
    public static Comparator<Cars> carModelComparator = new Comparator<Cars>() {

	public int compare(Cars c1, Cars c2) {
	   String carModel1 = c1.getModel().toUpperCase();
	   String carModel2 = c2.getModel().toUpperCase();

	   //ascending order
	   return carModel1.compareTo(carModel2);
    }};
 
	/*Comparator for sorting the list by Car Price*/
    public static Comparator<Cars> carPriceComparator = new Comparator<Cars>() {

	public int compare(Cars c1, Cars c2) {
	   BigDecimal carPrice1 = c1.getPrice();
	   BigDecimal carPrice2 = c2.getPrice();

	   //ascending order
	   return carPrice1.compareTo(carPrice2) ;
    }};

	/*Comparator for sorting the list by Car Rating*/
    public static Comparator<Cars> carRatingComparator = new Comparator<Cars>() {

	public int compare(Cars c1, Cars c2) {
	   float carRate1 = 0.0f;
	   carRate1 = c1.getTccRating();
	   float carRate2 = 0.0f;
	   carRate2 = c2.getTccRating();

	   //descending order
	   return (int) (carRate2 - carRate1) ;
    }};


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "model = "+ model + ", color = "+color+", price = "+price+", year = "+year+", tccRating = "+tccRating+", mpg = "+mpg;
	}	
	
	
}


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Cars> cars = new ArrayList<Cars>();
		cars.add(new Cars("CRV", "Green", 2016, new BigDecimal(23845), 8f, 33));
		cars.add(new Cars("Escape", "Red", 2017, new BigDecimal(23590), 7.8f, 32));
		cars.add(new Cars("Sante Fe", "Grey", 2016, new BigDecimal(24950), 8f, 27));
		cars.add(new Cars("CX-5", "Red", 2017, new BigDecimal(21795), 8f, 35));
		cars.add(new Cars("Forester", "Blue", 2016, new BigDecimal(22395), 8.4f, 32));
		System.out.println("==== cars sort by newest year =====");
		carSortByYear(cars);
		System.out.println("==== cars sort by model name alphabetically ====");
		carSortByModel(cars);
		System.out.println("==== cars sort by price ascending/best value ====");
		carSortByPrice(cars);
		System.out.println("==== cars distance by gas consumption ====");
		carGasConsumption(cars, 890);
		System.out.println("==== return a random car from the list ====");
		randomCar(cars);
		System.out.println("==== return an average MPG by year ====");
		carMPGByYear(cars);
	}

	/**
	 * Sort By newest Year 
	 */
	public static void carSortByYear(List<Cars> cars) {
		Collections.sort(cars, Cars.carYearComparator);
		for (Cars car: cars) {
			System.out.println(car.getModel() +"    "+car.getColor() +"    "+car.getYear()+"  "+car.getPrice()+"  "+car.getTccRating()+"  "+car.getMpg());
		}
	}
	
	/**
	 * Sort by car model alphabetically
	 */
	public static void carSortByModel(List<Cars> cars) {
		Collections.sort(cars, Cars.carModelComparator);
		for (Cars car: cars) {
			System.out.println(car.getModel() +"    "+car.getColor() +"  "+car.getYear()+"  "+car.getPrice()+"  "+car.getTccRating()+"  "+car.getMpg());
		}
	}

	/**
	 * Sort by car price/best value  
	 */
	public static void carSortByPrice(List<Cars> cars) {
		Collections.sort(cars, Cars.carPriceComparator);
		for (Cars car: cars) {
			System.out.println(car.getModel() +"  "+car.getColor() +"  "+car.getYear()+"  "+car.getPrice()+"  "+car.getTccRating()+"  "+car.getMpg());
		}
	}
	
	/**
	 * Calculate gas consumption for a given distance
	 */
	public static void carGasConsumption(List<Cars> cars, long distance) {
		int gallons = 0;
		for(Cars car: cars) {
			gallons = (int) (distance/car.getMpg()); 
			System.out.println("Car: "+car.getModel()+", distance: "+distance+", US Gallons used: "+gallons);
		}
		
	}

	/**
	 * return a random car from the list
	 * @return 
	 */
	public static Object randomCar(List<Cars> cars) {
		Random r = new Random();
		int i = r.nextInt(cars.size());
		System.out.println("Random Car: "+cars.toArray()[i]);
		return cars.toArray()[i];
	}
	
	/**
	 * return average MPG by year
	 */
	public static void carMPGByYear(List<Cars> cars) {
		Map<Integer, List<Integer>> carMap = new HashMap<>();
		List<Integer> carList;
		carList = new ArrayList<>();
		int totalMpg = 0;
		
		for(Cars car: cars) {
			carMap.put(car.getYear(), carList);
		}
		
		for(Integer year : carMap.keySet()) {
			carList = new ArrayList<>();
			Collections.sort(cars, Cars.carYearComparator);
			for(Cars car : cars) {
				if(year == car.getYear()) {
					carList.add(car.getMpg());
					carMap.put(car.getYear(), carList);
				}
			}
		}
		
		System.out.println(carMap.keySet());
		System.out.println(carMap.values());
		//get average by year
		//iterate over map by key and add list of values then divide by list size

		List<Integer> mpgList; 
		for(Integer carYear : carMap.keySet()) {
			totalMpg = 0;
			mpgList = carMap.get(carYear);
			for(Integer mpg : mpgList) {
				totalMpg += mpg;
			}	
		System.out.println("Year: " + carYear + ", Avg MPG: " + (totalMpg/mpgList.size()));
		}
	}

}
