package view;

import javax.swing.*;

public class Gui_Button extends JButton{
    private int index;
    private boolean status;
    public static final String IMAGE = "/Users/mac/IdeaProjects/ManagerRoom/src/image/Room.png";
    public static final String IMAGE2 = "/Users/mac/IdeaProjects/ManagerRoom/src/image/RoomUnable.png";

    public Gui_Button(int index, boolean status) {
        this.index = index;
        this.status = status;
        if(status)setIcon(new ImageIcon(IMAGE));
        else setIcon(new ImageIcon(IMAGE2));
        setText(index + "");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
