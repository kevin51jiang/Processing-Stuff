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

public void setup() {
    
    rect(20, 20, 50 , 60);
}

public void draw() {
    
}
  public void settings() {  fullScreen(SPAN); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "NotARipoff" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
