int CarX ;
int CarY ;
int red ;
int green;
int blue;
int opacity; 

void setup() {
size(400, 200);
 background(255);
red = int(random(255));
green = int(random(255));
blue = int(random(255));
opacity = int (random(255));
 noStroke();
}
void draw() { 
 fill(red,green,blue,opacity);
   background(255);
CarX= mouseX;
CarY =mouseY;

rect(CarX, CarY, 150, 75);
 ellipse(CarX+145, CarY+75, 50, 50);
 ellipse(CarX+10, CarY+75, 50, 50);
}
