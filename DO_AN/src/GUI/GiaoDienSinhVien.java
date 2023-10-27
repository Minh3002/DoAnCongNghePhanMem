package GUI;

import java.awt.EventQueue;
import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

public class GiaoDienSinhVien {

	public static JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienSinhVien window = new GiaoDienSinhVien();
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
	public GiaoDienSinhVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 978, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		MenuSV a = new MenuSV();
		a.setBounds(-23, 0, 987, 582);
		frame.getContentPane().add(a);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 255));
		panel.setBounds(21, 0, 978, 91);
		a.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Avatar");
		btnNewButton.setBounds(809, 34, 85, 35);
		panel.add(btnNewButton);

		
		
//		GiaoDienLamBaiSV b = new GiaoDienLamBaiSV();
//		b.setBounds(0, 0, 978, 608);
//		frame.getContentPane().add(b);
		
	}
	
}
