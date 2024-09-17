class Catcher {
  private float catcherX;
  private float catcherY;
  private float catcherSpeed;
  private float catcherWidth;
  private float catcherHeight;
  private int catcherScore;
  private char catcherControl;

  public Catcher(float cSpeed, float cWidth, float cHeight) {
    catcherX = width/2;
    catcherY = height - cHeight/2;
    catcherSpeed = cSpeed;
    catcherWidth = cWidth;
    catcherHeight = cHeight;
    catcherScore = 0;
    catcherControl = 's';
  }

  public void display() {
    fill(255,0,0);
    rect(catcherX, catcherY, catcherWidth, catcherHeight);
  }

  public void move() {
    if (catcherControl == 'x') {
      catcherX += catcherSpeed;
    } else if (catcherControl == 'z') {
      catcherX -= catcherSpeed;
    }
    catcherX = constrain(catcherX, catcherWidth/2, width - catcherWidth/2);
  }

  public void checkCaught(Ball ball) {
    float ballX = ball.getX();
    float ballY = ball.getY();
    float ballWidth = ball.getWidth();

    if (ballY + ballWidth/2 > catcherY - catcherHeight/2 && ballX > catcherX - catcherWidth/2 && ballX < catcherX + catcherWidth/2) {
      increaseScore();
      ball.reset();
    }
  }

  public void increaseScore() {
    catcherScore++;
  }

  public int getScore() {
    return catcherScore;
  }

  public void setCatcherControl(char k) {
    catcherControl = k;
  }
}
