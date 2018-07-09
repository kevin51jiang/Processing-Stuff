import ddf.minim.*;
public ArrayList<ClickyAnim> anims = new ArrayList<ClickyAnim>();

public int animDuration = 3000;
public int animMaxSize = 50;

Camera worldCamera;
PImage backgroundBrick;

PVector mapSize = new PVector(1080, 1024);

Minim minim;
AudioPlayer player;

void setup(){
  size(800, 600);
  frameRate(60);
  worldCamera = new Camera( (int) mapSize.x,  (int) mapSize.y);

  //init textures
  backgroundBrick = loadImage("brick.png");

  //init sound
  minim = new Minim(this);
  
}

void draw(){

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

void mousePressed() {
  playPopSound();
  PVector virtualMousePos = new PVector(mouseX + worldCamera.getPos().x,
                                    mouseY + worldCamera.getPos().y);

  anims.add(new ClickyAnim(animMaxSize, animDuration, millis(), (int) virtualMousePos.x, (int) virtualMousePos.y));
  System.out.println("Added new click @ " + mouseX + ", " + mouseY + " | VIRT: " + virtualMousePos.x + ", " + virtualMousePos.y);
}


void drawBackground(){
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

void playPopSound(){
    player  = minim.loadFile("pop.mp3");
    player.play();
}