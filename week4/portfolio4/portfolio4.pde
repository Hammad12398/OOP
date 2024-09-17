float ballX; // X coordinate of the ball
float ballY; // Y coordinate of the ball
float ballWidth; // diameter of the ball
float speedX; // speed of movement in X direction
float speedY; // speed of movement in Y direction

float holeX; //
float holeY; // 
float holeWidth; 

void setup() {
  size(600, 600);
  // reset ball parameters, position and size
  ballX = 10;
  ballY = height/2;
  ballWidth = 60;
  // initialize the speed to random values
  initializeSpeed();
  initializeHole();
}

void draw() {
  background(127);
  // draw the ball
  drawColourCircle(ballX, ballY, ballWidth, color(255,0,0));
  // draw the hole
  drawColourCircle(holeX, holeY, holeWidth, color(0));
  // move the ball
  moveBall();
  // bounce the ball ( if necessary)
  bounceBall();
  
 
  if (checkCollide(ballX, ballY, ballWidth, holeX, holeY, holeWidth)) {
    initializeHole();
    initializeSpeed(); 
  }
}

void initializeSpeed() {
  speedX = random(5, 10);
  speedY = random(5, 10);
}

void drawColourCircle(float x, float y, float d, color c) {
  fill(c);
  ellipse(x, y, d, d);
}

void moveBall() {
  ballX += speedX;
  ballY += speedY;
  ballX = constrain(ballX, 0, width);
  ballY = constrain(ballY, 0, height);
}

void bounceBall() {
  if (ballX <= 0 || ballX >= width) {
    speedX = -speedX;
  }
  if (ballY <= 0 || ballY >= height) {
    speedY = -speedY;
  }
}

void keyPressed() {
  if (key == 'x' || key == 'X') {
    speedX = random(5, 10);
  } else if (key == 'y' || key == 'Y') {
    speedY = random(5, 10);
  }
}

void initializeHole() {
  holeX = random(0, width);
  holeY = random(0, height);
  holeWidth = random(100, 300);
}

float distance(float x1, float y1, float x2, float y2) {
  float side1 = x1 - x2;
  float side2 = y1 - y2;
  return sqrt(side1 * side1 + side2 * side2);
}

boolean checkCollide(float x1, float y1, float d1, float x2, float y2, float d2) {
  float distanceBetweenCenters = distance(x1, y1, x2, y2);
  return distanceBetweenCenters <= (d1/2 + d2/2);
}
