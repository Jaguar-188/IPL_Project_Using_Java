package com.ipl;
import com.ipl.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ipl {
	
	private static final int matchId = 0;
	private static final int season = 1;
	private static final int city = 2;
	private static final int date = 3;
	private static final int team1 = 4;
	private static final int team2 = 5;
	private static final int tossWinner = 6;
	private static final int tossDecision = 7;
	private static final int result = 8;
	private static final int dlApplied = 9;
	private static final int winner = 10;
	private static final int winByRuns = 11;
	private static final int winByWickets = 12;
	private static final int playerOfMatch = 13;
	private static final int venue = 14;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Match> matches = getMatchData();
		//System.out.println(matches);
		HashMap<String, Integer> matchCount= matchesPlayedPerYear(matches);
		System.out.println("Matches Played Per Year:");
		System.out.println(matchCount);
		
		matchesWonPerTeamPerYear(matches);
		

	}
	
	public static HashMap<String, Integer> matchesPlayedPerYear(List<Match> matches) {
		HashMap<String, Integer> matchesPlayedPerYear = new HashMap<>();
		for(Match match:matches)
		{
			//System.out.println(match.getSeason());
			if(matchesPlayedPerYear.containsKey(match.getSeason()))
			{
				matchesPlayedPerYear.put(match.getSeason(),matchesPlayedPerYear.get(match.getSeason()) + 1);
			}
			else
			{
				matchesPlayedPerYear.put(match.getSeason(), 1);
			}
		}
		return matchesPlayedPerYear;
	}
	
	public static void matchesWonPerTeamPerYear(List<Match> matches) {
		HashMap<String, Integer> winner = new HashMap<String, Integer>();
		HashMap<String, HashMap<String, Integer>> matchesWonPerTeamPerYear = new HashMap<String, HashMap<String, Integer>>();
		
		for(Match match : matches)
		{
			if(matchesWonPerTeamPerYear.containsKey(match.getSeason()))
			{
				//matchesWonPerTeamPerYear.put(match.getSeason(), winner);
			}
			else
			{
				if(winner.containsKey(match.getWinner()))
				{
					winner.put(match.getWinner(), winner.get(match.getWinner()) + 1);
				}
				else
				{
					winner.put(match.getWinner(), 1);
				}
				matchesWonPerTeamPerYear.put(match.getSeason(), winner);
			}
		}
		System.out.println(matchesWonPerTeamPerYear);
	}
	
	public static List<Match> getMatchData(){
		
		//System.out.println("Hello");
		List<Match> matches = new ArrayList<>();
		
		try 
		{
			String path = "./data/matches.csv";  
			String line = "";
			String data[];
			int count = 0;
			FileReader file = new FileReader(path);
			BufferedReader br = new BufferedReader(file);
			while((line = br.readLine()) != null)
			{
				Match match = new Match();
				if(count != 0)
				{
					data = line.split(",");
					match.setMatchId(data[matchId]);
					match.setSeason(data[season]);
					match.setCity(data[city]);
					match.setDate(data[date]);
					match.setTeam1(data[team1]);
					match.setTeam2(data[team2]);
					match.setTossWinner(data[tossWinner]);
					match.setTossDecision(data[tossDecision]);
					match.setResult(data[result]);
					match.setDlApplied(data[dlApplied]);
					match.setWinner(data[winner]);
					match.setWinByRuns(data[winByRuns]);
					match.setWinByWickets(data[winByWickets]);
					match.setPlayerOfMatch(data[playerOfMatch]);
					match.setVenue(data[venue]);
					//System.out.println(match);
					matches.add(match);
				}
				
				count = count + 1;
			}
			br.close();
			file.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return matches;
	}

}
