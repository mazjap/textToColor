import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class ColorPicker extends JFrame {
    private JButton chooser;
    private Color c;
    private JPanel panel;
    
    public ColorPicker() {
        super("Text Color Picker");
        Scanner in = new Scanner(System.in);
        
        String s = in.nextLine();
        GetCharValue test1 = new GetCharValue(s);
        c = test1.color();
        if (s.equals("kill") || s.equals("KILL") || s.equals("Kill")) {
            c = Color.RED;
        }
        panel = new JPanel();
        panel.setBackground(c);
        chooser = new JButton("Choose a different color");
        
        chooser.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                c = JColorChooser.showDialog(null, "Pick Your Color", c);
                if (c==null) {
                    c = (Color.WHITE);
                }
                
                panel.setBackground(c);
            }
        }
        );
        
        add(panel, BorderLayout.CENTER);
        add(chooser, BorderLayout.SOUTH);
        setSize(425, 300);
        setVisible(true);
    }
}
