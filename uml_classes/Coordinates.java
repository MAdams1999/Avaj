package uml_classes;

public class Coordinates{
  private int height;
  private int latitude;
  private int longitude;
  Coordinates(int height, int latitude, int longitude){
    this.height = height;
    this.latitude = latitude;
    this.longitude = longitude;
  }
  public int getHeight(){
    int h = this.height;
    return(h);
  }
  public int getLatitude(){
    int la = this.latitude;
    return(la);
  }
  public int getLongitude(){
    int lo = this.longitude;
    return(lo);
  }
  public void setHeight(int height){
    if (height <= 100 && height > 0){
      this.height = height;
    }
    else if (height <= 0){
      this.height = 0;
    }
    else
      this.height = 100;
  }
  public void setLatitude(int latitude){
    this.latitude = latitude;
  }
  public void setLongitude(int longitude){
    this.longitude = longitude;
  }
}