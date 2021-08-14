package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({matchesPlayedPerYearTest.class,matchesWonPerTeamPerYear.class,
	extraRunsConcededPerTeamAt2016.class,topTenEconomicalBowlersAt2015.class})
public class AllTests {

}
