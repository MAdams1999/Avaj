package uml_classes;
import java.util.Random;

public class WeatherProvider{
  private static String[] weather = {"FOG", "RAIN", "SNOW", "SUN"};
  private static final WeatherProvider weatherProvider = new WeatherProvider();
  public static WeatherProvider getProvider(){
    return WeatherProvider.weatherProvider;
  }
  public String getCurrentWeather(Coordinates coordinates){
    Random rand = new Random();
    int upperbound = 25;
    int int_random = rand.nextInt(upperbound);
    int i = (coordinates.getLatitude() + coordinates.getHeight() + coordinates.getLongitude() + int_random) % 4;
    return weather[i];
  }
}