package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyBangChamCong quanLyBangChamCong =new QuanLyBangChamCong();
				quanLyBangChamCong.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 111, 75);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Q.L B\u1EA3ng CC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 74, 111, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(121, 0, 111, 75);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTnhLng = new JLabel("T\u00EDnh L\u01B0\u01A1ng");
		lblTnhLng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnhLng.setBounds(121, 74, 111, 24);
		contentPane.add(lblTnhLng);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(242, 0, 111, 75);
		contentPane.add(btnNewButton_2);
		
		JLabel lblThngK = new JLabel("Th\u1ED1ng k\u00EA");
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setBounds(242, 74, 111, 24);
		contentPane.add(lblThngK);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(725, 0, 111, 75);
		contentPane.add(btnNewButton_3);
		
		JLabel lblCit = new JLabel("T\u00F9y ch\u1ECDn");
		lblCit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit.setBounds(725, 74, 111, 24);
		contentPane.add(lblCit);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(604, 0, 111, 75);
		contentPane.add(btnNewButton_4);
		
		JLabel lblCit_1 = new JLabel("C\u00E0i \u0110\u1EB7t");
		lblCit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit_1.setBounds(604, 74, 111, 24);
		contentPane.add(lblCit_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin, user:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 283, 216, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("M\u00E3 user:");
		lblNewLabel_4_2.setForeground(Color.GREEN);
		lblNewLabel_4_2.setBounds(6, 16, 68, 24);
		panel.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4_2_1 = new JLabel("T\u00EAn user:");
		lblNewLabel_4_2_1.setForeground(Color.GREEN);
		lblNewLabel_4_2_1.setBounds(6, 48, 75, 24);
		panel.add(lblNewLabel_4_2_1);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("\u0110\u00E3 s\u1EED d\u1EE5ng:");
		lblNewLabel_4_2_1_1.setForeground(Color.GREEN);
		lblNewLabel_4_2_1_1.setBounds(6, 80, 99, 24);
		panel.add(lblNewLabel_4_2_1_1);
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4_2_2 = new JLabel("EMPLOYEE002");
		lblNewLabel_4_2_2.setForeground(Color.BLACK);
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_2_2.setBounds(84, 16, 122, 24);
		panel.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("Phan T\u1EA5n T\u00E0i");
		lblNewLabel_4_2_3.setForeground(Color.BLACK);
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_2_3.setBounds(84, 48, 122, 24);
		panel.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_4_2_4 = new JLabel("0s");
		lblNewLabel_4_2_4.setForeground(Color.BLACK);
		lblNewLabel_4_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_2_4.setBounds(107, 80, 99, 24);
		panel.add(lblNewLabel_4_2_4);
		
		JButton btnNewButton_5 = new JButton("Tho\u00E1t");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setBackground(new Color(139, 0, 0));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_5.setBounds(725, 353, 97, 29);
		contentPane.add(btnNewButton_5);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(450, 137, 20, 256);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("SALARYFORM");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 109, 440, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Activated)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(170, 156, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(*) Tr\u1EE3 gi\u00FAp, ng\u01B0\u1EDDi m\u1EDBi:");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(471, 137, 216, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u1EBFu b\u1EA1n c\u1EA7n h\u01B0\u1EDBng d\u1EABn c\u00E1c t\u00EDnh n\u0103ng \u1EE9ng d\u1EE5ng c\u1EE7a");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(480, 179, 342, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ph\u1EA7n m\u1EC1m,  h\u00E3y nh\u1EA5p v\u00E0o:\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(480, 211, 168, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(658, 209, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_4_1 = new JLabel("N\u1EBFu b\u1EA1n mu\u1ED1n b\u00E1o l\u1ED7i ngo\u1EA1i l\u1EC7 hay th\u1EAFc m\u1EAFc kh\u00E1c");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(480, 254, 342, 24);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("h\u00E3y nh\u1EA5p v\u00E0o:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(480, 286, 97, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JButton btnNewButton_6_1 = new JButton("New button");
		btnNewButton_6_1.setBounds(585, 279, 89, 23);
		contentPane.add(btnNewButton_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("Nh\u00E0 ph\u00E1t tri\u1EC3n: nh\u00F3m 11");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 181, 430, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("B\u1EA3n quy\u1EC1n s\u1EDF h\u1EEFu: SalaryForm firm");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(10, 208, 430, 24);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Kh\u00F3a ngo\u1EA1i l\u1EC7: xxxxx-xxxxx-xxxxx");
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(10, 229, 430, 27);
		contentPane.add(lblNewLabel_6_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
		panel_1.setBounds(421, 0, 112, 63);
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
	}
}
