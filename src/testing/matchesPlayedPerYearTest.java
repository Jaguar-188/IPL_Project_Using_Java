package testing;

import com.ipl.*;
import com.ipl.model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class matchesPlayedPerYearTest {
	
	List<Match> matches = Ipl.getMatchData();

	@Test
	@DisplayName("Test to check for valid data..")
	void testForValidData() {
		
		HashMap<String, Integer> matchesPlayedPerYear = new HashMap<>();
		
		matchesPlayedPerYear = Ipl.matchesPlayedPerYear(matches); 
		
		assertEquals(Ipl.matchesPlayedPerYear(matches), matchesPlayedPerYear,"This should not throw an error when valid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check for not equal data..")
	void testForWrongData() {
		
		HashMap<String, Integer> wrongOutput = null;
		
		assertNotEquals(Ipl.matchesPlayedPerYear(matches), wrongOutput,"This should throw an error when Invalid data is passed.");
	}
	
	@Test
	@DisplayName("Test to check whether the size of data is right or not")
	void testToCheckSizeOfData() {
		
		assertEquals(matches.size(), 636);
	}
	
	@Test
	@DisplayName("Test to check if null data is passed")
	void testToCheckNullInput() {
		
		assertThrows(NullPointerException.class, () -> Ipl.matchesPlayedPerYear(null),"This should throw an NullPointerException");
	}

}
