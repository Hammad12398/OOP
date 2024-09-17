Car[] cars;  //<>//
RaceTrack track;
boolean raceOver;
int winningCarIndex = -1; 
void setup() {
  size(1000, 600);
  track = new RaceTrack();
  cars = new Car[5]; 
  for (int i = 0; i < cars.length; i++) {
    float xPos = track.getStartPosition() + i * 150; 
    float yPos = random(50, height - 100); 
    cars[i] = new Car(xPos, yPos, 60, color(200, 100, 100));
  }
  raceOver = false;
}
void draw() {
  background(70);
  track.display();
  for (int i = 0; i < cars.length; i++) {
    cars[i].display();
    if (!raceOver) {
      if (cars[i].getPosition() >= track.getFinishPosition()) {
        raceOver = true;
        winningCarIndex = i; 
        println("Press 's' to restart");
      } else {
        cars[i].move();
      }
    }
  }
}
void keyPressed() {
  if (key == 's' && raceOver) {
    float startLine = track.getStartPosition();
    for (int i = 0; i < cars.length; i++) {
      cars[i].setPosition(startLine);
    }
    raceOver = false;
    if (winningCarIndex != -1) {
      cars[winningCarIndex].increaseScore();
      winningCarIndex = -1; 
    }
  }
}
void detectWinners() {
  for (int i = 0; i < cars.length; i++) {
    if (cars[i].getPosition() >= track.getFinishPosition()) {
      cars[i].increaseScore();
    }
  }
}
void detectOneWinner() {
  float maxPosition = -1;
  int winningCarIndex = -1;
  for (int i = 0; i < cars.length; i++) {
    if (cars[i].getPosition() >= track.getFinishPosition() && cars[i].getPosition() > maxPosition) {
      maxPosition = cars[i].getPosition();
      winningCarIndex = i;
    }
  }
  if (winningCarIndex != -1) {
    cars[winningCarIndex].increaseScore();
  }
}
