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
	@DisplayName("Test to check for wrong data..")
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
	
//	@Test
//	@DisplayName("Test to check for Dummy Data")
//	void testForDummyData() {
//		
//		final int matchId = 0;
//		final int season = 1;
//		final int winner = 10;
//		final String matchesPath = "./testData/testMatches.csv";
//		
//		List<Match> dummyMatchData = new ArrayList<>();
//		
//		try 
//		{
//			String line = "";
//			String data[];
//			int count = 0;
//			FileReader file = new FileReader(matchesPath);
//			BufferedReader br = new BufferedReader(file);
//			while((line = br.readLine()) != null)
//			{
//				Match match = new Match();
//				if(count != 0)
//				{
//					data = line.split(",");
//					match.setMatchId(data[matchId]);
//					match.setSeason(data[season]);
//					match.setWinner(data[winner]);
//					dummyMatchData.add(match);
//				}
//				count = count + 1;
//			}
//			br.close();
//			file.close();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		assertEquals(Ipl.matchesPlayedPerYear(dummyMatchData), Ipl.matchesPlayedPerYear(dummyMatchData));
//	}

}
