package uml_classes;
import io.Output;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Tower{
  private List<Flyable> start = new ArrayList<>();
  private List<Flyable> end = new ArrayList<>();
  private BufferedWriter str = null;
  public void register(Flyable flyable){
    try{
      str = Output.getWriter();
    }catch(IOException e){
      System.out.println(e);
    }
    start.add(flyable);
    try{
      str.write("Tower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " registered to the weather tower.\n");
    }catch(IOException e){
      System.out.println(e);
    }
  }
  public void unregister(Flyable flyable){
    try{
      str.write("Tower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " unregistered from the weather tower.\n");
    }catch(IOException e){
      System.out.println(e);
    }
  }
  protected void conditionsChanged(){
    for(Flyable flyable : start){
      flyable.updateConditions();
      if(flyable.getCoordinates().getHeight() == 0){
        end.add(flyable);
      }
    }
    start.removeAll(end);
  }
}