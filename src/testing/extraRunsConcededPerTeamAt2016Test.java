package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class extraRunsConcededPerTeamAt2016Test {

	@Test
	void test() {
		
		HashMap<String, Integer> extraRunsConcededPerTeam = new HashMap<>();
		HashMap<String, Integer> wrongOutput = null;
		List<Match> matches = Ipl.getMatchData();
		List<Delivery> deliveries = Ipl.getDeliveryData();
		String year2016 = "2016";
		extraRunsConcededPerTeam = Ipl.extraRunsConcededPerTeamAt2016(matches,deliveries,year2016); 
		
		/* Checking For the Correct Output */
		assertEquals(Ipl.extraRunsConcededPerTeamAt2016(matches,deliveries,year2016), extraRunsConcededPerTeam);
		
		/* Checking for the Wrong Output */
		assertNotEquals(Ipl.extraRunsConcededPerTeamAt2016(matches,deliveries,year2016), wrongOutput);
		
		/* Checking for the size of data*/
		assertEquals(matches.size(), 636);
		assertEquals(deliveries.size(), 150460);
	}

}
