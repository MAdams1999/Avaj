package uml_classes;
import java.io.BufferedWriter;
import java.io.IOException;
import io.Output;

public class Baloon extends Aircraft implements Flyable{
  private BufferedWriter str = null;
  private WeatherTower weatherTower;
  Baloon(String name, Coordinates coordinates){
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
    coordinates.setHeight(coordinates.getHeight() + 4);
    coordinates.setLongitude(coordinates.getLongitude() + 2);
    try{
      str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Oh look the sun's out \n");
    }catch(IOException e){
      System.out.println(e);
    }
    break;
    case "RAIN":
    if(coordinates.getHeight() >= 5){
      coordinates.setHeight(coordinates.getHeight() - 5);
    }else{
      coordinates.setHeight(0);
    }
    try{
      str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Ah my Baloon seems to be wet \n");
    }catch(IOException e){
      System.out.println(e);
    }
    if(coordinates.getHeight() == 0){
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " The Wet Baloon Landed \n");
      }catch(IOException e){
        System.out.println(e);
      }
      weatherTower.unregister(this);
    }
    break;
    case "FOG":
    if(coordinates.getHeight() >= 3){
      coordinates.setHeight(coordinates.getHeight() - 3);
    }else{
      coordinates.setHeight(0);
    }
    try{
      str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " There is so much FOG I can't see shit \n");
    }catch(IOException e){
      System.out.println(e);
    }
    if(coordinates.getHeight() == 0){
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Baloon Landed \n");
      }catch(IOException e){
        System.out.println(e);
      }
      weatherTower.unregister(this);
    }
    break;
    case "SNOW":
    if(coordinates.getHeight() >= 15){
      coordinates.setHeight(coordinates.getHeight() - 15);
    }else{
      coordinates.setHeight(0);
    }
    try{
      str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Do you wanna build a Snowman  \n");
    }catch(IOException e){
      System.out.println(e);
    }
    if(coordinates.getHeight() == 0){
      try{
        str.write(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")" + " Where gonna Land the thing \n");
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
  public String getName(){
    return(super.getName());
  }
  @Override
  public Coordinates getCoordinates(){
    return(super.getCoordinates());
  }
}