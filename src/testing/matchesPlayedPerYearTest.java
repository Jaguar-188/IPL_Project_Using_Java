package testing;

import com.ipl.*;
import com.ipl.model.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class matchesPlayedPerYearTest {

	@Test
	void test() {
		
		HashMap<String, Integer> matchesPlayedPerYear = new HashMap<>();
		HashMap<String, Integer> wrongOutput = null;
		List<Match> matches = Ipl.getMatchData();
		
		matchesPlayedPerYear = Ipl.matchesPlayedPerYear(matches); 
		
		/* Checking For the Correct Output */
		assertEquals(Ipl.matchesPlayedPerYear(matches), matchesPlayedPerYear);
		
		/* Checking for the Wrong Output */
		assertNotEquals(Ipl.matchesPlayedPerYear(matches), wrongOutput);
	}

}
