package de.exxcellent.challenge;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
		string weatherPath = "C:\Users\EWA\Documents\programming-challenge\src\main\resources\de\exxcellent\challenge\weather.csv";
		string footballPath = "C:\Users\EWA\Documents\programming-challenge\src\main\resources\de\exxcellent\challenge\football.csv";
		
		
        String dayWithSmallestTempSpread = GetWeatherDiff(weatherPath);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = GetFootballDiff(footballPath); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
	private string GetWeatherDiff(String weatherPath){
		int min = 500;
		string day = "";
		
        try (CSVReader reader = new CSVReader(new FileReader(weatherPath))) {
            List<String[]> w = reader.readAll();
			
            for(int i = 0; i<w.size(); i++){
				int diff = Integer.parseInt(w.get(i)[1]) - Integer.parseInt(w.get(i)[2]);
				if(min < diff){
					min = diff;
					day = w.get(i)[0]
				}
			}
		}
		return day;
	}
	private string GetFootballDiff(string footballPath){
		int min = 500;
		string team = "";
		try (CSVReader reader = new CSVReader(new FileReader(footballPath))) {
            List<String[]> f = reader.readAll();
			
            for(int i = 0; i<f.size(); i++){
				int diff = Integer.parseInt(f.get(i)[5]) - Integer.parseInt(f.get(i)[6]);
				if(diff < 0) 
					diff = diff *(-1);
				
				if(diff < min){
					min = diff;
					team = f.get(i)[0];
				}
			}
		}
		return team;
	}
}
