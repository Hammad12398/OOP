// Style.java
public class Style {
    private String name;
    private int backgroundColor;
    private int strokeColor;
    private int fillColor;
    private int textColor;
    private int textSize;

    public Style(String name, int backgroundColor, int strokeColor, int fillColor, int textColor, int textSize) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.textColor = textColor;
        this.textSize = textSize;
    }

    public String getName() {
        return name;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public int getFillColor() {
        return fillColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextSize() {
        return textSize;
    }
}
