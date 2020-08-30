package io;
import uml_classes.AircraftFactory;
import uml_classes.Flyable;
import uml_classes.WeatherTower;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Input
{
  private static BufferedWriter str = null;
  private static List<Flyable> flyables = new ArrayList<Flyable>();
  private static WeatherTower weatherTower;
  public static void main(String[] args) throws InterruptedException{
    try{
      BufferedReader read = new BufferedReader(new FileReader(args[0]));
      str = Output.getWriter();
      String next = read.readLine();
      if(next != null){
        weatherTower = new WeatherTower();
        int x = Integer.parseInt(next.split(" ")[0]);
          if(x < 0){
            System.out.println("Must have atleast one simulation! Please check input file...");
            System.exit(1);
          }
          while((next = read.readLine()) != null){
            Flyable flyable = AircraftFactory.aircraftFactory(next.split(" ")[0], next.split(" ")[1], Integer.parseInt(next.split(" ")[2]), Integer.parseInt(next.split(" ")[3]), Integer.parseInt(next.split(" ")[4]));
            if(flyable == null){
              System.out.println("Input file has an error, aborted");
              System.exit(1);
            }
            flyables.add(flyable);
          }
          for(Flyable flyable: flyables){
            flyable.registerTower(weatherTower);
          }
          int i = 0;
          while(i <= x){
            i = i + 1;
            weatherTower.changeWeather();
          }
          str.close();
        }
      }catch(ArrayIndexOutOfBoundsException a){
        System.out.println("Array error");
      }catch(FileNotFoundException e){
        System.out.println("File location error");
      }catch(IOException io){
        System.out.println("Input or output error");
      }
    }
  }