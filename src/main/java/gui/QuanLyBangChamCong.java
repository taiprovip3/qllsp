package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyBangChamCong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyBangChamCong frame = new QuanLyBangChamCong();
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
	public QuanLyBangChamCong() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCong_danhsach.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\qlbcc_notelist.png"));
		btnNewButton.setBounds(47, 11, 131, 96);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch BCC");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 110, 131, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCong_luachon.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\qlbcc_detail.png"));
		btnNewButton_1.setBounds(335, 11, 131, 96);
		contentPane.add(btnNewButton_1);
		
		JLabel lblQunLBcc = new JLabel("Nh\u1EADp li\u1EC7u BCC");
		lblQunLBcc.setForeground(new Color(0, 0, 0));
		lblQunLBcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLBcc.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblQunLBcc.setBounds(335, 110, 131, 22);
		contentPane.add(lblQunLBcc);
		
		JLabel lblchiTit = new JLabel("(CRUD)");
		lblchiTit.setForeground(new Color(0, 0, 0));
		lblchiTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblchiTit.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblchiTit.setBounds(335, 133, 131, 22);
		contentPane.add(lblchiTit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
		panel_1.setBounds(10, 247, 112, 63);
		contentPane.add(panel_1);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 100, 20);
		panel_1.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 37, 100, 20);
		panel_1.add(lblDate);
		
		JButton btnNewButton_2 = new JButton("Quay l\u1EA1i");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu.main(null);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(124, 252, 0));
		btnNewButton_2.setBackground(new Color(46, 139, 87));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(396, 276, 102, 34);
		contentPane.add(btnNewButton_2);
	}

}
