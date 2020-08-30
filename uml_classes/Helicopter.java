package uml_classes;
import java.io.BufferedWriter;
import io.Output;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable{
  private BufferedWriter str = null;
  private WeatherTower weatherTower;
  Helicopter(String name, Coordinates coordinates){
    super(name, coordinates);
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
      coordinates.setLongitude(coordinates.getLongitude() + 10);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Mr.Sun please shine down on me \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "RAIN":
      coordinates.setLongitude(coordinates.getLongitude() + 5);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " It's Raining men \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "FOG":
      coordinates.setLongitude(coordinates.getLongitude() + 1);
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " I can't see shit \n");
      }catch(IOException e){
        System.out.println(e);
      }
      break;
      case "SNOW":
      if(coordinates.getHeight() > 11){
        coordinates.setHeight(coordinates.getHeight() - 12);
      }else{
        coordinates.setHeight(0);
      }
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " My rotor is gonna freeze \n");
      }catch(IOException e){
        System.out.println(e);
      }
      if(coordinates.getHeight() == 0){
        try{
          str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " The helicopter is landing \n");
        }catch(IOException e){
          System.out.println(e);
        }
        weatherTower.unregister(this);
      }
      break;
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
  public long getId(){
    return super.getId();
  }
  @Override
  public String getName(){
    return super.getName();
  }
}