package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Gui_Info extends JFrame{
    private int id;
    private boolean status;
    private JLabel lblID, lblStatus, lblPrice;
    private JTextField txtID,txtPrice;
    private JCheckBox cbStatus;
    private JButton btnDelete, btnUpdate, btnGetBill, btnContract;

    public Gui_Info(int id, boolean status) throws HeadlessException {
        this.id = id;
        this.status = status;
        setTitle("Thong tin phong");
        setLayout(new BorderLayout());


        // panel top
        JPanel paneltop = new JPanel(new FlowLayout());
        JLabel lblTitle = new JLabel("Thong tin phong" + id +": ");
        paneltop.add(lblTitle);
        add(paneltop,BorderLayout.NORTH);

        


        // panel center
        JPanel panelCenter = new JPanel(new GridLayout(0,2));

        //id
        lblID = new JLabel("ID:");
        panelCenter.add(lblID);
        txtID = new JTextField(10);
        txtID.setEnabled(false);
        panelCenter.add(txtID);

        //status
        lblStatus = new JLabel("Status:");
        panelCenter.add(lblStatus);
        cbStatus = new JCheckBox();
        panelCenter.add(cbStatus);

        //price
        lblPrice = new JLabel("Price:");
        panelCenter.add(lblPrice);
        txtPrice = new JTextField(10);
        panelCenter.add(txtPrice);
        
        add(panelCenter,BorderLayout.CENTER);
        
        //panel bottom
        JPanel panelBottom = new JPanel(new FlowLayout());
        
        //delete
        btnDelete = new JButton("Xoa");
        btnDelete.setActionCommand("DELETE");
        panelBottom.add(btnDelete);

        //Update
        btnUpdate = new JButton("Sua");
        btnUpdate.setActionCommand("Update");
        panelBottom.add(btnUpdate);

        //GetBill

        if(!status) {
            btnContract = new JButton("Them Hop Dong");
            btnContract.setActionCommand("ADDCONTRACT");
            panelBottom.add(btnContract);

        }

        add(panelBottom, BorderLayout.SOUTH);

        setLocation(120,120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        pack();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
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

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JCheckBox getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(JCheckBox cbStatus) {
        this.cbStatus = cbStatus;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JButton getBtnGetBill() {
        return btnGetBill;
    }

    public void setBtnGetBill(JButton btnGetBill) {
        this.btnGetBill = btnGetBill;
    }

    public static void main(String str[]){
        new Gui_Info(1,false);
    }
}
