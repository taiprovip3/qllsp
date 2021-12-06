package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private JLabel lblThoiGianHoatDong;
	private String username;
	private int thoiGianHoatDong;
	private JLabel lblMaNguoiDung;
	private JLabel lblTenNguoiDung;
	private boolean signTuyChon = false;
	private boolean signCaiDat = false;
	private JButton btnDoiMatKhau;
	private JButton btnQuenMatKhau;
	private JButton btnDangXuat;
	private JButton btnNewButton_4;
	private JButton btnLanguage;

	/**
	 * Launch the application.
	 */
	public static void main(final String un) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu(un);
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
	public TrangChu(String un) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\note.png"));
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
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 74, 111, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuanLyTinhLuong.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\calculator.png"));
		btnNewButton_1.setBounds(121, 0, 111, 75);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTnhLng = new JLabel("T\u00EDnh L\u01B0\u01A1ng");
		lblTnhLng.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTnhLng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnhLng.setBounds(121, 74, 111, 24);
		contentPane.add(lblTnhLng);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\analytics.png"));
		btnNewButton_2.setBounds(242, 0, 111, 75);
		contentPane.add(btnNewButton_2);
		
		JLabel lblThngK = new JLabel("Th\u1ED1ng k\u00EA");
		lblThngK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setBounds(242, 74, 111, 24);
		contentPane.add(lblThngK);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!signTuyChon)
				{
					btnDoiMatKhau.setVisible(true);
					btnQuenMatKhau.setVisible(true);
					btnDangXuat.setVisible(true);
					signTuyChon = true;
				}else {
					btnDoiMatKhau.setVisible(false);
					btnQuenMatKhau.setVisible(false);
					btnDangXuat.setVisible(false);
					signTuyChon = false;
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\user.png"));
		btnNewButton_3.setBounds(725, 0, 111, 75);
		contentPane.add(btnNewButton_3);
		
		JLabel lblCit = new JLabel("T\u00F9y ch\u1ECDn");
		lblCit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit.setBounds(725, 74, 111, 24);
		contentPane.add(lblCit);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!signCaiDat)
				{
					btnLanguage.setVisible(true);
					signCaiDat = true;
				}else {
					btnLanguage.setVisible(false);
					signCaiDat = false;
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\settings.png"));
		btnNewButton_4.setBounds(604, 0, 111, 75);
		contentPane.add(btnNewButton_4);
		
		JLabel lblCit_1 = new JLabel("C\u00E0i \u0110\u1EB7t");
		lblCit_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit_1.setBounds(604, 74, 111, 24);
		contentPane.add(lblCit_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin, user:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 283, 271, 110);
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
		
		lblMaNguoiDung = new JLabel("EMPLOYEE002");
		lblMaNguoiDung.setForeground(Color.BLACK);
		lblMaNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNguoiDung.setBounds(84, 16, 175, 24);
		panel.add(lblMaNguoiDung);
		
		lblTenNguoiDung = new JLabel("Phan T\u1EA5n T\u00E0i");
		lblTenNguoiDung.setForeground(Color.BLACK);
		lblTenNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNguoiDung.setBounds(84, 48, 175, 24);
		panel.add(lblTenNguoiDung);
		
		lblThoiGianHoatDong = new JLabel("0s");
		lblThoiGianHoatDong.setForeground(Color.BLACK);
		lblThoiGianHoatDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThoiGianHoatDong.setBounds(107, 80, 152, 24);
		panel.add(lblThoiGianHoatDong);
		
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
		
		JButton btnNewButton_6 = new JButton("\u0111\u00E2y");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://sangtao2008.wordpress.com/";
			        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
		
		JButton btnNewButton_6_1 = new JButton("\u0111\u00E2y");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://sangtao2008.wordpress.com/";
			        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
		});
		btnNewButton_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
		panel_1.setBounds(482, 0, 112, 63);
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
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuanLyDonNghi.main(null);
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\appointment.png"));
		btnNewButton_2_1.setBounds(363, 0, 111, 75);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblQlnNgh = new JLabel("Q.L Đơn nghỉ");
		lblQlnNgh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQlnNgh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQlnNgh.setBounds(363, 74, 111, 24);
		contentPane.add(lblQlnNgh);
		
		btnDoiMatKhau = new JButton("Đổi pass");
		btnDoiMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDoiMatKhau.setBounds(725, 99, 111, 29);
		contentPane.add(btnDoiMatKhau);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDangXuat.setBounds(725, 150, 111, 29);
		contentPane.add(btnDangXuat);
		
		btnQuenMatKhau = new JButton("Quên pass");
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnQuenMatKhau.setBounds(725, 125, 111, 29);
		contentPane.add(btnQuenMatKhau);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		
		btnLanguage = new JButton("Tiếng anh");
		btnLanguage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLanguage.setBounds(604, 99, 111, 27);
		contentPane.add(btnLanguage);
		getLocalTime.showTime();
		getLocalTime.showDate();
		btnDoiMatKhau.setVisible(false);
		btnQuenMatKhau.setVisible(false);
		btnDangXuat.setVisible(false);
		btnLanguage.setVisible(false);
		loadInfo(un);
		loopVoHan(un);
	}

	private void loadInfo(String un) {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String query = "select * from NguoiDung where tenDangNhap = '"+un+"'";
            System.out.println(un);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String maNguoiDung = rs.getString("maNguoiDung");
            String tenNguoiDUng = rs.getString("tenNguoiDung");
            thoiGianHoatDong = rs.getInt("thoiGianHoatDong");
            
            lblMaNguoiDung.setText(maNguoiDung);
            lblTenNguoiDung.setText(tenNguoiDUng);
        conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	private void loopVoHan(final String un) {

		Thread thread2 = new Thread(){
		    public void run(){
		     	try {
					for (int i = thoiGianHoatDong; i <= 2147483647; i++) {
						sleep(1100);
						if(i%60==0)
						{
							Connection conn = Database.getConnection();
					        Statement stmt = null;
					        stmt = conn.createStatement();
							String sql ="update NguoiDung set thoiGianHoatDong = thoiGianHoatDong + 60 where tenDangNhap = '"+un+"'";
							stmt.execute(sql);
							conn.close();
						}
						lblThoiGianHoatDong.setText(String.valueOf(i)+"s");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }
		  };
		  thread2.start();
		
	}
}
