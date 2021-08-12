package com.ipl;
import com.ipl.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ipl {
	
	private static final String matchesPath = "./data/matches.csv"; 
	private static final String deliveriesPath = "./data/deliveries.csv";
	
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
	
	private static final int deliveryId = 0;
	private static final int inning = 1;
	private static final int battingTeam = 2;
	private static final int bowlingTeam = 3;
	private static final int over = 4;
	private static final int ball = 5;
	private static final int batsman = 6;
	private static final int nonStriker = 7;
	private static final int bowler = 8;
	private static final int isSuperOver = 9;
	private static final int wideRuns = 10;
	private static final int byeRuns = 11;
	private static final int legbyeRuns = 12;
	private static final int noballRuns = 13;
	private static final int penaltyRuns = 14;
	private static final int batsmanRuns = 15;
	private static final int extraRuns = 16;
	private static final int totalRuns = 17;

	public static void main(String[] args) {
		
		List<Match> matches = getMatchData();
		
		List<Delivery> deliveries =  getDeliveryData();
		
		HashMap<String, Integer> matchesPlayedPerYear = matchesPlayedPerYear(matches);
		System.out.println("Matches Played Per Year:");
		for(Map.Entry<String, Integer> entry : matchesPlayedPerYear.entrySet())
		{
			System.out.println("\t"+entry);
			
		}
		
		System.out.println("\n");
		
		HashMap<String, HashMap<String, Integer>> matchesWonPerTeamPerYear = matchesWonPerTeamPerYear(matches);
		System.out.println("Matches Won Per Tear Per Year:");
		for(Map.Entry<String, HashMap<String, Integer>> entry : matchesWonPerTeamPerYear.entrySet())
		{
			System.out.println("\t"+entry);
			
		}
		
		System.out.println("\n");
		
		String year2016 = "2016";
		HashMap<String, Integer> extraRunsConcededPerTeam = extraRunsConcededPerTeamAt2016(matches,deliveries,year2016);
		System.out.println("Extra Runs Conceded Per Team AT Year 2016:");
		for(Map.Entry<String, Integer> entry : extraRunsConcededPerTeam.entrySet())
		{
			System.out.println("\t"+entry);
			
		}
		
		System.out.println("\n");
		
		String year2015 = "2015";
		HashMap<String, Double> topTenEconomicalBowlers  = topTenEconomicalBowlersAt2015(matches,deliveries,year2015);
		System.out.println("Top Ten Economical Bowlers AT Year 2016:");
		for(Map.Entry<String, Double> entry : topTenEconomicalBowlers.entrySet())
		{
			System.out.println("\t"+entry);
		}
	}
	
	public static HashMap<String, Integer> matchesPlayedPerYear(List<Match> matches) 
	{
		HashMap<String, Integer> matchesPlayedPerYear = new HashMap<>();
		for(Match match:matches)
		{
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
	
	public static HashMap<String, HashMap<String, Integer>> matchesWonPerTeamPerYear(List<Match> matches) 
	{
		HashMap<String, Integer> winnerPerYear = new HashMap<String, Integer>();
		HashMap<String, HashMap<String, Integer>> matchesWonPerTeamPerYear = new HashMap<String, HashMap<String, Integer>>();
		
		for(Match match : matches)
		{
			String Season = match.getSeason();
			String Winner = match.getWinner();
			if(matchesWonPerTeamPerYear.containsKey(Season))
			{
				if(matchesWonPerTeamPerYear.get(Season).containsKey(Winner))
				{
					winnerPerYear.put(Winner, matchesWonPerTeamPerYear.get(Season).get(Winner) + 1);	
					matchesWonPerTeamPerYear.put(Season, winnerPerYear);
				}
				else
				{
					winnerPerYear.put(Winner,1);
					matchesWonPerTeamPerYear.put(Season,winnerPerYear);
				}
			}
			else
			{
				winnerPerYear.put(Winner,1);
	            matchesWonPerTeamPerYear.put(Season, winnerPerYear);
			}
		}
		return matchesWonPerTeamPerYear;
	}
	
	public static HashMap<String, Integer> extraRunsConcededPerTeamAt2016(List<Match> matches, List<Delivery> deliveries, String year2016) 
	{
		List<String> matchDataFiltered = new ArrayList<>();
		HashMap<String, Integer> extraRunsConceded = new HashMap<String, Integer>();
		
		for(Match match : matches)
		{
			if(match.getSeason().equals(year2016))
			{
				matchDataFiltered.add(match.getMatchId());
			}
		}
		
		for(String id : matchDataFiltered)
		{
			String idFromMatch = id;
			for(Delivery delivery : deliveries)
			{
				String idFromDelivery = delivery.getMatchId();
				if(idFromMatch.equals(idFromDelivery))
				{
					String bowlingTeam = delivery.getBowlingTeam();
					String extraRuns = delivery.getExtraRuns();
					if(extraRunsConceded.containsKey(bowlingTeam))
					{
						extraRunsConceded.put(bowlingTeam, extraRunsConceded.get(bowlingTeam) + Integer.parseInt(extraRuns));
					}
					else
					{
						extraRunsConceded.put(bowlingTeam, Integer.parseInt(extraRuns));
					}
				}
			}
		}
		return extraRunsConceded;	
	}
	
	public static HashMap<String, Double> topTenEconomicalBowlersAt2015(List<Match> matches,List<Delivery> deliveries,String year2015)
	{
		List<String> matchDataFiltered = new ArrayList<>();
		HashMap<String, Double> totalRunsByEachBowler = new HashMap<String, Double>();
		HashMap<String, Double> totalBowlsByEachBowler = new HashMap<String, Double>();
		HashMap<String,Double> topEconomicalBowlers = new HashMap<String,Double>();
		HashMap<String, Double> topTenEconomicalBowlers  = new HashMap<String,Double>();
		
		
		for(Match match : matches)
		{
			if(match.getSeason().equals(year2015))
			{
				matchDataFiltered.add(match.getMatchId());
			}
		}
		for(String id : matchDataFiltered)
		{
			String idFromMatch = id;
			for(Delivery delivery : deliveries)
			{
				String idFromDelivery = delivery.getMatchId();
				if(idFromMatch.equals(idFromDelivery))
				{
					String bowler = delivery.getBowler();
					String totalRuns = delivery.getTotalRuns();
					String totalBalls = delivery.getBall();
					if(totalRunsByEachBowler.containsKey(bowler))
					{
						totalRunsByEachBowler.put(bowler, totalRunsByEachBowler.get(bowler) + Double.parseDouble(totalRuns));
						totalBowlsByEachBowler.put(bowler, totalBowlsByEachBowler.get(bowler) + Double.parseDouble(totalBalls));
					}
					else
					{
						totalRunsByEachBowler.put(bowler, Double.parseDouble(totalRuns));
						totalBowlsByEachBowler.put(bowler,  Double.parseDouble(totalBalls));
					}
				}
				
			}
			
		}

		for(Map.Entry<String, Double> runs : totalRunsByEachBowler.entrySet())
		{
			for(Map.Entry<String, Double> balls : totalBowlsByEachBowler.entrySet())
			{
				if(runs.getKey().equals(balls.getKey()))
				{
					topEconomicalBowlers.put(runs.getKey(),runs.getValue()/(balls.getValue()/6));
				}
			}
		}
		List<Map.Entry<String, Double>> list = new ArrayList<>(topEconomicalBowlers.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> c1,Map.Entry<String, Double> c2)
			{
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		
		int temp = 0;
		for(Map.Entry<String, Double> entry : list)
		{
			temp++;
			if(temp == 10)
			{
				break;
			}
			topTenEconomicalBowlers.put(entry.getKey(), entry.getValue());
		}
		return topTenEconomicalBowlers;
	}
	
	
	public static List<Match> getMatchData()
	{
		List<Match> matches = new ArrayList<>();
		
		try 
		{
			String line = "";
			String data[];
			int count = 0;
			FileReader file = new FileReader(matchesPath);
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
	
	public static List<Delivery> getDeliveryData()
	{
		List<Delivery> deliveries = new ArrayList<>();
		
		try 
		{
			String line = "";
			String data[];
			int count = 0;
			FileReader file = new FileReader(deliveriesPath);
			BufferedReader br = new BufferedReader(file);
			while((line = br.readLine()) != null)
			{
				Delivery delivery = new Delivery();
				if(count != 0)
				{
					data = line.split(",");
					delivery.setMatchId(data[deliveryId]);
					delivery.setInning(data[inning]);
					delivery.setBattingTeam(data[battingTeam]);
					delivery.setBowlingTeam(data[bowlingTeam]);
					delivery.setOver(data[over]);
					delivery.setBall(data[ball]);
					delivery.setBatsman(data[batsman]);
					delivery.setNonStriker(data[nonStriker]);
					delivery.setBowler(data[bowler]);
					delivery.setIsSuperOver(data[isSuperOver]);
					delivery.setWideRuns(data[wideRuns]);
					delivery.setByeRuns(data[byeRuns]);
					delivery.setLegbyeRuns(data[legbyeRuns]);
					delivery.setNoballRuns(data[noballRuns]);
					delivery.setPenaltyRuns(data[penaltyRuns]);
					delivery.setBatsmanRuns(data[batsmanRuns]);
					delivery.setExtraRuns(data[extraRuns]);
					delivery.setTotalRuns(data[totalRuns]);
					deliveries.add(delivery);
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
		return deliveries;
	}

}
