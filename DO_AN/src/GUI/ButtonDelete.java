package GUI;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

import BUS.NguoiDungBUS;

public class ButtonDelete extends DefaultCellEditor {
    protected JButton button;
  
    private String label;
  
    private boolean isPushed;

    private JTable tb = new JTable();
    private int sr;
    private NguoiDungBUS nd_bus = new NguoiDungBUS();
    public static String check = "Tất Cả";
    public static boolean ischeck = false;

    public ButtonDelete(JCheckBox checkBox, String check) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
        ButtonDelete.check = check;
        ButtonEditor.ischeck = false;
        ButtonDelete.ischeck = true;
    }
  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }
        else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
            //table.setRowSelectionInterval(0, 0);
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
            deleAcc();
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

    public void deleAcc(){
        int op = JOptionPane.showConfirmDialog(null, "Xác nhận xóa tài khoản này?", "Thông báp", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION){
            if (nd_bus.deleAcc(String.valueOf(tb.getValueAt(sr, 1)))){
                JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công", "Thông báo", JOptionPane.NO_OPTION);
                //tb.getParent().getParent().getParent().setBackground(Color.GREEN);
                tb.getParent().getParent().getParent().getParent().add(new QuanLyTaiKhoan());
                tb.getParent().getParent().getParent().setVisible(false);

                
            }
            else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra, không thể xóa tài khoản", "Thông báo", JOptionPane.NO_OPTION);
            }
        }
        else{
            //
        }
    }
}
