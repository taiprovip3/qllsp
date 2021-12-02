package qllsp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class QuanLyDonNghi extends JFrame {

	private JPanel contentPane;
	private JTable tblDonNghi;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyDonNghi frame = new QuanLyDonNghi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyDonNghi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1398, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 385, 1382, 350);
		contentPane.add(scrollPane);
		
		tblDonNghi = new JTable();
		tblDonNghi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblDonNghi.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0111\u01A1n ngh\u1EC9", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Lo\u1EA1i nh\u00E2n vi\u00EAn", "Ng\u00E0y ngh\u1EC9", "L\u00FD do", "C\u00F3 ph\u00E9p"
			}
		));
		scrollPane.setViewportView(tblDonNghi);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 11, 96, 76);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(116, 11, 96, 76);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(1276, 11, 96, 76);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 90, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQunLBcc = new JLabel("Qu\u1EA3n l\u00FD BCC");
		lblQunLBcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLBcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQunLBcc.setBounds(116, 92, 96, 14);
		contentPane.add(lblQunLBcc);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setBounds(1170, 11, 96, 76);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblTyChn = new JLabel("T\u00F9y ch\u1ECDn");
		lblTyChn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTyChn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTyChn.setBounds(1276, 91, 96, 14);
		contentPane.add(lblTyChn);
		
		JLabel lblCit = new JLabel("C\u00E0i \u0111\u1EB7t");
		lblCit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCit.setBounds(1170, 91, 96, 14);
		contentPane.add(lblCit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(60, 179, 113)));
		panel.setBounds(651, 0, 108, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(6, 16, 96, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(6, 39, 96, 22);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 115, 1382, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 \u0111\u01A1n ngh\u1EC9:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 134, 96, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(116, 136, 275, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 175, 103, 30);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(522, 134, 275, 30);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NV1", "NV2", "NV3", "NV4", "NV5", "NV6", "NV7", "NV8", "NV9", "NV10"}));
		comboBox.setBounds(116, 175, 275, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(401, 132, 111, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Lo\u1EA1i nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(401, 173, 111, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(522, 175, 275, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Ng\u00E0y ngh\u1EC9:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(807, 134, 77, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("L\u00FD do:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1.setBounds(807, 175, 77, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"B\u1EC7nh t\u1EADt", "C\u00F3 \u0111\u00E1m", "H\u01B0 xe", "Ho\u00E0n c\u1EA3nh gia \u0111\u00ECnh", "Thai s\u1EA3n", "B\u1ECB \u0111\u00ECnh ch\u1EC9", "\u0110i h\u1ECDc", "Kh\u00E1c"}));
		comboBox_1_1.setBounds(894, 177, 275, 30);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Lo\u1EA1i ngh\u1EC9:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(1179, 175, 77, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3 ph\u00E9p", "Kh\u00F4ng ph\u00E9p"}));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox_2.setBounds(1259, 175, 113, 30);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_2 = new JButton("Th\u00EAm");
		btnNewButton_2.setForeground(new Color(60, 179, 113));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(0, 337, 138, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("S\u1EEDa ch\u1ECDn");
		btnNewButton_2_1.setForeground(new Color(60, 179, 113));
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(148, 337, 138, 37);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("X\u00F3a r\u1ED7ng");
		btnNewButton_2_1_1.setForeground(new Color(60, 179, 113));
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2_1_1.setBounds(296, 337, 138, 37);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("X\u00F3a ch\u1ECDn");
		btnNewButton_2_1_2.setForeground(new Color(60, 179, 113));
		btnNewButton_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2_1_2.setBounds(444, 337, 138, 37);
		contentPane.add(btnNewButton_2_1_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Kh\u00F3a nh\u1EADp");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(0, 307, 138, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1057, 337, 209, 37);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton_4.setBounds(1276, 337, 96, 37);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2_1_2_1 = new JButton("In b\u1EA3ng .txt");
		btnNewButton_2_1_2_1.setForeground(new Color(60, 179, 113));
		btnNewButton_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2_1_2_1.setBounds(592, 337, 138, 37);
		contentPane.add(btnNewButton_2_1_2_1);
	}
}
