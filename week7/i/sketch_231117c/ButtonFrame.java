import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CustomButton {
    float x;
    float y;
    float w;
    float h;

    CustomButton(float xp, float yp, float wd, float ht) {
        this.x = xp;
        this.y = yp;
        this.w = wd;
        this.h = ht;
    }

    void display(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, (int) w, (int) h);
    }
}

public class ButtonFrame extends JFrame {
    private CustomButton button1, button2;

    public ButtonFrame() {
        button1 = new CustomButton(50, 50, 100, 75);
        button2 = new CustomButton(250, 50, 100, 75);

        setLayout(new BorderLayout());
        add(new CustomPanel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonFrame());
    }

    class CustomPanel extends JPanel {
        public CustomPanel() {
            setPreferredSize(new Dimension(400, 300));

            JButton swingButton = new JButton("Click me!");
            swingButton.addActionListener(e -> System.out.println("Button Clicked!"));

            add(swingButton);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            button1.display(g);
            button2.display(g);
        }
    }
}
