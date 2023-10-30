package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import BUS.NguoiDungBUS;
import DTO.NguoiDung;


class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
  
    private String label;
  
    private boolean isPushed;

    private JTable tb = new JTable();
    private int sr;
    private NguoiDungBUS nd_bus = new NguoiDungBUS();
    private NguoiDung nd = new NguoiDung();
    private JFrame userInfo;
    public static String check = "Tất Cả";
    public static boolean ischeck = false;

    private JTextField hoten;
    private JTextField tk;
    private JPasswordField mk;
    private JTextField mail;

    public ButtonEditor(JCheckBox checkBox, String check) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
        ButtonEditor.check = check;
        ButtonEditor.ischeck = true;
        ButtonDelete.ischeck = false;
    }
  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }
        else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
            this.tb = table;
            
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }
  
    public Object getCellEditorValue() {
        if (isPushed) {
            this.sr = tb.getSelectedRow();
            nd = nd_bus.getSelectUser(String.valueOf(tb.getValueAt(sr, 1)));
            userInfo();
        }
        isPushed = false;
        return new String(label);
    }
  
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
  
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    public void userInfo(){
        userInfo = new JFrame("Thông tin người dùng");
        JPanel pUser = new JPanel(null);

        JLabel txt_ma = new JLabel("Mã người dùng:");
        txt_ma.setBounds(30, 25, 100, 30);
        txt_ma.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_ma);
        JTextField ma = new JTextField(nd.getMaUser().trim());
        ma.setBounds(150, 23, 200, 25);
        ma.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ma.setEditable(false);
        pUser.add(ma);

        JLabel txt_hoten = new JLabel("Họ tên:");
        txt_hoten.setBounds(30, 75, 100, 30);
        txt_hoten.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_hoten);
        hoten = new JTextField(nd.getHoTen().trim());
        hoten.setBounds(150, 73, 200, 25);
        hoten.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //hoten.setEditable(false);
        pUser.add(hoten);

        JLabel txt_tk = new JLabel("Tài khoản:");
        txt_tk.setBounds(30, 125, 100, 30);
        txt_tk.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_tk);
        tk = new JTextField(nd.getUserName().trim());
        tk.setBounds(150, 123, 200, 25);
        tk.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //tk.setEditable(false);
        pUser.add(tk);

        JLabel txt_mk = new JLabel("Mật khẩu:");
        txt_mk.setBounds(30, 175, 100, 30);
        txt_mk.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_mk);
        mk = new JPasswordField(nd.getMatKhau().trim());
        mk.setEchoChar('*');
        mk.setBounds(150, 173, 200, 25);
        mk.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //mk.setEditable(false);
        pUser.add(mk);
        Icon opeye = new ImageIcon("img/icon_view.png");
        Icon cleye = new ImageIcon("img/icon_hide.png");
        JButton btn_disPass = new JButton(opeye);
        btn_disPass.setBounds(355, 175, 20, 20);
        btn_disPass.setFocusPainted(false);
        btn_disPass.setBorderPainted(false);
        btn_disPass.setBackground(Color.WHITE);
        btn_disPass.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				btn_disPass.setBackground(new Color(234,230,235));
			}
			public void mouseExited(MouseEvent e){
				btn_disPass.setBackground(Color.WHITE);
			}
		});
        btn_disPass.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e){
				if ( mk.getEchoChar() != '*' ) {
                    mk.setEchoChar('*');
                    btn_disPass.setIcon(opeye);
                } 
                else {
                    mk.setEchoChar((char)0);
                    btn_disPass.setIcon(cleye);
                }
			}
        });
        pUser.add(btn_disPass);

        JLabel txt_mail = new JLabel("Email:");
        txt_mail.setBounds(30, 225, 100, 30);
        txt_mail.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_mail);
        mail = new JTextField(nd.getEmail());
        mail.setBounds(150, 223, 200, 25);
        mail.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //tk.setEditable(false);
        pUser.add(mail);

        JLabel txt_nt = new JLabel("Ngày tạo:");
        txt_nt.setBounds(30, 275, 100, 30);
        txt_nt.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_nt);
        JTextField nt = new JTextField(String.valueOf(nd.getNgayTao()));
        nt.setBounds(150, 273, 200, 25);
        nt.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nt.setEditable(false);
        pUser.add(nt);

        JLabel txt_quyen = new JLabel("Quyền:");
        txt_quyen.setBounds(30, 325, 100, 30);
        txt_quyen.setFont(new Font("Tahoma", Font.BOLD, 13));
        pUser.add(txt_quyen);
        Vector<String> list_quyen = nd_bus.getQuyenEdit();
        int count=0;
		JComboBox<String> cb_quyen = new JComboBox<>(list_quyen);
        cb_quyen.setSelectedIndex(count);
        cb_quyen.setBounds(150, 323, 200, 25);
        cb_quyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //tk.setEditable(false);
        pUser.add(cb_quyen);

        JButton btn_save = new JButton("Lưu");
        btn_save.setBounds(310, 375, 70, 30);
        btn_save.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn_save.setFocusPainted(false);
        btn_save.setBorderPainted(false);
        btn_save.setBackground(new Color(234,230,235));
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                save();
            }
        });
        btn_save.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				btn_save.setBackground(new Color(191,181,194));
			}
			public void mouseExited(MouseEvent e){
				btn_save.setBackground(new Color(234,230,235));
			}
		});
        pUser.add(btn_save);


        pUser.setBackground(Color.WHITE);
        userInfo.setBackground(Color.WHITE);
        userInfo.add(pUser);
        userInfo.setSize(440,470);
        userInfo.setLocationRelativeTo(null);
        userInfo.setVisible(true);
        userInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void save(){
        String alert = "";
        String id = nd.getMaUser();
        if (!hoten.getText().trim().equals(nd.getHoTen().trim())){
            if (hoten.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Họ tên không được để trống", "Thông báo", JOptionPane.NO_OPTION);
                hoten.requestFocus();
                return;
            }
            if (nd_bus.editName(nd.getMaUser(), hoten.getText().trim())){
                alert += "Họ tên";
            }
            else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra\nHọ tên phải hơn 2 kí tự không có ký tự đặc biệt và số", "Thông báo", JOptionPane.NO_OPTION);
                hoten.requestFocus();
                return;
            }
        }
        if (!tk.getText().trim().equals(nd.getUserName().trim())){
            if (tk.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Tên tài khoản không được để trống", "Thông báo", JOptionPane.NO_OPTION);
                tk.requestFocus();
                return;
            }
            if (nd_bus.editAcc(nd.getMaUser(), tk.getText().trim())){
                alert += " Tài khoản";
            }
            else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra\nTên tài khoản phải gồm 4-10 kí tự, không dấu, không khoảng trắng và không ký tự đặc biệt", "Thông báo", JOptionPane.NO_OPTION);
                tk.requestFocus();
                return;
            }
        }
        String pass = "";
        for (char x : mk.getPassword()){
            pass += x;
        }
        if (!pass.equals(nd.getMatKhau().trim())){
            if (pass.equals("")){
                JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "Thông báo", JOptionPane.NO_OPTION);
                mk.requestFocus();
                return;
            }
            if (nd_bus.editPass(nd.getMaUser(), pass)){
                alert += " Mật khẩu";
            }
            else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra\nMật khẩu phải có 10-32 kí tự bao gồm chữ và số\n Ex: aloha123", "Thông báo", JOptionPane.NO_OPTION);
                mk.requestFocus();
                return;
            }
        }
        if (!mail.getText().trim().equals(nd.getEmail().trim())){
            if (mail.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Mail không được để trống", "Thông báo", JOptionPane.NO_OPTION);
                mail.requestFocus();
                return;
            }
            if (nd_bus.editMail(nd.getMaUser(), mail.getText().trim())){
                alert += " Mail";
            }
            else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra\nĐịnh dạng mail: abc@gmail.com", "Thông báo", JOptionPane.NO_OPTION);
                mail.requestFocus();
                return;
            }
        }
        if (alert != ""){
            JOptionPane.showMessageDialog(null, "Sửa "+alert+" thành công", "Thông báo", JOptionPane.NO_OPTION);
        }
        else
            JOptionPane.showMessageDialog(null, "Đã lưu thông tin", "Thông báo", JOptionPane.NO_OPTION);

        nd = nd_bus.getSelectUser(id);
        tb.getParent().getParent().getParent().getParent().add(new QuanLyTaiKhoan());
        tb.getParent().getParent().getParent().setVisible(false);
    }
}
  
