import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(String label, ActionListener listener) {
        super(label);
        addActionListener(listener);
    }
}
