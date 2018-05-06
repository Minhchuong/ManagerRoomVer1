package controller;

import dao.Dao_Account;
import dao.Dao_Contract;
import dao.Dao_Customer;
import dao.Dao_Room;
import model.Account;
import model.Contract;
import model.Customer;
import model.Room;
import org.apache.poi.xwpf.usermodel.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements ActionListener{

    ArrayList <Room> rooms = new ArrayList <>();
    Gui_Main gui_main;
    Gui_Info currentGui_Infor;
    Account account;
    Gui_Constract gui_constract;


    public Controller() throws SQLException, ClassNotFoundException {
        init();
    }

    public void init() throws SQLException, ClassNotFoundException {
        Dao_Room dao = new Dao_Room();
        rooms = dao.getListRoom();
        gui_main = new Gui_Main();
        updateListRoom();
        gui_main.getBtnAdd().addActionListener(this);
        gui_main.getBtnConstract().addActionListener(this);

        if (!(account instanceof Account)){
            Gui_SignIn gui_signIn = new Gui_SignIn();
            gui_main.setVisible(false);
            gui_signIn.getBtnSignIn().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = gui_signIn.getTxtAccount().getText().replace(" ","");
                        String pass = gui_signIn.getTxtPassWord().getText().replace(" ", "");

                        if(name == null|| pass == null) JOptionPane.showMessageDialog(gui_signIn,"chua nhap username password");

                        signIn(name, pass);
                        if(account instanceof Account) {
                            gui_signIn.setVisible(false);
                            gui_main.setVisible(true);
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(gui_signIn,"nhap lai thong tin username va password");
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        JOptionPane.showMessageDialog(gui_signIn,"nhap lai thong tin username va password");
                        e1.printStackTrace();
                    }
                }
            });

        }



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
            case "DELETE": deleteRoom();break;
            case "ADDCONTRACT":createContract();break;
            case "UPDATE": updateRoom();break;
            case  "LISTCONSTRACT": getListConstract();break;
            default: getRoom(e.getActionCommand()); break;
        }
    }

    private boolean updateRoom() {
        Dao_Room dr = new Dao_Room();
        int option = JOptionPane.showConfirmDialog(currentGui_Infor, "Ban co muon sua phong  " + currentGui_Infor.getId() + " khong ?");


        try {
            int id = currentGui_Infor.getId();
            boolean status = currentGui_Infor.getCbStatus().isSelected();
            int price = Integer.parseInt(currentGui_Infor.getTxtPrice().getText());
            switch (option){
                case 0: if(!dr.updateRoom(id, status,price))JOptionPane.showMessageDialog(currentGui_Infor,"gia nhap vao khong dung"); break;
                case 2: return false;
                case 1: return false;
            }

            currentGui_Infor.setVisible(false);
            updateListRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(currentGui_Infor,"gia nhap vao khong dung");
        }
        return true;
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
        if(currentGui_Infor instanceof Gui_Info)currentGui_Infor.setVisible(false);
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
            currentGui_Infor.getBtnUpdate().addActionListener(this);

            if(!room.isStatus())currentGui_Infor.getBtnContract().addActionListener(this);
            if(room.isStatus()){
                Dao_Contract dc = new Dao_Contract();
                Contract contract = dc.getContractByIDRoom(index);
                currentGui_Infor.getTxtDateRent().setText(contract.getDate_rent() + "");
                currentGui_Infor.getTxtDateOff().setText(contract.getDate_off() + "");
                currentGui_Infor.getTxtPrepay().setText(contract.getPrepay() + "");
                currentGui_Infor.getTxtDescription().setText(contract.getDescription() + "");

                Customer customer = contract.getCustomer();
                currentGui_Infor.getTxtName().setText(customer.getName() + "");
                currentGui_Infor.getTxtBirthDay().setText(customer.getBirthDay() + "");
                currentGui_Infor.getTxtIdentify().setText(customer.getIdentify() + "");
                currentGui_Infor.getTxtJob().setText(customer.getJob());
                currentGui_Infor.getTxtPhone().setText("0"+customer.getNumberPhone());


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportToWord(String nameAdmin, Date dateAdmin, int identityAdmin, String addressAdmin, String nameCustomer, java.util.Date dateCustomer, int identityCustomer, String addressCustomer, int idroom, java.util.Date dateRent, java.util.Date dateOff, int priceOfRoom, int prepay, int id){

        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word

            XWPFDocument document = new XWPFDocument();



            //Bước 2: Tạo tiêu đề bài viết 1

            XWPFParagraph titleGraph = document.createParagraph();

            titleGraph.setAlignment(ParagraphAlignment.CENTER);

            String title = "CONG HOA XA HOI CHU NGHIA VIET NAM";

            XWPFRun titleRun = titleGraph.createRun();

            titleRun.setBold(true);

            titleRun.setText(title);

            // 2
            XWPFParagraph title2Graph = document.createParagraph();

            title2Graph.setAlignment(ParagraphAlignment.CENTER);

            String title2 = "Doc Lap - Tu do - Hanh Phuc";

            XWPFRun title2Run = title2Graph.createRun();

            title2Run.setBold(true);

            title2Run.setText(title2);
            
            title2Graph.setSpacingBefore(3);


            //Bước 3: Tạo đoạn văn bản 1 trong tài liệu

            XWPFParagraph paragraph1Graph = document.createParagraph();

            paragraph1Graph.setAlignment(ParagraphAlignment.CENTER);

            String paragraph1 = "HOP DONG THUE PHONG";

            XWPFRun paragraph1Run = paragraph1Graph.createRun();

            paragraph1Run.setBold(true);

            paragraph1Run.setFontSize(21);

            paragraph1Run.setText(paragraph1);
            
            paragraph1Graph.setSpacingAfter(10);

            //Bước 3: Tạo đoạn văn bản 1 trong tài liệu
            createLine(document,"Ben A: Ben cho thue", "bold");
            createLine(document,"Ho va ten: " + nameAdmin );
            createLine(document,"Nam sinh: " +dateAdmin.toString());
            createLine(document,"CMND: " + identityAdmin);
            createLine(document,"Dia chi" + addressAdmin);


            createLine(document,"Ben B: Ben the nha", "bold");
            createLine(document,"Ho va ten: " + nameCustomer );
            createLine(document,"Nam sinh: " +dateCustomer.toString());
            createLine(document,"CMND: " + identityCustomer);
            createLine(document,"Dia chi" + addressCustomer);

            createLine(document,"Hai ben thoa thuan va dong y voi noi dung sau");
            createLine(document,"Dieu 1:", "bold");
            createLine(document,"Ben a dong y cho ben b thue mot phong co ma so " + idroom);
            createLine(document,"Thoi han cho thue la tu ngay " + dateRent.toString() +" den ngay " + dateOff.toString());

            createLine(document,"Dieu 2:", "bold");
            createLine(document,"Gia tien thue phong la: "+ priceOfRoom + " VND/thang");
            createLine(document,"Ben B da tra truoc cho ben A khoan tien" + prepay);
            createLine(document,"So tien con lai trong hop dong ben B phai thanh toan cho ben A truoc ngay " + dateOff.toString());
            createLine(document,"Sau khi het han hop dong ben B co the thue tiep phong dang tro voi gia " + priceOfRoom + " va tra the tung thang." );
            createLine(document,"Tien nuoc, dien va phu phi se duoc thu vao ngay 1 tay dau thang.");
            createLine(document,"Ben B neu ngung hop dong truoc thoi han se phai tra toan bo so tien phong tuong ung trong thoi gian hop dong.");
            createLine(document,"Ben A neu ngung hop dong truoc thoi han se phai tra lai cho ben B toan bo so tien trong hop dong va den bu so tien tuong ung voi 1 thang tien phong.");

            createLine(document,"Dieu 3: Trach nhiem ben A.");
            createLine(document,"Gia nha va trang thiet bi dung ngay trong hop dong");
            createLine(document,"Hướng dẫn bên B chấp hành đúng các quy định của địa phương, hoàn tất mọi thủ tục giấy tờ đăng ký tạm trú cho bên B.");

            createLine(document,"Dieu 4: Trach nhiem ben B.");
            createLine(document,"Trả tiền thuê nhà hàng tháng theo hợp đồng.");
            createLine(document,"Sử dụng đúng mục đích thuê nhà, khi cần sữa chữa, cải tạo theo yêu cầu sử dụng riêng phải được sự đồng ý của bên A.");
            createLine(document,"Đồ đạt trang thiết bị trong nhà phải có trách nhiệm bảo quản cẩn thận không làm hư hỏng mất mát.");

            createLine(document,"Dieu 5: Dieu kien chung");
            createLine(document,"Bên A và bên B thực hiện đúng các điều khoản ghi trong hợp đồng.");
            createLine(document,"Trường hợp có tranh chấp hoặc một bên vi phạm hợp đồng thì hai bên cùng nhau bàn bạc giải quyết, nếu không giải quyết được thì yêu cầu cơ quan có thẩm quyền giải quyết.");
            createLine(document,"Hợp đồng được lập thành 02 bản có giá trị ngang nhau, mỗi bên giữ 01 bản.");
            createLine(document,"........, ngày...tháng...năm...","right");
            createLine(document,"Ben A                                       Ben B", "bold");

            // /Bước 4: Ghi dữ liệu ra file word

            FileOutputStream out = new FileOutputStream("src/image/Hop_Dong_Thue_Phong"+id+".docx");

            document.write(out);

            out.close();

            document.close();

        } catch (IOException ex) {
            System.out.println("loi");
        }

    }

    private void createLine(XWPFDocument document, String string){
        XWPFParagraph line = document.createParagraph();
        XWPFRun runline = line.createRun();
        runline.setText(string);
    }

    private void createLine(XWPFDocument document, String string , String type){
        XWPFParagraph line = document.createParagraph();
        XWPFRun runline = line.createRun();
        runline.setColor("FF0000");
        runline.setText(string);
        switch (type){
            case "bold" : runline.setBold(true); break;
            case "center" : line.setAlignment(ParagraphAlignment.CENTER); break;
            case "static" : runline.setItalic(true);break;
            case "underline" : runline.setUnderline(UnderlinePatterns.DASH_DOT_DOT_HEAVY);break;
            case "right": line.setAlignment(ParagraphAlignment.RIGHT);break;
            default:return;
        }
    }

    public void createContract(){
        Gui_AddContract gui_addContract = new Gui_AddContract(currentGui_Infor.getId());
        gui_addContract.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int option = JOptionPane.showConfirmDialog(gui_addContract, "Them hop dong " + currentGui_Infor.getId() + " khong ?");
                    if(option == 2||option==1) {
                        return;
                    }else  {

                        Date dateRent = (Date) gui_addContract.getDatePickerRent().getModel().getValue();
                        Date dateOff = (Date) gui_addContract.getDatePickerOff().getModel().getValue();
                        int prepay = Integer.parseInt(gui_addContract.getTxtPreePay().getText());
                        int portpaid = Integer.parseInt(gui_addContract.getTxtPortPaid().getText());
                        String description = gui_addContract.getTxaDescription().getText();

                        String name = gui_addContract.getTxtName().getText();
                        Date birthDay = (Date) gui_addContract.getDatePickerBirthDay().getModel().getValue();
                        int identify = Integer.parseInt(gui_addContract.getTxtIdentify().getText());
                        String address = gui_addContract.getTxtAddress().getText();
                        String job = gui_addContract.getTxtJob().getText();
                        int phone = Integer.parseInt(gui_addContract.getTxtPhone().getText());

                        //add customer.
                        Dao_Customer dao_customer = new Dao_Customer();
                        dao_customer.addCustomer(name, birthDay, identify, address, job, phone);
                        Customer customer = dao_customer.getLastCustomer();

                        //get Room.
                        Dao_Room dao_room = new Dao_Room();
                        Room room = dao_room.getRoom(currentGui_Infor.getId());
                        Dao_Contract dao_contract = new Dao_Contract();
                        Contract contract = new Contract();
                        contract.setDate_rent(dateRent);
                        contract.setDate_off(dateOff);
                        contract.setPortpaid(portpaid);
                        contract.setPrepay(prepay);
                        contract.setRoom(room);
                        contract.setCustomer(customer);
                        contract.setDescription(description);
                        dao_contract.addContrac(dateRent, dateOff, room, prepay, portpaid, description, customer);
                        room.setStatus(true);
                        dao_room.updateRoom(room.getId(), room.isStatus(), room.getPrice());
                        updateListRoom();
                        exportToWord("Abc",new Date(2012,12,12),241544173,"Abcd",customer.getName(),customer.getBirthDay(),customer.getIdentify(),customer.getAddress(),room.getId(),contract.getDate_rent(),contract.getDate_off(),room.getPrice(),contract.getPrepay(),room.getId());
                        gui_addContract.setVisible(false);
                        currentGui_Infor.setVisible(false);
                    }


                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(gui_addContract,"du lieu khong chinh xac");
                    return;
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(gui_addContract,"Khong the them vao csdl");
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (Exception e3){
                    JOptionPane.showMessageDialog(gui_addContract,"Khong the them vao csdl");
                }
            }
        });

        gui_addContract.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_addContract.setVisible(false);
            }
        });

    }

    public void getListConstract(){
            updateListContract();
            gui_constract.getBtnXoa().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = gui_constract.getTxtTextField().getText();
                    try {
                        Dao_Contract dao_contract = new Dao_Contract();
                        dao_contract.deleteContractByID(id);
                        gui_constract.setVisible(false);
                        updateListContract();
                        JOptionPane.showMessageDialog(gui_constract,"Xoa thanh cong");
                        updateListRoom();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            });

    }
    public void updateListContract(){
        try {
        Dao_Contract dao_contract = new Dao_Contract();
        ArrayList<Contract> contracts = null;

            contracts = dao_contract.getListConstract();

        Object[][] objects = new Object[contracts.size()][8];
        for (int i= 0; i<objects.length; i++){
            objects[i][0] = contracts.get(i).getId();
            objects[i][1] = account.getName();
            objects[i][2] = contracts.get(i).getDate_rent();
            objects[i][3] = contracts.get(i).getDate_off();
            objects[i][4] = contracts.get(i).getPrepay();
            objects[i][5] = contracts.get(i).getPortpaid();
            objects[i][6] = contracts.get(i).getCustomer().getName();
            objects[i][7] = contracts.get(i).getRoom().getId();
        }
        gui_constract = new Gui_Constract(objects);
        SwingUtilities.updateComponentTreeUI(gui_constract);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signIn(String name, String pass) throws SQLException, ClassNotFoundException {
        Dao_Account daoAccount = new Dao_Account();
        account = daoAccount.checkPassWordByNameAccount(name,md5(pass));
    }

    public static String md5(String str){
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    


}
