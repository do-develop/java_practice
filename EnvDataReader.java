package ws12;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.*;
import org.json.*;

public class EnvDataReader {

	public static void main (String[] argv) throws IOException {
		String urlString = 
				"https://api.data.gov.sg/v1/environment/4-day-weather-forecast?date=2021-07-29";
			
		URL weatherURL = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection)weatherURL.openConnection();
		con.setRequestMethod("GET");
		BufferedReader dataStream =
				new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
		
		String rawInput = dataStream.readLine();
		System.out.println("Data in the form of a String");
		System.out.println(rawInput);
		
		//Convert String to JSON for easy processing
		JSONObject dataJSON = new JSONObject(rawInput);
		System.out.println("Data in JSON");
		System.out.println(dataJSON.toString(4));
		
		//Extract the array that contains the forecasts for the next 4 days
		JSONArray forecasts = 
				dataJSON.getJSONArray("items")
				.getJSONObject(0)
				.getJSONArray("forecasts");
		//print summary info for each day's forecast
		for(int i=0; i< forecasts.length(); ++i) {
			JSONObject oneDay = forecasts.getJSONObject(i);
			String date = oneDay.getString("date");
			int low = oneDay.getJSONObject("temperature").getInt("low");
			int high = oneDay.getJSONObject("temperature").getInt("high");
			String remark = oneDay.getString("forecast");
			System.out.println("Date  :" + date);
			System.out.println("Low   :" + low);
			System.out.println("High  :" + high);
			System.out.println("Remark:" + remark);
		}
	}
	
}
