Ball ball;
Ball ball2;
Catcher catcher;

void setup() {
  size(800, 600);
  rectMode(CENTER);
  ball = new Ball(2, 30);
  ball2 = new Ball(2, 30);
  catcher = new Catcher(1, 140, 20);
}

void draw() {
  background(0);
  showScore();
  catcher.display();
  ball.display();
  ball2.display();
  catcher.move();
  ball.move();
  ball2.move();
  catcher.checkCaught(ball);
  catcher.checkCaught(ball2);
}

void showScore() {
  fill(255);
  textSize(20);
  int theScore = catcher.getScore();
  text("Score: " + theScore, 10, 50);
}

void keyPressed() {
  if (key == 'z' || key == 'x' || key == 's') {
    catcher.setCatcherControl(key);  
  }
}
