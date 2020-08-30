package uml_classes;

public interface Flyable{
public Coordinates getCoordinates();
public long getId();
public String getName();
public void registerTower(WeatherTower weatherTower);
public void updateConditions();
}