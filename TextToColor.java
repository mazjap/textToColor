import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class TextToColor extends JFrame {
    static Scanner in = new Scanner(System.in);
    
    String myText;
    Color c;
    JPanel panel;
    
    public TextToColor(String text) {
        super("Color Picker");
        changeText(text);
        
        panel = new JPanel();
        panel.setBackground(c);
        JButton chooser = new JButton("Choose a different color");
        
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
        setLocationRelativeTo(null);
        setSize(425, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
    }
    
    public void getColor() {
        char tempChar;
        String tempString = "";
        int third = 0;
        for (int i=0; i<myText.length(); i++) {
            tempChar = myText.charAt(i);
            tempString += (int)tempChar;
        }
        while (tempString.length() < 9) {
            tempString += tempString;
        }
        third = tempString.length() / 3;
        String rString = tempString.substring(0, 3);
        String gString = tempString.substring(third, third+3);
        String bString = tempString.substring(tempString.length() - 4, tempString.length());
        
        int r = Integer.parseInt(rString);
        while (r > 255) {
            r /= 2;
        }
        int g = Integer.parseInt(gString);
        while (g > 255) {
            g /= 2;
        }
        int b = Integer.parseInt(bString);
        while (b > 255) {
            b /= 2;
        }
        c = new Color(r, g, b);
    }
    
    public void changeText(String newText) {
        this.myText = newText;
        getColor();
    }
    
    public static void main (String [] args) {
        System.out.println("Enter the text you would like to turn into color: (Press Enter without text to quit)");
        String tempText = in.nextLine();
        
        TextToColor color = new TextToColor(tempText);
    }
}
