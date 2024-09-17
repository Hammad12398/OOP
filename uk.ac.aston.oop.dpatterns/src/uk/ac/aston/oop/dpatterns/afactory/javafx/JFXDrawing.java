package uk.ac.aston.oop.dpatterns.afactory.javafx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.ac.aston.oop.dpatterns.afactory.Drawing;

public class JFXDrawing implements Drawing {
    private final Group group;
    private final Rectangle background;

    public JFXDrawing(Group group, int width, int height) {
        this.group = group;
        this.background = new Rectangle(width, height);
        initializeBackground();
    }

    private void initializeBackground() {
    
        background.setFill(Color.TRANSPARENT);
        group.getChildren().add(background);
    }

    @Override
    public void setFill(int r, int g, int b) {

        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));

       
        background.setFill(Color.rgb(r, g, b));
    }

    public void clear() {
    
        group.getChildren().clear();
        initializeBackground(); 
    }

   
}
