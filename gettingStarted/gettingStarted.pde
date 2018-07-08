public ArrayList<ClickyAnim> anims = new ArrayList<ClickyAnim>();

public int animDuration = 3000;
public int animMaxSize = 50;

void setup(){
  size(800, 600);
  rect(50, 50, 100, 200);
  frameRate(60);
}

void draw(){
  
  background(155);
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

}

void mousePressed() {


  anims.add(new ClickyAnim(animMaxSize, animDuration, millis(), mouseX, mouseY));
  System.out.println("Added new click @ " + mouseX + ", " + mouseY);
}
