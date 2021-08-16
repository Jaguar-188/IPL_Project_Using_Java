package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class topTenEconomicalBowlersTest {
	
	List<Match> matches = Ipl.getMatchData();
	List<Delivery> deliveries = Ipl.getDeliveryData();

	@Test
	@DisplayName("Test to check for valid data..")
	void testForValidData() {
		
		HashMap<String, Double> topTenEconomicalBowlersAt2015 = new HashMap<>();
		String year2015 = "2015";
		
		topTenEconomicalBowlersAt2015 = Ipl.topTenEconomicalBowlers(matches,deliveries,year2015);
		
		assertEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year2015), topTenEconomicalBowlersAt2015,"This should not throw an error when valid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check for wrong data..")
	void testForWrongData() {
		
		HashMap<String, Double> wrongOutput = null;
		String year2015 = "2015";
		
		assertNotEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year2015), wrongOutput,"This should throw an error when Invalid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check whether the size of data is right or not")
	void testToCheckSizeOfData() {
		
		assertEquals(matches.size(), 636);
		assertEquals(deliveries.size(), 150460);
	}
	
	@Test
	@DisplayName("Test to check if null data is passed")
	void testToCheckNullInput() {
		
		assertThrows(NullPointerException.class, () -> Ipl.topTenEconomicalBowlers(null,null,null),"This should throw an NullPointerException");
	}

}
