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
    private JTextField txtName, txtBirthDay, txtIdentify, txtAddress,txtJob,txtPhone;
    private JTextField txtDateRent,txtDateOff,txtPrepay,txtPortpaid,txtDescription;

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
        
        // panel Room
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));

        JPanel panelRoom = new JPanel(new GridLayout(0,2));

        //id
        lblID = new JLabel("ID:");
        panelRoom.add(lblID);
        txtID = new JTextField(10);
        txtID.setEnabled(false);
        panelRoom.add(txtID);

        //status
        lblStatus = new JLabel("Status:");
        panelRoom.add(lblStatus);
        cbStatus = new JCheckBox();
        cbStatus.setEnabled(false);
        panelRoom.add(cbStatus);

        //price
        lblPrice = new JLabel("Price:");
        panelRoom.add(lblPrice);
        txtPrice = new JTextField(10);
        panelRoom.add(txtPrice);

        panelRoom.setBorder(BorderFactory.createTitledBorder("Phong thue"));
        panelCenter.add(panelRoom);
        add(panelCenter,BorderLayout.CENTER);
        
        //panel bottom
        JPanel panelBottom = new JPanel(new FlowLayout());
        
        //delete
        btnDelete = new JButton("Xoa");
        btnDelete.setActionCommand("DELETE");
        panelBottom.add(btnDelete);

        //Update
        btnUpdate = new JButton("Sua");
        btnUpdate.setActionCommand("UPDATE");
        panelBottom.add(btnUpdate);

        //Constract

        if(!status) {
            btnContract = new JButton("Them Hop Dong");
            btnContract.setActionCommand("ADDCONTRACT");
            panelBottom.add(btnContract);

        }

        if(status){

            // customer
            JPanel pnCustomer = new JPanel();
            pnCustomer.setLayout(new BoxLayout(pnCustomer,BoxLayout.Y_AXIS));

            JLabel lblName,lblBirthDay,lblIdentify,lblAddress, lblJob, lblPhone;

            JPanel pnName = new JPanel();
            lblName = new JLabel("Name");
            lblName.setPreferredSize(new Dimension(80,20));
            pnName.add(lblName);
            txtName = new JTextField(15);
            txtName.setEnabled(false);
            pnName.add(txtName);
            pnCustomer.add(pnName);

            JPanel pnBirthDay = new JPanel();
            lblBirthDay = new JLabel("BirthDay");
            lblBirthDay.setPreferredSize(new Dimension(80,20));
            pnBirthDay.add(lblBirthDay);
            txtBirthDay = new JTextField(15);
            txtBirthDay.setEnabled(false);
            pnBirthDay.add(txtBirthDay);
            pnCustomer.add(pnBirthDay);

            JPanel pnIdentify = new JPanel();
            lblIdentify = new JLabel("Identify");
            lblIdentify.setPreferredSize(new Dimension(80,20));
            pnIdentify.add(lblIdentify);
            txtIdentify = new JTextField(15);
            txtIdentify.setEnabled(false);
            pnIdentify.add(txtIdentify);
            pnCustomer.add(pnIdentify);

            JPanel pnAddress = new JPanel();
            lblAddress = new JLabel("Address");
            lblAddress.setPreferredSize(new Dimension(80,20));
            pnAddress.add(lblAddress);
            txtAddress = new JTextField(15);
            txtAddress.setEnabled(false);
            pnAddress.add(txtAddress);
            pnCustomer.add(pnAddress);

            JPanel pnJob = new JPanel();
            lblJob = new JLabel("Job");
            lblJob.setPreferredSize(new Dimension(80,20));
            pnJob.add(lblJob);
            txtJob = new JTextField(15);
            txtJob.setEnabled(false);
            pnJob.add(txtJob);
            pnCustomer.add(pnJob);

            JPanel pnPhone = new JPanel();
            lblPhone = new JLabel("Phone");
            lblPhone.setPreferredSize(new Dimension(80,20));
            pnPhone.add(lblPhone);
            txtPhone = new JTextField(15);
            txtPhone.setEnabled(false);
            pnPhone.add(txtPhone);
            pnCustomer.add(pnPhone);

            pnCustomer.setBorder(BorderFactory.createTitledBorder("Khach thue: "));
            add(pnCustomer, BorderLayout.EAST);

            //Contract
            JPanel pnContract = new JPanel();
            pnContract.setLayout(new BoxLayout(pnContract,BoxLayout.Y_AXIS));

            JLabel lblDateRent, lblDateOff,lblPrepay,lblPortpaid,lblDescription;

            JPanel pnDateRent = new JPanel();
            lblDateRent = new JLabel("DateRent");
            lblDateRent.setPreferredSize(new Dimension(80,20));
            pnDateRent.add(lblDateRent);
            txtDateRent = new JTextField(15);
            txtDateRent.setEnabled(false);
            pnDateRent.add(txtDateRent);
            pnContract.add(pnDateRent);

            JPanel pnDateOff = new JPanel();
            lblDateOff = new JLabel("DateOff");
            lblDateOff.setPreferredSize(new Dimension(80,20));
            pnDateOff.add(lblDateOff);
            txtDateOff = new JTextField(15);
            txtDateOff.setEnabled(false);
            pnDateOff.add(txtDateOff);
            pnContract.add(pnDateOff);


            JPanel pnPrepay = new JPanel();
            lblPrepay = new JLabel("Prepay");
            lblPrepay.setPreferredSize(new Dimension(80,20));
            pnPrepay.add(lblPrepay);
            txtPrepay = new JTextField(15);
            txtPrepay.setEnabled(false);
            pnPrepay.add(txtPrepay);
            pnContract.add(pnPrepay);

            JPanel pnPortpaid = new JPanel();
            lblPortpaid = new JLabel("Portpaid");
            lblPortpaid.setPreferredSize(new Dimension(80,20));
            pnPortpaid.add(lblPortpaid);
            txtPortpaid = new JTextField(15);
            txtPortpaid.setEnabled(false);
            pnPortpaid.add(txtPortpaid);
            pnContract.add(pnPortpaid);

            JPanel pnDescription = new JPanel();
            lblDescription = new JLabel("Description");
            lblDescription.setPreferredSize(new Dimension(80,20));
            pnDescription.add(lblDescription);
            txtDescription = new JTextField(15);
            txtDescription.setEnabled(false);
            pnDescription.add(txtDescription);
            pnContract.add(pnDescription);

            pnContract.setBorder(BorderFactory.createTitledBorder("Khach thue: "));
            panelCenter.add(pnContract);

            btnGetBill = new JButton("Xuat hoa don");
            panelBottom.add(btnGetBill);
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

    public JButton getBtnContract() {
        return btnContract;
    }

    public void setBtnContract(JButton btnContract) {
        this.btnContract = btnContract;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtBirthDay() {
        return txtBirthDay;
    }

    public void setTxtBirthDay(JTextField txtBirthDay) {
        this.txtBirthDay = txtBirthDay;
    }

    public JTextField getTxtIdentify() {
        return txtIdentify;
    }

    public void setTxtIdentify(JTextField txtIdentify) {
        this.txtIdentify = txtIdentify;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(JTextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    public JTextField getTxtJob() {
        return txtJob;
    }

    public void setTxtJob(JTextField txtJob) {
        this.txtJob = txtJob;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public JTextField getTxtDateRent() {
        return txtDateRent;
    }

    public void setTxtDateRent(JTextField txtDateRent) {
        this.txtDateRent = txtDateRent;
    }

    public JTextField getTxtDateOff() {
        return txtDateOff;
    }

    public void setTxtDateOff(JTextField txtDateOff) {
        this.txtDateOff = txtDateOff;
    }

    public JTextField getTxtPrepay() {
        return txtPrepay;
    }

    public void setTxtPrepay(JTextField txtPrepay) {
        this.txtPrepay = txtPrepay;
    }

    public JTextField getTxtPortpaid() {
        return txtPortpaid;
    }

    public void setTxtPortpaid(JTextField txtPortpaid) {
        this.txtPortpaid = txtPortpaid;
    }

    public JTextField getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(JTextField txtDescription) {
        this.txtDescription = txtDescription;
    }

    public static void main(String str[]){
        new Gui_Info(1,false);
    }
}
