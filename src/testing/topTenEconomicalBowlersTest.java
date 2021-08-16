package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ipl.Ipl;
import com.ipl.model.Delivery;
import com.ipl.model.Match;

class topTenEconomicalBowlersTest {

	@Test
	void test() {
		
		HashMap<String, Double> topTenEconomicalBowlers = new HashMap<>();
		HashMap<String, Double> wrongOutput = null;
		List<Match> matches = Ipl.getMatchData();
		List<Delivery> deliveries = Ipl.getDeliveryData();
		String year2015 = "2015";
		
		topTenEconomicalBowlers = Ipl.topTenEconomicalBowlers(matches,deliveries,year2015);
		
		/* Checking for the size of data*/
		assertEquals(matches.size(), 636);
		assertEquals(deliveries.size(), 150460);
		
		/* Checking For the Correct Output */
		assertEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year2015), topTenEconomicalBowlers);
		
		/* Checking for the Wrong Output */
		assertNotEquals(Ipl.topTenEconomicalBowlers(matches,deliveries,year2015), wrongOutput);
		
		
	}

}
