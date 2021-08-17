package testing;

import static org.junit.jupiter.api.Assertions.*;
import com.ipl.*;
import com.ipl.model.*;
import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class matchesWonPerTeamPerYearTest {
	
	List<Match> matches = Ipl.getMatchData();

	@Test
	@DisplayName("Test to check for valid data..")
	void testForValidData() {
		
		HashMap<String, HashMap<String, Integer>> matchesPlayedPerTeamPerYear = new HashMap<>();
		
		matchesPlayedPerTeamPerYear = Ipl.matchesWonPerTeamPerYear(matches);
		
		assertEquals(Ipl.matchesWonPerTeamPerYear(matches), matchesPlayedPerTeamPerYear,"This should not throw an error when valid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check for not equal data..")
	void testForWrongData() {
		
		HashMap<String, HashMap<String, Integer>> wrongOutput = null;
		
		assertNotEquals(Ipl.matchesWonPerTeamPerYear(matches), wrongOutput,"This should throw an error when Invalid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check whether the size of data is right or not")
	void testToCheckSizeOfData() {
		
		assertEquals(matches.size(), 636);
	}
	
	@Test
	@DisplayName("Test to check if null data is passed")
	void testToCheckNullInput() {
		
		assertThrows(NullPointerException.class, () -> Ipl.matchesWonPerTeamPerYear(null),"This should throw an NullPointerException");
	}
	
}
