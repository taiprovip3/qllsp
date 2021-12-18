package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.GetLocalTime;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class QuenMatKhau extends JFrame {

	private JPanel contentPane;
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
					QuenMatKhau frame = new QuenMatKhau();
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
	public QuenMatKhau() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 253, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(10, 39, 253, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKhaNgoiL = new JLabel("Kh\u00F3a ngo\u1EA1i l\u1EC7:");
		lblKhaNgoiL.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblKhaNgoiL.setBounds(10, 79, 253, 29);
		contentPane.add(lblKhaNgoiL);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 107, 253, 39);
		contentPane.add(textField_1);
		
		JLabel lblMtKhuMi = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi:");
		lblMtKhuMi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMtKhuMi.setBounds(10, 147, 253, 29);
		contentPane.add(lblMtKhuMi);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 175, 253, 39);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Thay \u0111\u1ED5i");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 228, 126, 39);
		contentPane.add(btnNewButton);
		
		JCheckBox chkShowPW = new JCheckBox("Hi\u1EC7n pass");
		chkShowPW.setFont(new Font("Times New Roman", Font.BOLD, 16));
		chkShowPW.setBounds(166, 238, 97, 23);
		contentPane.add(chkShowPW);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTime.setBounds(743, 11, 97, 14);
		contentPane.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDate.setBounds(743, 27, 97, 14);
		contentPane.add(lblDate);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\back.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangNhap.main(null);
			}
		});
		btnNewButton_1.setBounds(788, 226, 52, 41);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(436, 23, 14, 238);
		contentPane.add(separator);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"- Tr\u01B0\u1EDDng h\u1EE3p b\u1ECB m\u1EA5t hay qu\u00EAn m\u1EADt kh\u1EA9u h\u00E3y", "li\u00EAn h\u1EC7 administrator \u0111\u1EC3 nh\u1EADn kh\u00F3a ngo\u1EA1i l\u1EC7."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(472, 52, 343, 164);
		contentPane.add(list);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}

}
