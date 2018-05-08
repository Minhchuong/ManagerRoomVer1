package view;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import org.apache.poi.xwpf.usermodel.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gui_Bill extends JFrame{
    
    JTextField txtCouterMonth,txtNumberEle1,txtNumberEle2h,txtTotal;
    JDatePickerImpl datePickerDatePaid;
    JButton btnPayment;
    
    public Gui_Bill(int id) throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Quản lý phòng trọ ");

        JPanel paneltop = new JPanel(new FlowLayout());
        JLabel lblTitle = new JLabel("Tính tiền phòng " + id +": ");
        paneltop.add(lblTitle);
        add(paneltop,BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
        
        JLabel lblCouterMonth,lblDatePaid,lblTotal,lblNumberEle1,lblNumberEle2h;
        
        JPanel pnCouterMonth = new JPanel();
        lblCouterMonth = new JLabel("Số tháng: ");
        lblCouterMonth.setPreferredSize(new Dimension(120,20));
        pnCouterMonth.add(lblCouterMonth);
        txtCouterMonth = new JTextField(16);
        pnCouterMonth.add(txtCouterMonth);
        pnCenter.add(pnCouterMonth);

        JPanel pnDatePaid = new JPanel();
        lblDatePaid = new JLabel("Ngày trả ");
        lblDatePaid.setPreferredSize(new Dimension(120,20));
        pnDatePaid.add(lblDatePaid);
        SqlDateModel modelDatePaid = new SqlDateModel();
        JDatePanelImpl panelDatePaid = new JDatePanelImpl(modelDatePaid);
        datePickerDatePaid = new JDatePickerImpl(panelDatePaid);
        pnDatePaid.add(datePickerDatePaid);
        pnCenter.add(pnDatePaid);


        JPanel pnNumberEle1 = new JPanel();
        lblNumberEle1 = new JLabel("Số điện: ");
        lblNumberEle1.setPreferredSize(new Dimension(120,20));
        pnNumberEle1.add(lblNumberEle1);
        txtNumberEle1 = new JTextField(16);
        pnNumberEle1.add(txtNumberEle1);
        pnCenter.add(pnNumberEle1);

        JPanel pnNumberEle2h = new JPanel();
        lblNumberEle2h = new JLabel("Số nước: ");
        lblNumberEle2h.setPreferredSize(new Dimension(120,20));
        pnNumberEle2h.add(lblNumberEle2h);
        txtNumberEle2h = new JTextField(16);
        pnNumberEle2h.add(txtNumberEle2h);
        pnCenter.add(pnNumberEle2h);

        JPanel pnTotal = new JPanel();
        lblTotal = new JLabel("tổng tiền: ");
        lblTotal.setPreferredSize(new Dimension(120,20));
        pnTotal.add(lblTotal);
        txtTotal = new JTextField(16);
        txtTotal.setEnabled(false);
        pnTotal.add(txtTotal);
        pnCenter.add(pnTotal);

        add(pnCenter, BorderLayout.CENTER);

        JPanel pnbottom = new JPanel(new FlowLayout());
        btnPayment = new JButton("Thanh toán: ");
        pnbottom.add(btnPayment);
        add(pnbottom, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(300,100);
        this.pack();
        this.setVisible(true);
    }

    public JTextField getTxtCouterMonth() {
        return txtCouterMonth;
    }

    public void setTxtCouterMonth(JTextField txtCouterMonth) {
        this.txtCouterMonth = txtCouterMonth;
    }

    public JTextField getTxtNumberEle1() {
        return txtNumberEle1;
    }

    public void setTxtNumberEle1(JTextField txtNumberEle1) {
        this.txtNumberEle1 = txtNumberEle1;
    }

    public JTextField getTxtNumberEle2h() {
        return txtNumberEle2h;
    }

    public void setTxtNumberEle2h(JTextField txtNumberEle2h) {
        this.txtNumberEle2h = txtNumberEle2h;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    public JDatePickerImpl getDatePickerDatePaid() {
        return datePickerDatePaid;
    }

    public void setDatePickerDatePaid(JDatePickerImpl datePickerDatePaid) {
        this.datePickerDatePaid = datePickerDatePaid;
    }

    public JButton getBtnPayment() {
        return btnPayment;
    }

    public void setBtnPayment(JButton btnPayment) {
        this.btnPayment = btnPayment;
    }

    public static void main(String[] args) {
        //Gui_Constract gui_constract = new Gui_Constract();
        new Gui_Bill(1);
    }
}
