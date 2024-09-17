class Ball {
  private float ballX;
  private float ballY;
  private float ballSpeed;
  private float ballWidth;

  public Ball(float bSpeed, float bWidth) {
    ballX = random(0, width);
    ballY = 0;
    ballSpeed = bSpeed;
    ballWidth = bWidth;
  }

  public void display() {
    fill(0,0,255);
    ellipse(ballX, ballY, ballWidth, ballWidth);
  }

  public void move() {
    ballY += ballSpeed;
    if (ballY > height + ballWidth/2) {
      reset();
    }
  }

  public void reset() {
    ballY = -ballWidth/2;
    ballX = random(width);
  }

  public float getX() {
    return ballX;
  }
  
  public float getY() {
    return ballY;
  }
  
  public float getWidth() {
    return ballWidth;
  }
}
