import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class NotARipoff extends PApplet {

private int hello = 0;

public void setup() {
    

}

public void draw() {
    clear();
    background(30, 0);
    text(String.valueOf(frameRate), 10, 10, 100f, 100f);
    hello++;
    rect(hello, 20, 60, 30);
}
public class Player {
    
}
  public void settings() {  size(600, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "NotARipoff" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
