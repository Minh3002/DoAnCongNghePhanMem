package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DangKy extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	
	public static void main(String[] args) {
		new DangKy();
		
	}
	
	public DangKy() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(383, 114, 200, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(383, 156, 163, 19);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(383, 210, 163, 19);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(383, 268, 163, 19);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(383, 444, 163, 19);
		add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(319, 319, 70, 65);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(552, 319, 70, 65);
		add(panel_2);
		
		JButton btnNewButton = new JButton("Regisster");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(424, 520, 85, 30);
		add(btnNewButton);

	}
}
