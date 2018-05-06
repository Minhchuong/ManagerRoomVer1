package view;

import javax.swing.*;
import java.awt.*;

public class Gui_SignIn extends JFrame {
    JTextField txtAccount;
    JPasswordField txtPassWord;
    JButton btnSignIn;
    public Gui_SignIn() throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Quan ly phong tro");

        // top panel
        JPanel panelTop = new JPanel(new FlowLayout());
        JLabel lblTop = new JLabel("Dang nhap");
        panelTop.add(lblTop);
        add(panelTop, BorderLayout.NORTH);
        
        // center panel
        JPanel panelCenter = new JPanel(new GridLayout(0,2));
        JLabel lblAccount = new JLabel("Tai Khoan: ");
        panelCenter.add(lblAccount);
        txtAccount = new JTextField(10);
        panelCenter.add(txtAccount);

        JLabel lblPassWord = new JLabel("mat khau: ");
        panelCenter.add(lblPassWord);
        txtPassWord = new JPasswordField(10);
        panelCenter.add(txtPassWord);

        add(panelCenter, BorderLayout.CENTER);

        // bottom panel;
        JPanel panelBottom = new JPanel(new FlowLayout());
        btnSignIn = new JButton("Dang nhap");
        panelBottom.add(btnSignIn);
        add(panelBottom,BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(500,500);
    }

    public JPasswordField getTxtPassWord() {
        return txtPassWord;
    }

    public void setTxtPassWord(JPasswordField txtPassWord) {
        this.txtPassWord = txtPassWord;
    }

    public JTextField getTxtAccount() {
        return txtAccount;
    }

    public void setTxtAccount(JTextField txtAccount) {
        this.txtAccount = txtAccount;
    }

    public JButton getBtnSignIn() {
        return btnSignIn;
    }

    public void setBtnSignIn(JButton btnSignIn) {
        this.btnSignIn = btnSignIn;
    }
}
