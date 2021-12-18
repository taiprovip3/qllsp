package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private static JButton btnLogin;
	private JCheckBox chkHienPassword;
	private JButton btnQunPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
					frame.getRootPane().setDefaultButton(btnLogin);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setTitle("SalaryForm > Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 44, 295, 23);
		contentPane.add(lblNewLabel);
		
		btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un= txtTenDangNhap.getText();
				String pw=txtMatKhau.getText();
				Connection conn = Database.getConnection();
		        Statement stmt = null;
		        try {
		            stmt = conn.createStatement();
		            String query = "select * from NguoiDung where tenDangNhap = '"+un+"'";
		            ResultSet rs = stmt.executeQuery(query);
		            if(!rs.next())
	            	{
		            	txtTenDangNhap.setText("");
		            	txtTenDangNhap.requestFocus();
		            	JOptionPane.showMessageDialog(contentPane, "Tên đăng nhập ko tồn tại");
	            	}
		            else {
		            	String password = rs.getString("matKhau");
		            	if(password.equals(pw))
		            	{
		            		dispose();
		            		TrangChu.main(un);
		            	}else{
		            		txtMatKhau.setText("");
		            		txtMatKhau.requestFocus();
		            		JOptionPane.showMessageDialog(contentPane, "Sai mật khẩu!");
	            		}
		            }
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBounds(26, 160, 129, 33);
		contentPane.add(btnLogin);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setForeground(new Color(220, 20, 60));
		txtTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenDangNhap.setBounds(26, 69, 295, 33);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 101, 295, 23);
		contentPane.add(lblNewLabel_1);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(26, 122, 295, 33);
		contentPane.add(txtMatKhau);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(745, 276, 107, 23);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(745, 254, 107, 23);
		contentPane.add(lblTime);
		
		JLabel lblNewLabel_2 = new JLabel("(b\u1EA5m enter)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(26, 195, 129, 21);
		contentPane.add(lblNewLabel_2);
		
		chkHienPassword = new JCheckBox("Hi\u1EC3n th\u1ECB password");
		chkHienPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkHienPassword.isSelected())
					txtMatKhau.setEchoChar((char)0);
				else
					txtMatKhau.setEchoChar('*');
			}
		});
		chkHienPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chkHienPassword.setBounds(148, 200, 145, 23);
		contentPane.add(chkHienPassword);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		
		btnQunPass = new JButton("Quên pass ?");
		btnQunPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuenMatKhau.main(null);
			}
		});
		btnQunPass.setForeground(Color.RED);
		btnQunPass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnQunPass.setBackground(Color.WHITE);
		btnQunPass.setBounds(214, 160, 107, 33);
		contentPane.add(btnQunPass);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
}
