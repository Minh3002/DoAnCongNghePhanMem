package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;

public class DangNhap {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap window = new DangNhap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DangNhap() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 923, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(257, 47, 400, 369);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(105, 105, 105, 120));
		panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		
		JLabel _title = new JLabel("ĐĂNG NHẬP");
		panel.add(_title);
		_title.setBounds(164,136,83,30);
		
		JLabel avt = new JLabel("");
		avt.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\avt.png"));
		avt.setBounds(126,10,150,150);
		panel.add(avt);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().trim().toLowerCase().equals("username"))
				{
					txtUsername.setText("");
					txtUsername.setForeground(Color.black);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username"))
				{
					txtUsername.setText("username");
					txtUsername.setForeground(new Color(153,153,153));
				}
			}
		});
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsername.setText("username");
		txtUsername.setColumns(10);
		txtUsername.setBounds(108, 191, 184, 30);
		panel.add(txtUsername);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("");
		passwordField_1.setBounds(108, 238, 184, 30);
		panel.add(passwordField_1);
		
		
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangNhap.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDangNhap.setBackground(new Color(99, 184, 255));
			}
		});
		btnDangNhap.setBackground(new Color(99, 184, 255));
		btnDangNhap.setBounds(84, 285, 105, 21);
		panel.add(btnDangNhap);
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 191, 184, 19);
		panel.add(passwordField);
		
		JButton btnDangKyTk = new JButton("Bạn chưa có tài khoản?");
		btnDangKyTk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangKyTk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangKyTk.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDangKyTk.setBackground(new Color(238, 106, 167));
			}
		});
		btnDangKyTk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	
			}
		});
		btnDangKyTk.setBackground(new Color(238, 106, 167));
		btnDangKyTk.setBounds(108, 316, 184, 21);
		panel.add(btnDangKyTk);
		
		JButton btnKhach = new JButton("KHÁCH");
		btnKhach.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKhach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKhach.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKhach.setBackground(new Color(99, 184, 255));
			}
		});
		btnKhach.setBackground(new Color(99, 184, 255));
		btnKhach.setBounds(210, 285, 105, 21);
		panel.add(btnKhach);
		
		Border field_Border = BorderFactory.createMatteBorder(1,8, 1, 1, new Color(99, 184, 255));
		txtUsername.setBorder(field_Border);
		passwordField_1.setBorder(field_Border);
		
		
		JLabel icon_user = new JLabel("");
		icon_user.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\username.png"));
		icon_user.setBounds(68, 191, 30, 30);
		panel.add(icon_user);
		
		JLabel icon_pass = new JLabel("");
		icon_pass.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\pass.png"));
		icon_pass.setBounds(68, 238, 30, 30);
		panel.add(icon_pass);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\wall.png"));
		lblNewLabel.setBounds(0, 0, 909, 481);
		frame.getContentPane().add(lblNewLabel);
	}
}
