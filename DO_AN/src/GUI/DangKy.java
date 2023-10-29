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
import BUS.NguoiDungBUS;

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
import javax.swing.JRadioButton;

public class DangKy {

	private JFrame frame;
	private JTextField userName;
	private JPasswordField Password;
	private JTextField txtEmail;
	private JTextField txtMa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy window = new DangKy();
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
	public DangKy() {
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
		panel.setBounds(257, 20, 400, 431);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(105, 105, 105, 120));
		panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		
		JLabel lblNewLabel_2 = new JLabel("CREATE ACCOUNOUNT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(108, 20, 190, 21);
		panel.add(lblNewLabel_2);
		
//		username
		
		userName = new JTextField();
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent ev) {
				if(userName.getText().trim().toLowerCase().equals("username"))
				{
					userName.setText("");
					userName.setForeground(Color.black);
				}
			}
			
			@Override
			public void focusLost(FocusEvent ev) {
				if(userName.getText().trim().equals("") || 
						userName.getText().trim().toLowerCase().equals("username"))
				{
					userName.setText("username");
					userName.setForeground(new Color(153,153,153));
				}
			}
		});
		userName.setForeground(Color.LIGHT_GRAY);
		userName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userName.setText("username");
		userName.setColumns(10);
		userName.setBounds(108, 108, 184, 30);
		panel.add(userName);
		
		
//		email
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent ev) {
				if(txtEmail.getText().trim().toLowerCase().equals("email"))
				{
					txtEmail.setText("");
					txtEmail.setForeground(Color.black);
				}
			}
			
			@Override
			public void focusLost(FocusEvent ev) {
				if(txtEmail.getText().trim().equals("") || 
						txtEmail.getText().trim().toLowerCase().equals("email"))
				{
					txtEmail.setText("email");
					txtEmail.setForeground(new Color(153,153,153));
				}
			}
		});
		txtEmail.setForeground(Color.LIGHT_GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setText("email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(108, 180, 184, 30);
		panel.add(txtEmail);
		

//		password
		Password = new JPasswordField();
		Password.setToolTipText("");
		Password.setBounds(108, 247, 184, 30);
		panel.add(Password);
		
		JRadioButton rdoStudent = new JRadioButton("STUDENT");
		rdoStudent.setBackground(new Color(238, 106, 167));
		rdoStudent.setBounds(85, 302, 105, 21);
		panel.add(rdoStudent);
		
		JRadioButton rdoTeacher = new JRadioButton("TEACHER");
		rdoTeacher.setBackground(new Color(238, 106, 167));
		rdoTeacher.setBounds(207, 302, 105, 21);
		panel.add(rdoTeacher);

		
//		ma sv, ma gv
		txtMa = new JTextField();
		txtMa.setBounds(108, 353, 184, 30);
		panel.add(txtMa);
		txtMa.setColumns(10);
		
		Border field_Border = BorderFactory.createMatteBorder(1,8, 1, 1, new Color(99, 184, 255));
		userName.setBorder(field_Border);
		Password.setBorder(field_Border);
		txtEmail.setBorder(field_Border);
		txtMa.setBorder(field_Border);

		
//		dang ki
		JButton btnDangKy = new JButton("REGISTER");
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangKy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangKy.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDangKy.setBackground(new Color(99, 184, 255));
			}
		});
		
		
		btnDangKy.setBackground(new Color(99, 184, 255));
		btnDangKy.setBounds(151, 400, 105, 21);
		panel.add(btnDangKy);
		
		
		JLabel icon_user = new JLabel("");
		icon_user.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\username.png"));
		icon_user.setBounds(68, 108, 30, 30);
		panel.add(icon_user);
		
		JLabel icon_pass = new JLabel("");
		icon_pass.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\pass.png"));
		icon_pass.setBounds(68, 247, 30, 30);
		panel.add(icon_pass);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\username.png"));
		lblNewLabel_3.setBounds(68, 180, 30, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\username.png"));
		lblNewLabel_4.setBounds(68, 353, 30, 30);
		panel.add(lblNewLabel_4);
		
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(new Color(99, 184, 255));
		btnBack.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\icon_back.png"));
		btnBack.setBounds(10, 22, 30, 30);
		panel.add(btnBack);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\wall.png"));
		lblNewLabel.setBounds(0, 0, 909, 481);
		frame.getContentPane().add(lblNewLabel);
	}
}
