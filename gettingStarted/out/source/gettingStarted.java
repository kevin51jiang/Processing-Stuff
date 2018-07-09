import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class gettingStarted extends PApplet {


public ArrayList<ClickyAnim> anims = new ArrayList<ClickyAnim>();

public int animDuration = 3000;
public int animMaxSize = 50;

Camera worldCamera;
PImage backgroundBrick;

PVector mapSize = new PVector(1080, 1024);

Minim minim;
AudioPlayer player;

public void setup(){
  
  frameRate(60);
  worldCamera = new Camera( (int) mapSize.x,  (int) mapSize.y);

  //init textures
  backgroundBrick = loadImage("brick.png");

  //init sound
  minim = new Minim(this);
  
}

public void draw(){

  //camera stuff
  translate(-worldCamera.getPos().x, -worldCamera.getPos().y);
  worldCamera.update();

  drawBackground();

  int currentTime = millis();

  ArrayList<Integer> toRemove = new ArrayList<Integer>();

  for(int i = 0; i < anims.size(); i++){
    try {
      ellipse(anims.get(i).getXPos(), anims.get(i).getYPos(), 
                          anims.get(i).getDia(currentTime), 
                          anims.get(i).getDia(currentTime));  
    } catch (FinishedAnimException e) {
      //System.out.println("Added to remove"); //DEBUG
      toRemove.add(i);
    }
  }

  for(Integer i : toRemove){
    anims.remove((int) i);

    System.out.println("Removed: "  + i + ", Size: " + anims.size());
  }
  
  rect(130, 120, 60, 80);

  //CAMERA DEBUG
  translate(worldCamera.getPos().x, worldCamera.getPos().y);
  PVector virtualMousePos = new PVector(mouseX + worldCamera.getPos().x,
                                  mouseY + worldCamera.getPos().y);
  text("Camera Pos: " + worldCamera.getPos().x + ", " + worldCamera.getPos().y , 10, 20);
  text("Mouse Virtual Pos: " +  + virtualMousePos.x + ", " + virtualMousePos.y, 10, 40);
  text("Mouse Actual Pos: " + mouseX + ", " + mouseY, 10, 60 );
  
}

public void mousePressed() {
  playPopSound();
  PVector virtualMousePos = new PVector(mouseX + worldCamera.getPos().x,
                                    mouseY + worldCamera.getPos().y);

  anims.add(new ClickyAnim(animMaxSize, animDuration, millis(), (int) virtualMousePos.x, (int) virtualMousePos.y));
  System.out.println("Added new click @ " + mouseX + ", " + mouseY + " | VIRT: " + virtualMousePos.x + ", " + virtualMousePos.y);
}


public void drawBackground(){
  PVector placementPosition = new PVector(0,0);

  //clear everything off
  background(155);

  //for titling background vertically
  while(placementPosition.y < mapSize.y) {

    //for tiling it horizontally
    while(placementPosition.x < mapSize.x) {
      image(backgroundBrick, placementPosition.x, placementPosition.y);
      placementPosition.x += backgroundBrick.width;
    }

    placementPosition.x = 0;
    placementPosition.y += backgroundBrick.height;
  }
}

public void playPopSound(){
    player  = minim.loadFile("pop.mp3");
    player.play();
}
class Camera{
    private PVector pos;
    private final int dispInterval = 5;
    private final int bottomXBound, 
                    bottomYBound;
    public Camera(int bottomXBound, int bottomYBound) {
        pos = new PVector(0, 0);
        this.bottomXBound = bottomXBound;
        this.bottomYBound = bottomYBound;
    }

    public PVector getPos(){
        return pos;
    }

    public void update(){
        if (keyPressed) {
            switch(key){
                case 'w':
                    if(pos.y - dispInterval < 0){
                        pos.y = 0;
                    } else {
                        pos.y -= dispInterval;
                    }
                    break;

                case 's':
                    if(pos.y + dispInterval > bottomYBound){
                        pos.y = bottomYBound;
                    } else {
                        pos.y += dispInterval;
                    }
                    break;

                case 'a':
                    if(pos.x - dispInterval < 0) {
                        pos.x = 0;
                    } else {
                        pos.x -= dispInterval;
                    }
                    break;

                case 'd':
                    if(pos.x + dispInterval > bottomXBound){
                        pos.x = bottomXBound;
                    } else {
                        pos.x += dispInterval;
                    }
                    break;
            }
        }
    }


}
class ClickyAnim{
    
    private final int increments;
    private final double duration;
    private final int startTime;
    private final int maxDia;
    private int xPos,
                yPos;


    public ClickyAnim(int maxDia, int duration, int currentTime, int mousePosX, int mousePosY){
        increments = maxDia / duration;
        this.duration = duration;
        this.startTime = currentTime;
        this.maxDia = maxDia;

        this.xPos = mousePosX;
        this.yPos = mousePosY;
    }

    public int getDia(int currentTime) throws FinishedAnimException{
        int timeElapsed = currentTime - startTime;//find timeElapsed ellapsed, in milliseconds

        if(timeElapsed < duration / 2){//if still growing
            return (int) (timeElapsed / (duration / 2) * maxDia) ;

        } else if (timeElapsed == duration / 2){//if at max size
            return maxDia;

        } else if (timeElapsed > duration / 2 && timeElapsed < duration){//if shrinking
            int timeRemaining = ((int) duration) - timeElapsed;
        
            return (int) ((timeRemaining / duration) * maxDia);
        } else {//done, should be thrown out
            throw new FinishedAnimException("Duration was exceeded. Please remove from queue.");
        }
    }

    public int getXPos(){
        return this.xPos;
    }

    public int getYPos(){
        return this.yPos;
    }
}
public class FinishedAnimException extends Exception{

    public FinishedAnimException(){
        super();
    }

    public FinishedAnimException(String message){
        super(message);
    }

}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "gettingStarted" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
