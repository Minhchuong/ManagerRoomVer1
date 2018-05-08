package view;

import model.Customer;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Gui_AddContract extends JFrame{
    private int id_room;
    private JLabel lblTitle;
    private JTextField txtName, txtBirthDay, txtIdentify, txtAddress, txtJob, txtPhone;
    private JComboBox<Integer> cbbDateRentDay,cbbDateRentMonth,cbbDateRentYear,cbbDateOffDay,cbbDateOffMonth,cbbDateOffYear,cbbBirthDayDay,cbbBirthDayMonth,cbbBirthDayYear;
    private JDatePickerImpl datePickerRent,datePickerOff,datePickerBirthDay;
    private JTextField txtPreePay,txtPortPaid;
    private JTextArea txaDescription;

    private JButton btnAdd, btnCancel;

    public Gui_AddContract(int id_room) throws HeadlessException {

        setTitle("Tạo hợp đồng ");
        setLayout(new BorderLayout());


//        Integer[] day = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
//        Integer[] month = {1,2,3,4,5,6,7,8,9,10,11,12};
//        Integer[] year = new Integer[200];
//        for (int i = 0; i<200 ; i++) year[i] = 1900+i;



        JPanel pntop = new JPanel(new FlowLayout());
        pntop.add(new JLabel("Tao hợp đồng : " + id_room));
        pntop.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(pntop,BorderLayout.NORTH);

        JPanel pncenter = new JPanel(new GridLayout(0,2));

        JLabel lblName, lblBirthDay,lblIdentify, lblAddress,lblJob, lblPhone;
        lblName = new JLabel("Họ và tên ");
        pncenter.add(lblName);
        txtName = new JTextField(10);
        pncenter.add(txtName);



        // date

       


        lblBirthDay = new JLabel("Ngày Sinh ");
        pncenter.add(lblBirthDay);
        JPanel pnBirthDay = new JPanel();
        SqlDateModel modelBirthDay = new SqlDateModel();
        JDatePanelImpl panelBirthDay = new JDatePanelImpl(modelBirthDay);
        datePickerBirthDay = new JDatePickerImpl(panelBirthDay);
        pnBirthDay.add(datePickerBirthDay);
        pncenter.add(pnBirthDay);

        lblIdentify = new JLabel("Số chứng minh ");
        pncenter.add(lblIdentify);
        txtIdentify = new JTextField(10);
        pncenter.add(txtIdentify);

        lblAddress = new JLabel("địa chỉ ");
        pncenter.add(lblAddress);
        txtAddress = new JTextField(10);
        pncenter.add(txtAddress);

        lblJob = new JLabel("Công việc ");
        pncenter.add(lblJob);
        txtJob = new JTextField(10);
        pncenter.add(txtJob);

        lblPhone = new JLabel("điện thại ");
        pncenter.add(lblPhone);
        txtPhone = new JTextField(10);
        pncenter.add(txtPhone);

        pncenter.setBorder(BorderFactory.createTitledBorder("Phiếu thông tin khách hàng "));

        add(pncenter, BorderLayout.CENTER);




        JPanel pnright = new JPanel();

        pnright.setLayout(new BoxLayout(pnright,BoxLayout.Y_AXIS));

        JPanel pnDateRent = new JPanel(new FlowLayout());
        JLabel lblDateRent = new JLabel("Ngày thuê: ");
        lblDateRent.setPreferredSize(new Dimension(80,20));
        pnDateRent.add(lblDateRent);

        SqlDateModel modelDateRent = new SqlDateModel();
        JDatePanelImpl panelDateRent = new JDatePanelImpl(modelDateRent);
        datePickerRent = new JDatePickerImpl(panelDateRent);
        pnDateRent.add(datePickerRent);
//        cbbDateRentDay = new JComboBox(day);
//        cbbDateRentMonth = new JComboBox(month);
//        cbbDateRentYear = new JComboBox(year);
//        pnDateRent.add(cbbDateRentDay);
//        pnDateRent.add(cbbDateRentMonth);
//        pnDateRent.add(cbbDateRentYear);
        pnright.add(pnDateRent);


        JPanel pnDateOff = new JPanel(new FlowLayout());
        JLabel lblDateOff = new JLabel("Ngày trả: ");
        lblDateOff.setPreferredSize(new Dimension(80,20));
        pnDateOff.add(lblDateOff);

        SqlDateModel modelDateOff = new SqlDateModel();
        JDatePanelImpl panelDateOff = new JDatePanelImpl(modelDateOff);
        datePickerOff = new JDatePickerImpl(panelDateOff);
        pnDateOff.add(datePickerOff);

        pnright.add(pnDateOff);


        JPanel pnPreePay = new JPanel(new FlowLayout());
        JLabel lblPreePay = new JLabel("Trả trước: ");
        lblPreePay.setPreferredSize(new Dimension(80,20));
        pnPreePay.add(lblPreePay);
        txtPreePay = new JTextField();
        txtPreePay.setPreferredSize(new Dimension(240,20));
        pnPreePay.add(txtPreePay);
        pnright.add(pnPreePay);

        JPanel pnPortPaid = new JPanel(new FlowLayout());
        JLabel lblPortPaid = new JLabel("đã thanh toán: ");
        lblPortPaid.setPreferredSize(new Dimension(80,20));
        pnPortPaid.add(lblPortPaid);
        txtPortPaid = new JTextField();
        txtPortPaid.setPreferredSize(new Dimension(240,20));
        pnPortPaid.add(txtPortPaid);
        pnright.add(pnPortPaid);

        JPanel pnDescription = new JPanel(new FlowLayout());
        JLabel lblDescription = new JLabel("Ghi chú: ");
        lblDescription.setPreferredSize(new Dimension(80,20));
        pnDescription.add(lblDescription);
        txaDescription = new JTextArea();
        txaDescription.setPreferredSize(new Dimension(240,60));
        pnDescription.add(txaDescription);
        pnright.add(pnDescription);

        pnright.setBorder(BorderFactory.createTitledBorder("Hợp đồng "));
        add(pnright, BorderLayout.EAST);


        JPanel pnbottom = new JPanel(new FlowLayout());
        btnAdd = new JButton("thêm ");
        btnCancel = new JButton("Huỷ ");
        pnbottom.add(btnAdd);
        pnbottom.add(btnCancel);
        add(pnbottom, BorderLayout.SOUTH);

        setLocation(150,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
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

    public JComboBox <Integer> getCbbDateRentDay() {
        return cbbDateRentDay;
    }

    public void setCbbDateRentDay(JComboBox <Integer> cbbDateRentDay) {
        this.cbbDateRentDay = cbbDateRentDay;
    }

    public JComboBox <Integer> getCbbDateRentMonth() {
        return cbbDateRentMonth;
    }

    public void setCbbDateRentMonth(JComboBox <Integer> cbbDateRentMonth) {
        this.cbbDateRentMonth = cbbDateRentMonth;
    }

    public JComboBox <Integer> getCbbDateRentYear() {
        return cbbDateRentYear;
    }

    public void setCbbDateRentYear(JComboBox <Integer> cbbDateRentYear) {
        this.cbbDateRentYear = cbbDateRentYear;
    }

    public JComboBox <Integer> getCbbDateOffDay() {
        return cbbDateOffDay;
    }

    public void setCbbDateOffDay(JComboBox <Integer> cbbDateOffDay) {
        this.cbbDateOffDay = cbbDateOffDay;
    }

    public JComboBox <Integer> getCbbDateOffMonth() {
        return cbbDateOffMonth;
    }

    public void setCbbDateOffMonth(JComboBox <Integer> cbbDateOffMonth) {
        this.cbbDateOffMonth = cbbDateOffMonth;
    }

    public JComboBox <Integer> getCbbDateOffYear() {
        return cbbDateOffYear;
    }

    public void setCbbDateOffYear(JComboBox <Integer> cbbDateOffYear) {
        this.cbbDateOffYear = cbbDateOffYear;
    }

    public JTextField getTxtPreePay() {
        return txtPreePay;
    }

    public void setTxtPreePay(JTextField txtPreePay) {
        this.txtPreePay = txtPreePay;
    }

    public JTextField getTxtPortPaid() {
        return txtPortPaid;
    }

    public void setTxtPortPaid(JTextField txtPortPaid) {
        this.txtPortPaid = txtPortPaid;
    }

    public JTextArea getTxaDescription() {
        return txaDescription;
    }

    public void setTxaDescription(JTextArea txaDescription) {
        this.txaDescription = txaDescription;
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

    public JComboBox <Integer> getCbbBirthDayDay() {
        return cbbBirthDayDay;
    }

    public void setCbbBirthDayDay(JComboBox <Integer> cbbBirthDayDay) {
        this.cbbBirthDayDay = cbbBirthDayDay;
    }

    public JComboBox <Integer> getCbbBirthDayMonth() {
        return cbbBirthDayMonth;
    }

    public void setCbbBirthDayMonth(JComboBox <Integer> cbbBirthDayMonth) {
        this.cbbBirthDayMonth = cbbBirthDayMonth;
    }

    public JComboBox <Integer> getCbbBirthDayYear() {
        return cbbBirthDayYear;
    }

    public void setCbbBirthDayYear(JComboBox <Integer> cbbBirthDayYear) {
        this.cbbBirthDayYear = cbbBirthDayYear;
    }

    public JDatePickerImpl getDatePickerRent() {
        return datePickerRent;
    }

    public void setDatePickerRent(JDatePickerImpl datePickerRent) {
        this.datePickerRent = datePickerRent;
    }

    public JDatePickerImpl getDatePickerOff() {
        return datePickerOff;
    }

    public void setDatePickerOff(JDatePickerImpl datePickerOff) {
        this.datePickerOff = datePickerOff;
    }

    public JDatePickerImpl getDatePickerBirthDay() {
        return datePickerBirthDay;
    }

    public void setDatePickerBirthDay(JDatePickerImpl datePickerBirthDay) {
        this.datePickerBirthDay = datePickerBirthDay;
    }
}
