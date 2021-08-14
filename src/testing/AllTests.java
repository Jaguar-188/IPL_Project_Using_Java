package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({matchesPlayedPerYearTest.class,matchesWonPerTeamPerYearTest.class,
	extraRunsConcededPerTeamAt2016Test.class,topTenEconomicalBowlersAt2015Test.class})
public class AllTests {

}
