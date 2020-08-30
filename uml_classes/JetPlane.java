package uml_classes;
import java.io.BufferedWriter;
import java.io.IOException;
import io.Output;

public class JetPlane extends Aircraft implements Flyable{
  private BufferedWriter str = null;
  private WeatherTower weatherTower;
  JetPlane(String name, Coordinates coordinates){
    super(name,coordinates);
  }
  public void updateConditions(){
    try{
      str = Output.getWriter();
    }catch(IOException e){
      System.out.println(e);
    }
    String weather = weatherTower.getWeather(coordinates);
    switch(weather){
      case "SUN":
      coordinates.setHeight(coordinates.getHeight() + 2);
      coordinates.setLatitude(coordinates.getLatitude() + 10);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " It's so Hot my balls are cooked \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "RAIN":
      coordinates.setLatitude(coordinates.getLatitude() + 5);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " It's raining. Better watch out for lightning \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "FOG":
      coordinates.setLatitude(coordinates.getLatitude() + 1);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " The fog is killing me. Request permission to land \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "SNOW":
      if(coordinates.getHeight() > 6){
        coordinates.setHeight(coordinates.getHeight() - 7);
      }else{
        coordinates.setHeight(0);
      }
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " They where right Winter came \n");
      }catch(IOException e){
        System.out.println(e);
      }
      if(coordinates.getHeight() < 0){
        try{
          str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " The jetplane is exploded I mean it's landing \n");
        }catch(IOException e){
          System.out.println(e);
        }
        weatherTower.unregister(this);
      }
    }
  }
  public void registerTower(WeatherTower weatherTower){
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
  @Override
  public Coordinates getCoordinates(){
    return super.getCoordinates();
  }
  @Override
  public String getName(){
    return super.getName();
  }
}