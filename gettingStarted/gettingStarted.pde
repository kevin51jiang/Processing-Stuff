ArrayList<int[]> clickySpots = new ArrayList<int[]>();
ArrayList<ClickyAnim> anims = new ArrayList<ClickyAnim>();

public int animDuration = 3000;
public int animMaxSize = 50;

void setup(){
  size(800, 600);
  rect(50, 50, 100, 200);
  frameRate(60);
}

void draw(){
  
  background(155);
  
  for(int i = 0; i < anims.size(); i++){
    int currentDia = anims.get(i).getSize(millis());
    System.out.println(currentDia);
    ellipse(clickySpots.get(i)[0], clickySpots.get(i)[1], currentDia, currentDia);
  }
}

void mousePressed() {
  int[] arr = new int[2];
  arr[0] = mouseX;
  arr[1] = mouseY;
  clickySpots.add(arr);
  anims.add(new ClickyAnim(animMaxSize, animDuration, millis()));
}
