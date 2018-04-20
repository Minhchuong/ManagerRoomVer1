package controller;

import dao.Dao_Room;
import model.Room;
import view.Gui_Add;
import view.Gui_Button;
import view.Gui_Info;
import view.Gui_Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements ActionListener{

    ArrayList <Room> rooms = new ArrayList <>();
    Gui_Main gui_main;
    Gui_Info currentGui_Infor;


    public Controller() throws SQLException, ClassNotFoundException {
        init();
    }

    public void init() throws SQLException, ClassNotFoundException {
        Dao_Room dao = new Dao_Room();
        rooms = dao.getListRoom();
        gui_main = new Gui_Main();
        updateListRoom();
        gui_main.getBtnAdd().addActionListener(this);
    }


    public void updateListRoom() throws SQLException, ClassNotFoundException {

        // lay danh sach phong tu database
        Dao_Room dao = new Dao_Room();
        rooms = dao.getListRoom();
        ArrayList<Gui_Button> tmp = new ArrayList <>();

        for (Room room : rooms ) {
            tmp.add(new Gui_Button(room.getId()));
        }
        gui_main.setListButton(tmp);
        gui_main.updateButton();

        for (Gui_Button button: gui_main.getListButton() ) {
            button.setActionCommand("Room"+button.getIndex());
            button.addActionListener(this);
        }

    }



    public static void main(String[] str) throws SQLException, ClassNotFoundException {
        new Controller();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "ADD": addRoom(); break;
            case  "DELETE": deleteRoom();break;
            default: getRoom(e.getActionCommand()); break;
        }
    }

    private boolean deleteRoom() {
        Dao_Room dr = new Dao_Room();
        if(currentGui_Infor.isStatus()){
            JOptionPane.showMessageDialog(currentGui_Infor, "phong nay dang duoc thue khong the xoa");
            return false;
        }

        int option = JOptionPane.showConfirmDialog(currentGui_Infor, "ban co muon xoa phong " + currentGui_Infor.getId() + " khong ?");

        try {
        switch (option){
            case 0: dr.deleteRoom(currentGui_Infor.getId()); break;
            case 2: return false;
            case 1: return false;
        }
        currentGui_Infor.setVisible(false);
        updateListRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void addRoom() {
        Gui_Add gui_add = new Gui_Add();
        gui_add.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean staticRoom = gui_add.getCbStatus().isSelected();
                int price = 0;
                try {
                    price = Integer.parseInt(gui_add.getTxtPrice().getText());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(gui_main,"gia nhap khong chinh xac");
                    return;
                }

                if(price < 0){
                    JOptionPane.showMessageDialog(gui_main,"gia nhap khong chinh xac");
                    return;
                }
                Dao_Room dr = new Dao_Room();

                try {
                    dr.addRoom(staticRoom,price);
                    JOptionPane.showMessageDialog(gui_main,"them phong thanh cong quay lai danh sach");
                    gui_add.setVisible(false);
                    updateListRoom();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }


            }
        });

        gui_add.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_add.setVisible(false);
            }
        });
    }

    public void getRoom(String command) {
        // tach command
        int index = Integer.parseInt(command.substring(4));
        Dao_Room dr = new Dao_Room();
        try {
            Room room = dr.getRoom(index);

            currentGui_Infor = new Gui_Info(room.getId(),room.isStatus());
            currentGui_Infor.getTxtID().setText(room.getId()+"");
            currentGui_Infor.getCbStatus().setSelected(room.isStatus());
            currentGui_Infor.getTxtPrice().setText(room.getPrice() + "");
            currentGui_Infor.getBtnDelete().addActionListener(this);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
