package view;

import javax.swing.*;

public class Gui_Button extends JButton{
    private int index;
    public static final String IMAGE = "/Users/mac/IdeaProjects/ManagerRoom/src/image/Room.png";

    public Gui_Button(int index) {
        this.index = index;
        setIcon(new ImageIcon(IMAGE));
        setText(index + "");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
