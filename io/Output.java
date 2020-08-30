package io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output extends BufferedWriter
{
  private static Output output = null;
  private Output() throws IOException
  {
    super(new FileWriter("Simulation.txt"));
  }
  public static BufferedWriter getWriter() throws IOException
  {
    if(output == null){
      output = new Output();
    }
    return output;
  }
}