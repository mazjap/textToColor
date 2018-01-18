import java.awt.*;

public class GetCharValue {
    private String letters;
    
    public GetCharValue(String letters) {
        this.letters = letters;
    }
    
    public Color color() {
        int charValue = 0;
        for (int i=0; i<letters.length(); i++) {
            charValue = charValue + letters.charAt(i);
        }
        String stuff = Integer.toString(charValue);
        String temp = "";
        String temp2 = "";
        int temp3;
        int temp4;
        int color1;
        int color2;
        int color3;
        while (true) {
            if (stuff.length() < 9) {
                charValue = charValue/2;
                stuff = stuff + Integer.toString(charValue);
            }
            if (stuff.length() > 9) {
                for (int i=0; i<=8; i++) {
                    temp = temp + stuff.charAt(i);
                }
                for (int i=temp.length(); i<(stuff.length()-temp.length()); i++) {
                    temp2 = temp2 + stuff.charAt(i);
                }
                temp3 = Integer.parseInt(temp);
                stuff = Integer.toString(temp3);
            }
            if (stuff.length() == 9) {
                temp = "";
                for (int i=0; i<=2; i++) {
                    temp = temp + stuff.charAt(i);
                }
                color1 = Integer.parseInt(temp);
                temp = "";
                for (int i=3; i<=5; i++) {
                    temp = temp + stuff.charAt(i);
                }
                color2 = Integer.parseInt(temp);
                temp = "";
                for (int i=6; i<=8; i++) {
                    temp = temp + stuff.charAt(i);
                }
                color3 = Integer.parseInt(temp);
                
                break;
            }
        }
        while (color1 > 255) {
            color1 = color1-100;
        }
        while (color2 > 255) {
            color2 = color2-100;
        }
        while (color3 > 255) {
            color3 = color3-100;
        }
        Color myColor = new Color(color1, color2, color3);
        return myColor;
    }
}