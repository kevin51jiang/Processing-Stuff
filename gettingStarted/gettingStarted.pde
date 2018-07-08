public ArrayList<ClickyAnim> anims = new ArrayList<ClickyAnim>();

public int animDuration = 10000;
public int animMaxSize = 50;

Camera worldCamera;

void setup(){
  size(800, 600);
  frameRate(60);
  worldCamera = new Camera(1080, 1024);
}

void draw(){


  drawBackground();


    //CAMERA DEBUG
  PVector virtualMousePos = new PVector(mouseX + worldCamera.getPos().x,
                                  mouseY + worldCamera.getPos().y);
  text("Camera Pos: " + worldCamera.getPos().x + ", " + worldCamera.getPos().y , 10, 20);
  text("Mouse Virtual Pos: " +  + virtualMousePos.x + ", " + virtualMousePos.y, 10, 40);
  text("Mouse Actual Pos: " + mouseX + ", " + mouseY, 10, 60 );
  

  //camera stuff
  translate(-worldCamera.getPos().x, -worldCamera.getPos().y);
  worldCamera.update();

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

}

void mousePressed() {

  PVector virtualMousePos = new PVector(mouseX + worldCamera.getPos().x,
                                    mouseY + worldCamera.getPos().y);

  anims.add(new ClickyAnim(animMaxSize, animDuration, millis(), (int) virtualMousePos.x, (int) virtualMousePos.y));
  System.out.println("Added new click @ " + mouseX + ", " + mouseY + " | VIRT: " + virtualMousePos.x + ", " + virtualMousePos.y);
}


void drawBackground(){
  background(155);

}