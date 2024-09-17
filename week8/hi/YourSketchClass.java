import processing.core.PApplet;

public class YourSketchClass extends PApplet {
    String[] styleNames = {"dark", "light", "red", "blue"};
    StyleCollection styles;
    Style currentStyle;
    Button[] buttons;

    public static void main(String[] args) {
        PApplet.main("YourSketchClass");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        setupStyles();
        setupButtons();
    }

    public void draw() {
        background(currentStyle.getBackgroundColor());
        displayButtons();
    }

    void setupStyles() {
        styles = new StyleCollection();

        Style darkStyle = new Style("dark", color(30), color(150), color(20), color(255), 16);
        Style lightStyle = new Style("light", color(240), color(100), color(220), color(0), 16);
        Style redStyle = new Style("red", color(200, 0, 0), color(100), color(220), color(255), 16);
        Style blueStyle = new Style("blue", color(0, 0, 200), color(100), color(220), color(255), 16);

        styles.addStyle(darkStyle);
        styles.addStyle(lightStyle);
        styles.addStyle(redStyle);
        styles.addStyle(blueStyle);

        currentStyle = darkStyle;
        styles.setDefaultStyle(currentStyle);
    }

    void setupButtons() {
        buttons = new Button[styleNames.length];
        for (int i = 0; i < styleNames.length; i++) {
            float buttonX = i * width / styleNames.length;
            float buttonY = height - 50;
            float buttonWidth = width / styleNames.length;
            float buttonHeight = 50;

            buttons[i] = new Button(buttonX, buttonY, buttonWidth, buttonHeight);
            buttons[i].setText(styleNames[i]);
        }
    }

    void displayButtons() {
        for (Button button : buttons) {
            button.display(styles, this);
        }
    }

    @Override
    public void mousePressed() {
        for (Button button : buttons) {
            if (button.isInside(mouseX, mouseY)) {
                String label = button.getText();
                currentStyle = styles.getStyle(label);
            }
        }
    }
}
