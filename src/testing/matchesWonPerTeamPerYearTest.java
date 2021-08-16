package testing;

import static org.junit.jupiter.api.Assertions.*;
import com.ipl.*;
import com.ipl.model.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class matchesWonPerTeamPerYearTest {

	@Test
	void test() {
		
		HashMap<String, HashMap<String, Integer>> matchesPlayedPerTeamPerYear = new HashMap<>();
		HashMap<String, HashMap<String, Integer>> wrongOutput = null;
		List<Match> matches = Ipl.getMatchData();
		
		matchesPlayedPerTeamPerYear = Ipl.matchesWonPerTeamPerYear(matches);
		
		/* Checking for the size of data*/
		assertEquals(matches.size(), 636);
		
		/* Checking For the Correct Output */
		assertEquals(Ipl.matchesWonPerTeamPerYear(matches), matchesPlayedPerTeamPerYear);
		
		/* Checking for the Wrong Output */
		assertNotEquals(Ipl.matchesWonPerTeamPerYear(matches), wrongOutput);
		
	}

}
