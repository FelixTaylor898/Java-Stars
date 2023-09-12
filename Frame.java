import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.Component;

class Frame {
    static JFrame frame;
    static JPanel panel, body, buttons;
    Galaxy galaxy;
        public Frame(Culture cult) {
        boolean inputAccepted = false;
        int res = 0;
        while (!inputAccepted) {
            try {
                String result = JOptionPane.showInputDialog(frame, "Enter number of stars:");
                res = Integer.parseInt(result);
                if (res < 1) {
                    throw new NumberFormatException();
                }
                galaxy = new Galaxy(cult, res);

                inputAccepted = true;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please input a positive integer");
            }
        }

        HashMap<String, Culture> map = new HashMap<>();
        map.put("Irö", Culture.IRO);
        map.put("Ævar", Culture.AEVAR);
        map.put("Yssyki", Culture.YSS);
        map.put("Iktijur", Culture.IKTI);
        String cultList[] = { "Irö", "Ævar", "Yssyki", "Iktijur", "Save" };
        JList<String> jlist = new JList<>(cultList);
        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jlist.getSelectedValue().equals("Save")) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Specify a file to save");
                    int userSelection = fileChooser.showSaveDialog(frame);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        String fileToSave = fileChooser.getSelectedFile().toString();
                        if (!fileToSave.endsWith(".txt"))
                            fileToSave += ".txt";
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave, true))) {
                            writer.write(galaxy.toString());
                            writer.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                        }
                    }
                } else {
                    frame.dispose();
                    new Frame(map.get(jlist.getSelectedValue()));
                }
            }
        });

        Font font = new Font("Arial", Font.PLAIN, 15);
        jlist.setFont(font);
        jlist.setBackground(new Color(137, 207, 240));
        jlist.setFixedCellHeight(50);
        jlist.setFixedCellWidth(50);
        jlist.setBorder(new EmptyBorder(10,10, 10, 10));
        jlist.setCellRenderer(getRenderer());


        JTextArea textField = new JTextArea(galaxy.toString());
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setSize(500, 500);

        textField.setFont(font);
        textField.setEditable(false);
        body = new JPanel();
        body.add(textField);

        JScrollPane scrollPane = new JScrollPane(body);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(300, 300));

        panel = new JPanel(new BorderLayout());
        panel.add(jlist, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.EAST);
        if (frame != null)
            frame.dispose();
        frame = new JFrame("Star Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel);
        frame.pack();
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setVisible(true);
    }

    private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                Object value, int index, boolean isSelected, boolean cellHasFocus) {
              JLabel listCellRendererComponent = (JLabel) super
                  .getListCellRendererComponent(list, value, index, isSelected,
                      cellHasFocus);
              listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0,
                  0, 1, 0, Color.BLACK));
              return listCellRendererComponent;
            }
          };
    }

}