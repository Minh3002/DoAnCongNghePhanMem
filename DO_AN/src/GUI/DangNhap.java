package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhap {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

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
		
		JLabel _title = new JLabel("SIGN IN");
		panel.add(_title);
		_title.setBounds(172,137,83,30);
		
		JLabel avt = new JLabel("");
		avt.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\avt.png"));
		avt.setBounds(120,10,150,150);
		panel.add(avt);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(108, 191, 184, 30);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 238, 184, 30);
		panel.add(textField_1);
		
		
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setBackground(new Color(51, 153, 255));
		btnDangNhap.setBounds(84, 285, 105, 21);
		panel.add(btnDangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 191, 184, 19);
		panel.add(passwordField);
		
		JButton btnDangKyTk = new JButton("Bạn chưa có tài khoản?");
		btnDangKyTk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane optionPane = new JOptionPane("Is this what you need?", JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
                JDialog dialog = optionPane.createDialog("Dialog");
                dialog.setVisible(true);
			}
		});
		btnDangKyTk.setBackground(new Color(219,112,147));
		btnDangKyTk.setBounds(108, 316, 184, 21);
		panel.add(btnDangKyTk);
		
		JButton btnKhach = new JButton("KHÁCH");
		btnKhach.setBackground(new Color(51, 153, 255));
		btnKhach.setBounds(210, 285, 105, 21);
		panel.add(btnKhach);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\wall.png"));
		lblNewLabel.setBounds(0, 0, 909, 481);
		frame.getContentPane().add(lblNewLabel);
	}
}
