package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import util.GetLocalTime;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BangChamCong_luachon extends JFrame {

	private JPanel contentPane;
	private JComboBox cbLuaChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangChamCong_luachon frame = new BangChamCong_luachon();
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
	public BangChamCong_luachon() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbLuaChon = new JComboBox();
		cbLuaChon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbLuaChon.getSelectedIndex() <= 0) {
					cbLuaChon.setSelectedIndex(1);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa chọn cac option ben dưới");
				}
			}
		});
		cbLuaChon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbLuaChon.setModel(new DefaultComboBoxModel(new String[] {"Vui l\u00F2ng ch\u1ECDn ph\u00E2n x\u01B0\u1EDFng", "PX1", "PX2", "PX3", "PX4", "PX5", "PX6", "PX7", "PX8", "PX9", "PX10"}));
		cbLuaChon.setBounds(20, 36, 393, 39);
		contentPane.add(cbLuaChon);
		
		JButton btnLuaChon = new JButton("L\u1EF1a ch\u1ECDn");
		btnLuaChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbLuaChon.getSelectedIndex() <=0 ) {
					JOptionPane.showMessageDialog(contentPane, "Vui long lua chon cac option ben duoi");
				}else {
					String maPX=cbLuaChon.getSelectedItem().toString();
					BangChamCong_chitiet.main(maPX);
					dispose();
				}
			}
		});
		btnLuaChon.setBackground(new Color(34, 139, 34));
		btnLuaChon.setForeground(Color.GREEN);
		btnLuaChon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLuaChon.setBounds(296, 198, 128, 34);
		contentPane.add(btnLuaChon);
		
		JButton btnBack = new JButton("< Quay l\u1EA1i");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyBangChamCong.main(null);
				dispose();
			}
		});
		btnBack.setBackground(new Color(165, 42, 42));
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBack.setBounds(10, 202, 104, 29);
		contentPane.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
		panel_1.setBounds(149, 179, 112, 63);
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
		
		JLabel lblNewLabel = new JLabel("Lựa chọn phân xưởng để nhập công cho phân xưởng đó");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel.setBounds(20, 74, 393, 20);
		contentPane.add(lblNewLabel);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
}
