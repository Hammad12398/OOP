// StyleCollection.java
import java.util.HashMap;

public class StyleCollection {
    private HashMap<String, Style> styles;
    private Style defaultStyle;

    public StyleCollection() {
        styles = new HashMap<>();
    }

    public void addStyle(Style style) {
        styles.put(style.getName(), style);
    }

    public Style getStyle(String key) {
        return styles.get(key);
    }

    public Style getDefaultStyle() {
        return defaultStyle;
    }

    public void setDefaultStyle(Style style) {
        defaultStyle = style;
    }
}
