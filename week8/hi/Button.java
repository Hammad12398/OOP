import processing.core.PApplet;

public class Button {
    private float x;
    private float y;
    private float w;
    private float h;
    private String label;

    public Button(float xp, float yp, float wd, float ht) {
        x = xp;
        y = yp;
        w = wd;
        h = ht;
    }

    public boolean isInside(float mx, float my) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    public void setText(String t) {
        label = t;
    }

    public String getText() {
        return label;
    }

    public void display(StyleCollection styles, PApplet p) {
        Style btnStyle = styles.getStyle(label);

        p.fill(btnStyle.getFillColor());
        p.stroke(btnStyle.getStrokeColor());
        p.strokeWeight(1);
        p.textSize(btnStyle.getTextSize());

        p.rect(x, y, w, h);
        p.fill(btnStyle.getTextColor());
        p.text(label, x + (w / 4), y + (h / 3));
    }
}
