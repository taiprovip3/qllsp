package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import util.GetLocalTime;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DuLieuKhac extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final String un) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DuLieuKhac frame = new DuLieuKhac(un);
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
	public DuLieuKhac(final String un) {
		setTitle("SalaryForm > menu > D\u1EEF li\u1EC7u t\u1EEB \u0111v kh\u00E1c");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachPB.png"));
		btnNewButton.setBounds(10, 37, 135, 81);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 767, 26);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("(!) D\u1EEF li\u1EC7u t\u1EEB \u0111\u01A1n v\u1ECB kh\u00E1c, b\u1EA1n s\u1EBD b\u1ECB h\u1EA1n ch\u1EBF c\u00E1c t\u00E1c v\u1EE5 nh\u01B0 CRUD");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 0, 747, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Danh s\u00E1ch PB");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 118, 135, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachPX.png"));
		btnNewButton_1.setBounds(155, 37, 135, 81);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh s\u00E1ch PX");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(155, 118, 135, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachHD.png"));
		btnNewButton_1_1.setBounds(300, 37, 135, 81);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DS H\u1EE3p \u0111\u1ED3ng");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(300, 118, 135, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachSP.png"));
		btnNewButton_1_2.setBounds(445, 37, 135, 81);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Danh s\u00E1ch SP");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(445, 118, 135, 26);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachNV.png"));
		btnNewButton_1_3.setBounds(10, 152, 135, 81);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("H\u1ED3 s\u01A1 NVHC");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(10, 233, 135, 26);
		contentPane.add(lblNewLabel_1_1_3);
		
		JButton btnNewButton_1_3_1 = new JButton("");
		btnNewButton_1_3_1.setIcon(new ImageIcon("E:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\danhsachCN.png"));
		btnNewButton_1_3_1.setBounds(155, 155, 135, 81);
		contentPane.add(btnNewButton_1_3_1);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("H\u1ED3 s\u01A1 C\u00F4ng nh\u00E2n");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_3_1.setBounds(155, 236, 135, 26);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		JButton btnNewButton_2 = new JButton("Quay l\u1EA1i");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangChu.main(un);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(647, 222, 110, 37);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47, 79, 79)));
		panel_1.setBounds(660, 34, 97, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setBounds(6, 16, 85, 17);
		panel_1.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setBounds(6, 32, 85, 17);
		panel_1.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
}