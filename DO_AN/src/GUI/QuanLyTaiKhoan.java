package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import BUS.NguoiDungBUS;
import DTO.NguoiDung;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


public class QuanLyTaiKhoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pMBar;
	private JButton btn_back;
	private JButton btn_home;
	private JTable tb;
    	DefaultTableModel model = new DefaultTableModel();

	NguoiDungBUS nd_bus = new NguoiDungBUS();
	Vector<NguoiDung> ndList = new Vector<NguoiDung>();
	Vector<NguoiDung> nd_per = new Vector<NguoiDung>();
	JComboBox<String> cb_quyen = new JComboBox<>();

	/**
	 * Create the panel.
	 */

     
	public QuanLyTaiKhoan() {
		setLayout(null);
        setBounds(0, 0, 1000, 600);
        //setVisible(false);
		pMBar = new JPanel(null);
		pMBar.setBounds(0, 0, 1000, 45);
		//pMBar.setOpaque(true);
		pMBar.setBackground(new Color(225,27,254));

		Icon back_icon = new ImageIcon("img/icon_back.png");
		btn_back = new JButton();
		btn_back.setIcon(back_icon);
		btn_back.setBounds(15, 8, 30, 30);
		btn_back.setBackground(new Color(225,27,254));
		btn_back.setBorderPainted(false);
        btn_back.setForeground(new Color(223,125,255));

		JLabel q = new JLabel();
		q.setBounds(760, 100, 170, 30);
		add(q);

		btn_back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				getParent().add(new QuanLyTaiKhoan());
                setVisible(false);
			}
		});
		btn_back.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				btn_back.setBackground(new Color(229,95,249));
			}
			public void mouseExited(MouseEvent e){
				btn_back.setBackground(new Color(225,27,254));
			}
		});
		pMBar.add(btn_back);

		Icon home_icon = new ImageIcon("img/icon_home.png");
		btn_home = new JButton();
		btn_home.setIcon(home_icon);
		btn_home.setBounds(65, 8, 30, 30);
		btn_home.setBackground(new Color(225,27,254));
		btn_home.setBorderPainted(false);

		btn_home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
		btn_home.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				btn_home.setBackground(new Color(229,95,249));
			}
			public void mouseExited(MouseEvent e){
				btn_home.setBackground(new Color(225,27,254));
			}
		});
		pMBar.add(btn_home);

		tb = new JTable();
		
        tb.setModel(model);
        String column[] = {"STT","Người dùng","Họ Tên","Email","Quyền","Ngày Tạo","Chỉnh sửa","Xóa"};
        for(String x:column){
            model.addColumn(x);
        }
        tb.setBounds(40,140,900,380);
        //tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tb.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb.getColumnModel().getColumn(3).setPreferredWidth(190);
        tb.getColumnModel().getColumn(4).setPreferredWidth(80);
        tb.getColumnModel().getColumn(5).setPreferredWidth(130);
        tb.getColumnModel().getColumn(6).setPreferredWidth(70);
        tb.getColumnModel().getColumn(7).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb.setDefaultEditor(Object.class, null);
		//AbstractBorder br = new T
		//centerRenderer.setBorder(br);

		Dimension dim = new Dimension(5, 30);
		tb.setIntercellSpacing(new Dimension(dim));

		centerRenderer.setBackground(new Color(234,230,235));
		tb.setRowHeight(120);
		tb.setDefaultRenderer(Object.class, centerRenderer); 
		tb.setShowGrid(false);
		tb.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		JTableHeader header = tb.getTableHeader();
		header.setBackground(new Color(234,230,235));
		header.setBorder(new EmptyBorder(0, 0, 0, 0));
		header.setPreferredSize(new Dimension(10, 37));
        JScrollPane sp = new JScrollPane(tb);
		tb.setBackground(Color.WHITE);
        sp.setBounds(40, 140, 900, 380);
		sp.setBorder(BorderFactory.createEmptyBorder());
        add(sp);
		
		Vector<String> list_quyen = nd_bus.getQuyen();
		cb_quyen = new JComboBox<>(list_quyen);
        cb_quyen.setBounds(40,70,100,30);
		int count = 0;
		for (String x : list_quyen){
			if (ButtonDelete.ischeck ){
				if(x.equals(ButtonDelete.check))
					break;
				else
					count++;
			}
			else if (ButtonEditor.ischeck){
				if (x.equals(ButtonEditor.check))
					break;
				else
					count++;
			}
		}
		cb_quyen.setBackground(new Color(234,230,235));
        cb_quyen.setEditable(false);
		cb_quyen.setSelectedIndex(count);
		loadData();
		cb_quyen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				loadData();
			}
		});
        add(cb_quyen);

		setBackground(Color.WHITE);
		setBounds(0,0,1000,600);
		add(pMBar);

	} 

    public void loadData(){
		String per = String.valueOf(cb_quyen.getSelectedItem());
		model.setRowCount(0);
		if (per.equals("Tất Cả")){
			ndList = nd_bus.getAllUser();
			int i=1;
			for (NguoiDung x : ndList){
				model.addRow(new Object[] {i,x.getMaUser(),x.getHoTen(),x.getEmail(),x.getQuyen(),x.getNgayTao()});
				i++;
			}
        	tb.getColumn("Chỉnh sửa").setCellRenderer(new ButtonEditRenderer());
        	tb.getColumn("Chỉnh sửa").setCellEditor(new ButtonEditor(new JCheckBox(),String.valueOf(cb_quyen.getSelectedItem())));
        	tb.getColumn("Xóa").setCellRenderer(new ButtonDeleRenderer());
        	tb.getColumn("Xóa").setCellEditor(new ButtonDelete(new JCheckBox(),String.valueOf(cb_quyen.getSelectedItem())));
		}
		else{
			nd_per = nd_bus.selectUserPer(per);
			int i=1;
			for (NguoiDung x : nd_per){
					model.addRow(new Object[] {i,x.getMaUser(),x.getHoTen(),x.getEmail(),x.getQuyen(),x.getNgayTao()});
					i++;
			}
        	tb.getColumn("Chỉnh sửa").setCellRenderer(new ButtonEditRenderer());
        	tb.getColumn("Chỉnh sửa").setCellEditor(new ButtonEditor(new JCheckBox(),String.valueOf(cb_quyen.getSelectedItem())));
    		tb.getColumn("Xóa").setCellRenderer(new ButtonDeleRenderer());
        	tb.getColumn("Xóa").setCellEditor(new ButtonDelete(new JCheckBox(),String.valueOf(cb_quyen.getSelectedItem())));
		}
    }
	/*
	public static void main(String[] args){
		JFrame f = new JFrame();

		f.getContentPane().add(new QuanLyTaiKhoan());
        	f.setSize(1000,600);
		f.setLocationRelativeTo(null);
        	f.setResizable(false);
		f.setVisible(true);
		f.setBackground(Color.WHITE);
        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	*/
}
