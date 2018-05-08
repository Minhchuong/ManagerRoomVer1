package view;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class Gui_Add extends JFrame {
    private JLabel lblTitle,lblStatus,lblPrice;
    private JCheckBox cbStatus;
    private JTextField txtStatus,txtPrice;
    private JButton btnAdd,btnCancel;

    public Gui_Add() throws HeadlessException {
        setTitle("Thêm phòng: ");
        setLayout(new BorderLayout());

        // title
        JPanel panelTop = new JPanel(new FlowLayout());
        lblTitle = new JLabel("Thêm phòng: ");
        panelTop.add(lblTitle);
        add(panelTop,BorderLayout.NORTH);



        // trang thai
        JPanel panelCenter = new JPanel(new GridLayout(0,2));
        lblStatus = new JLabel("Trạng thái: ");
        panelCenter.add(lblStatus);

        cbStatus = new JCheckBox();
        cbStatus.isSelected();
        panelCenter.add(cbStatus);

        lblPrice = new JLabel("giá: ");
        txtPrice = new JTextField(10);
        panelCenter.add(lblPrice);
        panelCenter.add(txtPrice);
        add(panelCenter, BorderLayout.CENTER);


        JPanel panelBot = new JPanel(new FlowLayout());
        btnAdd = new JButton("thêm ");
        btnCancel = new JButton("huỷ ");
        panelBot.add(btnAdd);
        panelBot.add(btnCancel);
        add(panelBot, BorderLayout.SOUTH);

        setLocation(150,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JLabel getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public void setLblPrice(JLabel lblPrice) {
        this.lblPrice = lblPrice;
    }

    public JTextField getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(JTextField txtStatus) {
        this.txtStatus = txtStatus;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JCheckBox getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(JCheckBox cbStatus) {
        this.cbStatus = cbStatus;
    }

    public static void main(String[] str){
        new Gui_Add();
    }
}
