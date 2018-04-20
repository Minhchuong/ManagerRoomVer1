package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;

public class Gui_AddContract extends JFrame{
    private JLabel lblTitle;
    private JTextField txtName, txtBirthDay, txtIdentify, txtAddress, txtJob, txtPhone;

    public Gui_AddContract() throws HeadlessException {

        setTitle("Them Hop Dong");
        setLayout(new BorderLayout());

        JPanel pntop = new JPanel(new FlowLayout());
        pntop.add(new JLabel("Them Hop Dong"));
        add(pntop,BorderLayout.NORTH);

        JPanel pncenter = new JPanel(new GridLayout(0,2));

        JLabel lblName, lblBirthDay,lblIdentify, lblAddress,lblJob, lblPhone;
        lblName = new JLabel("name");
        pncenter.add(lblName);
        txtName = new JTextField(10);
        pncenter.add(txtName);

        setLocation(150,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

    }
}
