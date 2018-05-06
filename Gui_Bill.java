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
    
    JTextField txtCouterMonth;
    JDatePickerImpl datePickerDatePaid;
    
    public Gui_Bill(int id) throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Quan ly phong tro");

        JPanel paneltop = new JPanel(new FlowLayout());
        JLabel lblTitle = new JLabel("Tinh tien phong" + id +": ");
        paneltop.add(lblTitle);
        add(paneltop,BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
        
        JLabel lblCouterMonth,lblDatePaid;
        
        JPanel pnCouterMonth = new JPanel();
        lblCouterMonth = new JLabel("CouterMonth");
        lblCouterMonth.setPreferredSize(new Dimension(120,20));
        pnCouterMonth.add(lblCouterMonth);
        txtCouterMonth = new JTextField(15);
        txtCouterMonth.setEnabled(false);
        pnCouterMonth.add(txtCouterMonth);
        pnCenter.add(pnCouterMonth);

        JPanel pnDatePaid = new JPanel();
        lblDatePaid = new JLabel("Ngay Sinh");
        lblCouterMonth.setPreferredSize(new Dimension(120,20));
        pnDatePaid.add(lblDatePaid);
        SqlDateModel modelDatePaid = new SqlDateModel();
        JDatePanelImpl panelDatePaid = new JDatePanelImpl(modelDatePaid);
        datePickerDatePaid = new JDatePickerImpl(panelDatePaid);
        pnDatePaid.add(datePickerDatePaid);
        pnCenter.add(pnDatePaid);

        add(pnCenter,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,100);
        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        //Gui_Constract gui_constract = new Gui_Constract();
        new Gui_Bill(1);
    }
}
