package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class extraRunsConcededPerTeamTest {
	
	List<Match> matches = Ipl.getMatchData();
	List<Delivery> deliveries = Ipl.getDeliveryData();

	@Test
	@DisplayName("Test to check for valid data..")
	void testForValidData() {
		
		HashMap<String, Integer> extraRunsConcededPerTeamAt2016 = new HashMap<>();
		String year = "2016";
		
		extraRunsConcededPerTeamAt2016 = Ipl.extraRunsConcededPerTeam(matches,deliveries,year);
		
		assertEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year), extraRunsConcededPerTeamAt2016,"This should not throw an error when valid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check for not equal data..")
	void testForWrongData() {
		
		HashMap<String, Integer> wrongOutput = null;
		String year2016 = "2016";
		
		assertNotEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year2016), wrongOutput,"This should throw an error when Invalid data is passed.");
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
		
		assertThrows(NullPointerException.class, () -> Ipl.extraRunsConcededPerTeam(null,null,null),"This should throw an NullPointerException");
	}
	
	@Test
	@DisplayName("Test for different year")
	void testForDifferentYear() {
		
		HashMap<String, Integer> extraRunsConcededPerTeamAt2014 = new HashMap<>();
		String year = "2014";
		
		extraRunsConcededPerTeamAt2014 = Ipl.extraRunsConcededPerTeam(matches,deliveries,year);
		
		assertEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year), extraRunsConcededPerTeamAt2014,"This should not throw an error when valid data is passed.");
	}
	
	
	


}
