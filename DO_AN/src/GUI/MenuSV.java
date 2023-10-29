package GUI;

import javax.swing.JPanel;


import GUI.GiaoDienSinhVien;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuSV extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MenuSV() {
		
		
		setLayout(null);

//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("D:\\DoAnCongNghePhanMem\\DO_AN\\img\\lambai.png"));
//		lblNewLabel.setBounds(159, 449, 50, 50);
//		add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("Làm bài");
		btnNewButton.setBackground(new Color(166,244,255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				GiaoDienLamBaiSV b = new GiaoDienLamBaiSV();
			    b.setBounds(0, 0, 1000, 600);			    
			    GiaoDienSinhVien.frame.getContentPane().add(b);
			    GiaoDienSinhVien.frame.revalidate();
			    GiaoDienSinhVien.frame.repaint();
			    GiaoDienSinhVien.frame.getContentPane().remove(MenuSV.this);
				
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(117, 399, 133, 126);
		add(btnNewButton);
		
		JButton btnLchKimTra = new JButton("Lịch Kiểm Tra");
		btnLchKimTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnLchKimTra.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLchKimTra.setBackground(new Color(166,244,255));
		btnLchKimTra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLchKimTra.setBounds(550, 242, 133, 126);
		add(btnLchKimTra);
			
		JButton btnNhm = new JButton("Nhóm");
		btnNhm.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNhm.setBackground(new Color(166,244,255));
		btnNhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhm.setBounds(336, 326, 133, 126);
		add(btnNhm);
		
		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setVerticalAlignment(SwingConstants.BOTTOM);
		btnThngK.setBackground(new Color(166,244,255));
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThngK.setBounds(758, 168, 133, 126);
		add(btnThngK);
	}

	private void setIconImage(Image imgLamBai) {
		// TODO Auto-generated method stub
		
	}


}
