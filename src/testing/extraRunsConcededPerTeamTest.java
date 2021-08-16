package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class extraRunsConcededPerTeamTest {

	@Test
	void test() {
		
		HashMap<String, Integer> extraRunsConcededPerTeamAt2016 = new HashMap<>();
		HashMap<String, Integer> wrongOutput = null;
		HashMap<String, Integer> extraRunsConcededPerTeamAt2014 = new HashMap<>();
		List<Match> matches = Ipl.getMatchData();
		List<Delivery> deliveries = Ipl.getDeliveryData();
		String year2016 = "2016";
		String year2014 = "2014";
		extraRunsConcededPerTeamAt2016 = Ipl.extraRunsConcededPerTeam(matches,deliveries,year2016); 
		extraRunsConcededPerTeamAt2014 = Ipl.extraRunsConcededPerTeam(matches,deliveries,year2014); 
		
		/* Checking for the size of data*/
		assertEquals(matches.size(), 636);
		assertEquals(deliveries.size(), 150460);
		
		/* Checking For the Correct Output */
		assertEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year2016), extraRunsConcededPerTeamAt2016);
		
		/* Checking for the Wrong Output */
		assertNotEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year2016), wrongOutput);
		
		/* Checking for Different Year e.g 2014 */
		assertEquals(Ipl.extraRunsConcededPerTeam(matches,deliveries,year2014), extraRunsConcededPerTeamAt2014);
		
	}

}
