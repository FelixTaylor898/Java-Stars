import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

class StartFrame {
    static JFrame frame;
    static JPanel panel, buttons;

    public StartFrame() {
        buttons = new JPanel(new GridLayout(4, 0));
        Font font = new Font("Arial", Font.PLAIN, 30);

        JButton iroButton = new JButton("Irö");
        iroButton.setFocusable(false);
        iroButton.setBackground(new Color(137, 207, 240));
        iroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new Frame(Culture.IRO);
            }
        });
        iroButton.setFont(font);

        JButton aevarButton = new JButton("Ævar");
        aevarButton.setFocusable(false);
        aevarButton.setBackground(new Color(137, 207, 240));
        aevarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new Frame(Culture.AEVAR);
            }
        });
        aevarButton.setFont(font);


        JButton yssykiButton = new JButton("Yssyki");
        yssykiButton.setFocusable(false);
        yssykiButton.setBackground(new Color(137, 207, 240));
        yssykiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new Frame(Culture.YSS);
            }
        });
        yssykiButton.setFont(font);


        JButton iktiButton = new JButton("Iktijur");
        iktiButton.setFocusable(false);
        iktiButton.setBackground(new Color(137, 207, 240));
        iktiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new Frame(Culture.IKTI);
            }
        });
        iktiButton.setFont(font);


        buttons.add(iroButton);
        buttons.add(aevarButton);
        buttons.add(yssykiButton);
        buttons.add(iktiButton);
        panel = new JPanel(new BorderLayout());
        panel.add(buttons);
        if (frame != null)
            frame.dispose();
        frame = new JFrame("Star Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel.setPreferredSize(new Dimension(300, 300));
        frame.add(panel);
        frame.pack();
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setVisible(true);
    }
}