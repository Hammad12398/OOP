class Car {
  private float x;
  private float y;
  private color clr;
  private float theSize;
  private int score; 
  public Car(float xp, float yp, float size, color c) {
    theSize = size;
    setPosition(xp);
    y = yp;
    clr = c;
    score = 0; 
  }
  public void display() {
    float wheelOffset = theSize / 4;
    rectMode(CENTER);
    stroke(0);
    fill(clr);
    rect(x, y, theSize, theSize/2);
    fill(0);
    rect(x - wheelOffset, y - wheelOffset, wheelOffset, wheelOffset/2);
    rect(x + wheelOffset, y - wheelOffset, wheelOffset, wheelOffset/2);
    rect(x - wheelOffset, y + wheelOffset, wheelOffset, wheelOffset/2);
    rect(x + wheelOffset, y + wheelOffset, wheelOffset, wheelOffset/2);

    fill(255);
    textSize(20);
    textAlign(CENTER, CENTER);
    text(score, x, y);
  }
  public void move() {
    x = x + random(0, 10);
  }
  
  public float getPosition() {
    return x + theSize/2;
  }
  
  public void setPosition(float newPos) {
    x = newPos - theSize/2;
  }

  public void increaseScore() {
    score++;
  }
}
