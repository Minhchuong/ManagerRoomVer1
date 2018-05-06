package view;

import javax.swing.*;
import java.awt.*;

public class Gui_Constract extends JFrame {
    Object[][] objects;
    JTextField txtTextField;
    JButton btnXoa;
    public Gui_Constract(Object[][] object) throws HeadlessException {
        //JTable
        setLayout(new BorderLayout());
        String[] titles = new String[]{"STT", "Chu phong tro","Ngay thue", "Ngay tra","tra truoc","Da thanh toan", "ten khach hang","ma phong"};
        this.objects = object;

        JTable table = new JTable(objects, titles);

        this.add(new JScrollPane(table),BorderLayout.CENTER);

        //panel bot
        JPanel pnbottom = new JPanel(new FlowLayout());
        JLabel lblXoa = new JLabel("Nhap ma hop dong muon xoa: ");
        pnbottom.add(lblXoa);
        txtTextField = new JTextField(10);
        pnbottom.add(txtTextField);
        btnXoa = new JButton("Xoa");
        pnbottom.add(btnXoa);
        add(pnbottom, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(300,100);
        setSize(1000,500);
        this.setVisible(true);

    }

    public Object[][] getObjects() {
        return objects;
    }

    public void setObjects(Object[][] objects) {
        this.objects = objects;
    }

    public JTextField getTxtTextField() {
        return txtTextField;
    }

    public void setTxtTextField(JTextField txtTextField) {
        this.txtTextField = txtTextField;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(JButton btnXoa) {
        this.btnXoa = btnXoa;
    }
}
