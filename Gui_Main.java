package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui_Main extends JFrame {

    private JLabel lblTop;
    private JPanel panelTop,panelBottom,panelCenter,panelRight,panelLeft;
    private JButton btnAdd,btnConstract;
    private ArrayList<Gui_Button> listButton = new ArrayList <Gui_Button>();


    public Gui_Main() throws HeadlessException {
        init();
    }

    public void init(){
        setLayout(new BorderLayout());
        setTitle("Quản lý phòng trọ ");


        // top panel
        panelTop = new JPanel(new FlowLayout());
        lblTop = new JLabel("Quản lý phòng trọ ");
        panelTop.add(lblTop);
        add(panelTop, BorderLayout.NORTH);

        // center panel
        panelCenter = new JPanel(new GridLayout(0,6));
        updateButton();
        add(panelCenter, BorderLayout.CENTER);

        // bottom panel
        panelBottom = new JPanel(new FlowLayout());
        btnAdd = new JButton("thêm vào ");
        btnAdd.setActionCommand("ADD");
        panelBottom.add(btnAdd);

        btnConstract = new JButton("hợp đồng ");
        btnConstract.setActionCommand("LISTCONTRACT");
        panelBottom.add(btnConstract);

        add(panelBottom, BorderLayout.SOUTH);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(100,100);
    }

    public void updateButton(){
        panelCenter.removeAll();
        ArrayList<Gui_Button> listButton = getListButton();
        for (Gui_Button button: listButton
             ) {
            panelCenter.add(button);
        }
        pack();
        SwingUtilities.updateComponentTreeUI(panelCenter);
    }

    public JLabel getLblTop() {
        return lblTop;
    }

    public void setLblTop(JLabel lblTop) {
        this.lblTop = lblTop;
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public void setPanelTop(JPanel panelTop) {
        this.panelTop = panelTop;
    }

    public JPanel getPanelBottom() {
        return panelBottom;
    }

    public void setPanelBottom(JPanel panelBottom) {
        this.panelBottom = panelBottom;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public void setPanelRight(JPanel panelRight) {
        this.panelRight = panelRight;
    }

    public JPanel getPanelLeft() {
        return panelLeft;
    }

    public void setPanelLeft(JPanel panelLeft) {
        this.panelLeft = panelLeft;
    }

    public ArrayList <Gui_Button> getListButton() {
        return listButton;
    }

    public void setListButton(ArrayList <Gui_Button> listButton) {
        this.listButton = listButton;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnConstract() {
        return btnConstract;
    }

    public void setBtnConstract(JButton btnConstract) {
        this.btnConstract = btnConstract;
    }

    public static void main(String str[]){
        Gui_Main gm = new Gui_Main();
        ArrayList<Gui_Button> listbutton = new ArrayList <Gui_Button>();

        gm.setListButton(listbutton);
        gm.updateButton();
        SwingUtilities.updateComponentTreeUI(gm);

    }
}
