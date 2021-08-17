package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

import org.json.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class topTenEconomicalBowlersTest {
	
	List<Match> matches = Ipl.getMatchData();
	List<Delivery> deliveries = Ipl.getDeliveryData();

//	@Test
//	@DisplayName("Test to check for valid data..")
//	void testForValidData() {
//		assertEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year), topTenEconomicalBowlersAt2015,"This should not throw an error when valid data is passed.");
//	}
	
	@Test
	@DisplayName("Test to check if returned data is null or not")
	void testForNotNull() {
		
		String year = "2015";
		
		assertNotNull(Ipl.topTenEconomicalBowlers(matches,deliveries,year),"This should throw an error when Invalid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check whether the size of data is right or not")
	void testToCheckSizeOfData() {
		
		int sizeOfMatch = Ipl.getMatchData().size();
		int sizeOfDelivery = Ipl.getDeliveryData().size();
		
		assertEquals(matches.size(), sizeOfMatch);
		assertEquals(deliveries.size(), sizeOfDelivery);
	}
	
	@Test
	@DisplayName("Test to check if null data is passed")
	void testToCheckNullInput() {
		
		assertThrows(NullPointerException.class, () -> Ipl.topTenEconomicalBowlers(null,null,null),"This should throw an NullPointerException");
	}
	
	@Test()
	@DisplayName("Test to check if empty data/list is passed")
	void testForInvalidInput() {
		
		String year = "2015";
		List<Match> empty = new ArrayList<>();
		
		assertThrows(EmptyStackException.class, () -> Ipl.topTenEconomicalBowlers(empty, deliveries,year),"This should throw an Exception");
	}
	
	@Test
	@DisplayName("Test to check return type of function is same as data type of input data")
	void testToCheckReturnType() {
		
		String actual = "HashMap";
		String year = "2015";
		
		assertEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year).getClass().getSimpleName(), actual);
	}

}
