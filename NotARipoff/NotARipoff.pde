private int hello = 0;

void setup() {
    size(600, 800);

}

void draw() {
    clear();
    background(30, 0);
    text(String.valueOf(frameRate), 10, 10, 100f, 100f);
    hello++;
    rect(hello, 20, 60, 30);
}
