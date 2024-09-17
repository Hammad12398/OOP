boolean press;
String textToWrite ;
String textToWrite1 ;
float xPos ;
float yPos ;

void setup () {
size (200 , 300);
textToWrite1 = (" STOP  ");
textToWrite = (" WALK ");
}

void draw () {
if (press){ ;
background (0,255,0);
yPos = 150;
xPos = width /2;
textSize (20);
textAlign ( CENTER );
fill (0 , 0 ,0);
text ( textToWrite , xPos , yPos );
}
else{
background (255,0,0);
yPos = 150;
xPos = width /2;
textSize (20);
textAlign ( CENTER );
fill (0 , 0 ,0);
text ( textToWrite1 , xPos , yPos );
}}



void mousePressed() {
  if (press) { 
    press = false;
  } else {
    press = true; 
  }
}
