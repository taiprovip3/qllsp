package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class ThongKe extends JFrame {

	private JPanel contentPane;
	private JComboBox cbBox1;
	private JComboBox cbMonth1;
	private JComboBox cbBox2;
	private JComboBox cbMonth2;
	private JComboBox cbBox3;
	private JComboBox cbMonth3;

	/**
	 * Launch the application.
	 */
	public static void main(final String un) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe(un);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongKe(final String un) {
		setAutoRequestFocus(false);
		setTitle("SalaryForm > th\u1ED1ng k\u00EA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quay l\u1EA1i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangChu.main(un);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(718, 465, 123, 38);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47, 79, 79)));
		panel_1.setBounds(744, 11, 97, 55);
		contentPane.add(panel_1);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 85, 17);
		panel_1.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 32, 85, 17);
		panel_1.add(lblDate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u1ED1i t\u01B0\u1EE3ng \"Nh\u00E2n vi\u00EAn/C\u00F4ng nh\u00E2n\":", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 97, 414, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cbBox1 = new JComboBox();
		cbBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbBox1.setModel(new DefaultComboBoxModel(new String[] {"Nh\u00E2n vi\u00EAn Ch\u0103m ch\u1EC9 nh\u1EA5t", "Nh\u00E2n vi\u00EAn L\u01B0\u1EDDi bi\u1EBFng nh\u1EA5t", "C\u00F4ng nh\u00E2n Ch\u0103m ch\u1EC9 nh\u1EA5t", "C\u00F4ng nh\u00E2n L\u01B0\u1EDDi bi\u1EBFng nh\u1EA5t"}));
		cbBox1.setBounds(10, 21, 394, 39);
		panel.add(cbBox1);
		
		JButton btnThongKe1 = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getEntity = cbBox1.getSelectedIndex();
				String month = cbMonth1.getSelectedItem().toString();
				int subMonth = Integer.parseInt(month.substring(6));
				if(getEntity == 2) {
					ThongKe_congnhan.main("chamchi",subMonth);
				}
				if(getEntity == 3) {
					ThongKe_congnhan.main("luoibien", subMonth);
				}
			}
		});
		btnThongKe1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThongKe1.setBounds(10, 118, 123, 38);
		panel.add(btnThongKe1);
		
		cbMonth1 = new JComboBox();
		cbMonth1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMonth1.setModel(new DefaultComboBoxModel(new String[] {"Th\u00E1ng 1", "Th\u00E1ng 2", "Th\u00E1ng 3", "Th\u00E1ng 4", "Th\u00E1ng 5", "Th\u00E1ng 6", "Th\u00E1ng 7", "Th\u00E1ng 8", "Th\u00E1ng 9", "Th\u00E1ng 10", "Th\u00E1ng 11", "Th\u00E1ng 12"}));
		cbMonth1.setBounds(10, 71, 394, 39);
		panel.add(cbMonth1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u0110\u1ED1i t\u01B0\u1EE3ng \"L\u01B0\u01A1ng/B\u1EA3ng ch\u1EA5m c\u00F4ng\":", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(427, 97, 414, 167);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		cbBox2 = new JComboBox();
		cbBox2.setModel(new DefaultComboBoxModel(new String[] {"T\u1ED5ng L\u01B0\u01A1ng \u0110V \u0111\u00E3 tr\u1EA3 cao nh\u1EA5t", "T\u1ED5ng L\u01B0\u01A1ng \u0110V \u0111\u00E3 tr\u1EA3 th\u1EA5p nh\u1EA5t", "B\u1EA3ng Ch\u1EA5m C\u00F4ng g\u1EA7n \u0111\u00E2y", "B\u1EA3ng Ch\u1EA5m C\u00F4ng c\u0169 nh\u1EA5t", "", ""}));
		cbBox2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbBox2.setBounds(10, 21, 394, 39);
		panel_2.add(cbBox2);
		
		JButton btnThongKe2 = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnThongKe2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThongKe2.setBounds(10, 118, 123, 38);
		panel_2.add(btnThongKe2);
		
		cbMonth2 = new JComboBox();
		cbMonth2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMonth2.setModel(new DefaultComboBoxModel(new String[] {"Th\u00E1ng 1", "Th\u00E1ng 2", "Th\u00E1ng 3", "Th\u00E1ng 4", "Th\u00E1ng 5", "Th\u00E1ng 6", "Th\u00E1ng 7", "Th\u00E1ng 8", "Th\u00E1ng 9", "Th\u00E1ng 10", "Th\u00E1ng 11", "Th\u00E1ng 12"}));
		cbMonth2.setBounds(10, 71, 394, 39);
		panel_2.add(cbMonth2);
		
		JLabel lblNewLabel = new JLabel("(!) D\u1EEF li\u1EC7u th\u00F4ng k\u00EA \u0111\u00E3 \u0111\u01B0\u1EE3c c\u00F3 s\u1EB5n 1 s\u1ED1 thu\u1EADt to\u00E1n. M\u1ED9t v\u00E0i h\u00E0m t\u00EDnh ch\u01B0a h\u1ED7 tr\u1EE3.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 465, 698, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblLinHTrc = new JLabel("Li\u00EAn h\u1EC7 tr\u1EF1c ti\u1EBFp nh\u00E0 ph\u00E1t tri\u1EC3n (developer) \u0111\u1EC3 \u0111\u01B0\u1EE3c t\u01B0 v\u1EA5n gi\u1EA3i quy\u1EBFt.");
		lblLinHTrc.setForeground(Color.RED);
		lblLinHTrc.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLinHTrc.setBounds(10, 487, 698, 20);
		contentPane.add(lblLinHTrc);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng k\u00EA \"Thu/Chi\":", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 275, 414, 167);
		contentPane.add(panel_3);
		
		cbBox3 = new JComboBox();
		cbBox3.setModel(new DefaultComboBoxModel(new String[] {"Doanh thu C\u00F4ng ty theo Th\u00E1ng", "T\u1ED5ng \u0111\u00E3 chi cho Tr\u1EA3 l\u01B0\u01A1ng cho \u0110V"}));
		cbBox3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbBox3.setBounds(10, 21, 394, 39);
		panel_3.add(cbBox3);
		
		JButton btnThongKe3 = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getEntity = cbBox3.getSelectedIndex();
				String month = cbMonth3.getSelectedItem().toString();
				int subMonth = Integer.parseInt(month.substring(6));
				if(getEntity == 0) {
					ThongKe_hopdong.main(subMonth);
				}
				if(getEntity == 1) {
				}	
			}
		});
		btnThongKe3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThongKe3.setBounds(10, 118, 123, 38);
		panel_3.add(btnThongKe3);
		
		cbMonth3 = new JComboBox();
		cbMonth3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMonth3.setModel(new DefaultComboBoxModel(new String[] {"Th\u00E1ng 1", "Th\u00E1ng 2", "Th\u00E1ng 3", "Th\u00E1ng 4", "Th\u00E1ng 5", "Th\u00E1ng 6", "Th\u00E1ng 7", "Th\u00E1ng 8", "Th\u00E1ng 9", "Th\u00E1ng 10", "Th\u00E1ng 11", "Th\u00E1ng 12"}));
		cbMonth3.setBounds(10, 71, 394, 39);
		panel_3.add(cbMonth3);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
}
