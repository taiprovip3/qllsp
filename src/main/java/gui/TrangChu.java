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
	private boolean signTuyChon,signCaiDat, signNgonNgu = false;
	private JButton btnDoiMatKhau;
	private JButton btnDangXuat;
	private JButton btnNewButton_4;
	private JButton btnNgonNgu;
	private JLabel lblBCC;
	private JLabel lblTinhLuong;
	private JLabel lblThongKe;
	private JLabel lblDN;
	private JLabel lblDuLieuKhac;
	private JLabel lblCaiDat;
	private JLabel lblTuyChon;
	private JLabel lblActive;
	private JLabel lblIntro1;
	private JLabel lblIntro2;
	private JLabel lblIntro3;
	private JPanel pThongTin;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblTimeUsed;
	private JPanel pTime;
	private JLabel lblTroGiup;
	private JLabel lblTroGiup1;
	private JLabel lblTroGiup2;
	private JLabel lblTroGiup3;
	private JLabel lblTroGiup4;
	private JButton btnTroGiup1;
	private JButton btnTroGiup2;
	private JButton btnThoat;

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
	public TrangChu(final String un) {
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
				QuanLyBangChamCong.main(un);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 111, 75);
		contentPane.add(btnNewButton);
		
		lblBCC = new JLabel("Q.L B\u1EA3ng CC");
		lblBCC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblBCC.setBounds(0, 74, 111, 24);
		contentPane.add(lblBCC);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuanLyTinhLuong.main(un);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\calculator.png"));
		btnNewButton_1.setBounds(121, 0, 111, 75);
		contentPane.add(btnNewButton_1);
		
		lblTinhLuong = new JLabel("T\u00EDnh L\u01B0\u01A1ng");
		lblTinhLuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTinhLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinhLuong.setBounds(121, 74, 111, 24);
		contentPane.add(lblTinhLuong);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\analytics.png"));
		btnNewButton_2.setBounds(242, 0, 111, 75);
		contentPane.add(btnNewButton_2);
		
		lblThongKe = new JLabel("Th\u1ED1ng k\u00EA");
		lblThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe.setBounds(242, 74, 111, 24);
		contentPane.add(lblThongKe);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!signTuyChon)
				{
					btnDoiMatKhau.setVisible(true);
					btnDangXuat.setVisible(true);
					signTuyChon = true;
				}else {
					btnDoiMatKhau.setVisible(false);
					btnDangXuat.setVisible(false);
					signTuyChon = false;
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\user.png"));
		btnNewButton_3.setBounds(725, 0, 111, 75);
		contentPane.add(btnNewButton_3);
		
		lblTuyChon = new JLabel("T\u00F9y ch\u1ECDn");
		lblTuyChon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTuyChon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuyChon.setBounds(725, 74, 111, 24);
		contentPane.add(lblTuyChon);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!signCaiDat)
				{
					btnNgonNgu.setVisible(true);
					signCaiDat = true;
				}else {
					btnNgonNgu.setVisible(false);
					signCaiDat = false;
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\settings.png"));
		btnNewButton_4.setBounds(604, 0, 111, 75);
		contentPane.add(btnNewButton_4);
		
		lblCaiDat = new JLabel("C\u00E0i \u0110\u1EB7t");
		lblCaiDat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaiDat.setBounds(604, 74, 111, 24);
		contentPane.add(lblCaiDat);
		
		pThongTin = new JPanel();
		pThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin, user:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pThongTin.setBounds(0, 283, 271, 110);
		contentPane.add(pThongTin);
		pThongTin.setLayout(null);
		
		lblMa = new JLabel("M\u00E3 user:");
		lblMa.setForeground(Color.GREEN);
		lblMa.setBounds(6, 16, 112, 24);
		pThongTin.add(lblMa);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblTen = new JLabel("T\u00EAn user:");
		lblTen.setForeground(Color.GREEN);
		lblTen.setBounds(6, 48, 112, 24);
		pThongTin.add(lblTen);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblTimeUsed = new JLabel("\u0110\u00E3 s\u1EED d\u1EE5ng:");
		lblTimeUsed.setForeground(Color.GREEN);
		lblTimeUsed.setBounds(6, 80, 112, 24);
		pThongTin.add(lblTimeUsed);
		lblTimeUsed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblMaNguoiDung = new JLabel("EMPLOYEE002");
		lblMaNguoiDung.setForeground(Color.BLACK);
		lblMaNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNguoiDung.setBounds(128, 16, 131, 24);
		pThongTin.add(lblMaNguoiDung);
		
		lblTenNguoiDung = new JLabel("Phan T\u1EA5n T\u00E0i");
		lblTenNguoiDung.setForeground(Color.BLACK);
		lblTenNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNguoiDung.setBounds(128, 48, 131, 24);
		pThongTin.add(lblTenNguoiDung);
		
		lblThoiGianHoatDong = new JLabel("0s");
		lblThoiGianHoatDong.setForeground(Color.BLACK);
		lblThoiGianHoatDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThoiGianHoatDong.setBounds(128, 80, 131, 24);
		pThongTin.add(lblThoiGianHoatDong);
		
		btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setForeground(Color.RED);
		btnThoat.setBackground(new Color(139, 0, 0));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThoat.setBounds(725, 353, 97, 29);
		contentPane.add(btnThoat);
		
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
		
		lblActive = new JLabel("(Đã kích hoạt)");
		lblActive.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActive.setBounds(170, 156, 111, 14);
		contentPane.add(lblActive);
		
		lblTroGiup = new JLabel("(*) Tr\u1EE3 gi\u00FAp, ng\u01B0\u1EDDi m\u1EDBi:");
		lblTroGiup.setForeground(new Color(0, 0, 128));
		lblTroGiup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTroGiup.setBounds(471, 137, 216, 33);
		contentPane.add(lblTroGiup);
		
		lblTroGiup1 = new JLabel("N\u1EBFu b\u1EA1n c\u1EA7n h\u01B0\u1EDBng d\u1EABn c\u00E1c t\u00EDnh n\u0103ng \u1EE9ng d\u1EE5ng c\u1EE7a");
		lblTroGiup1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTroGiup1.setBounds(480, 179, 342, 24);
		contentPane.add(lblTroGiup1);
		
		lblTroGiup2 = new JLabel("ph\u1EA7n m\u1EC1m,  h\u00E3y nh\u1EA5p v\u00E0o:\r\n");
		lblTroGiup2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTroGiup2.setBounds(480, 211, 168, 14);
		contentPane.add(lblTroGiup2);
		
		btnTroGiup1 = new JButton("\u0111\u00E2y");
		btnTroGiup1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://sangtao2008.wordpress.com/";
			        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
		});
		btnTroGiup1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTroGiup1.setBounds(658, 209, 89, 23);
		contentPane.add(btnTroGiup1);
		
		lblTroGiup3 = new JLabel("N\u1EBFu b\u1EA1n mu\u1ED1n b\u00E1o l\u1ED7i ngo\u1EA1i l\u1EC7 hay th\u1EAFc m\u1EAFc kh\u00E1c");
		lblTroGiup3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTroGiup3.setBounds(480, 254, 342, 24);
		contentPane.add(lblTroGiup3);
		
		lblTroGiup4 = new JLabel("h\u00E3y nh\u1EA5p v\u00E0o:");
		lblTroGiup4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTroGiup4.setBounds(480, 286, 97, 14);
		contentPane.add(lblTroGiup4);
		
		btnTroGiup2 = new JButton("\u0111\u00E2y");
		btnTroGiup2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://sangtao2008.wordpress.com/";
			        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
		});
		btnTroGiup2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTroGiup2.setBounds(585, 279, 89, 23);
		contentPane.add(btnTroGiup2);
		
		lblIntro1 = new JLabel("Nh\u00E0 ph\u00E1t tri\u1EC3n: nh\u00F3m 11");
		lblIntro1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIntro1.setBounds(10, 181, 430, 24);
		contentPane.add(lblIntro1);
		
		lblIntro2 = new JLabel("B\u1EA3n quy\u1EC1n s\u1EDF h\u1EEFu: SalaryForm firm");
		lblIntro2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIntro2.setBounds(10, 208, 430, 24);
		contentPane.add(lblIntro2);
		
		lblIntro3 = new JLabel("Kh\u00F3a ngo\u1EA1i l\u1EC7: xxxxx-xxxxx-xxxxx");
		lblIntro3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIntro3.setBounds(10, 229, 430, 27);
		contentPane.add(lblIntro3);
		
		pTime = new JPanel();
		pTime.setLayout(null);
		pTime.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
		pTime.setBounds(328, 330, 112, 63);
		contentPane.add(pTime);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 100, 20);
		pTime.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 37, 100, 20);
		pTime.add(lblDate);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuanLyDonNghi.main(un);
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\appointment.png"));
		btnNewButton_2_1.setBounds(363, 0, 111, 75);
		contentPane.add(btnNewButton_2_1);
		
		lblDN = new JLabel("Q.L Đơn nghỉ");
		lblDN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDN.setBounds(363, 74, 111, 24);
		contentPane.add(lblDN);
		
		btnDoiMatKhau = new JButton("Đổi pass");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoiMatKhau.main(un);
			}
		});
		btnDoiMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDoiMatKhau.setBounds(725, 99, 111, 29);
		contentPane.add(btnDoiMatKhau);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangNhap.main(null);
			}
		});
		btnDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDangXuat.setBounds(725, 127, 111, 29);
		contentPane.add(btnDangXuat);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		
		btnNgonNgu = new JButton("Tiếng anh");
		btnNgonNgu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!signNgonNgu){
					lblBCC.setText("Manage timesheets");
					lblTinhLuong.setText("Calculate salary");
					lblThongKe.setText("Statistic");
					lblDN.setText("Application offday");
					lblDuLieuKhac.setText("Others data");
					lblCaiDat.setText("Advanced Setting");
					lblTuyChon.setText("More options");
					lblActive.setText("Activated");
					lblIntro1.setText("Developers: group 11");
					lblIntro2.setText("Owned product by: SalaryForm firm");
					lblIntro3.setText("Exceptional Key: xxxxx-xxxxx-xxxxx");
					pThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Infomations, user:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					lblMa.setText("Id:");
					lblTen.setText("Name:");
					lblTimeUsed.setText("Used:");
					pTime.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Local time:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
					lblTroGiup.setText("Quickly tutorial, for newbie:");
					lblTroGiup1.setText("If you need any help about the features in");
					lblTroGiup2.setText("this software, click the button:");
					btnTroGiup1.setText("Here");
					lblTroGiup3.setText("If you want to report somethings or have any");
					lblTroGiup4.setText("questions to ask, click the button:");
					btnTroGiup2.setText("Here");
					btnThoat.setText("Exit	");
					btnNgonNgu.setText("Vietname");
					btnDoiMatKhau.setText("Change PW");
					btnDangXuat.setText("Log out");
					signNgonNgu = true;
				}else {
					lblBCC.setText("Quản lý BCC");
					lblTinhLuong.setText("Tính lương");
					lblThongKe.setText("Thống kê");
					lblDN.setText("QL. Đơn xin nghỉ");
					lblDuLieuKhac.setText("Dữ liệu khác");
					lblCaiDat.setText("Cài đặt");
					lblTuyChon.setText("Tùy chọn");
					lblActive.setText("Đã kích hoạt");
					lblIntro1.setText("Nhà phát triển: nhóm 11");
					lblIntro2.setText("Được sở hữu bởi: SalaryForm công ty");
					lblIntro3.setText("Khóa ngoại lệ: xxxxx-xxxxx-xxxxx");
					pThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin, người dùng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					lblMa.setText("Mã:");
					lblTen.setText("Tên:");
					lblTimeUsed.setText("Đã hoạt động:");
					pTime.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Local time:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 205, 50)));
					lblTroGiup.setText("TRỢ GIÚP, NGƯỜI MỚI:");
					lblTroGiup1.setText("Nếu bạn cần bất kì trợ giúp về tính năng phần mềm");
					lblTroGiup2.setText("hãy nhấn vào:");
					btnTroGiup1.setText("đây");
					lblTroGiup3.setText("Nếu bạn muốn báo cáo lỗi hay cần liên hệ trực tiếp");
					lblTroGiup4.setText("chúng tối để hỏi, hãy nhấn vào:");
					btnTroGiup2.setText("đây");
					btnThoat.setText("Thoát");
					btnNgonNgu.setText("Tiếng anh");
					btnDoiMatKhau.setText("Đổi mật khẩu");
					btnDangXuat.setText("Đăng xuất");
					signNgonNgu = false;
				}
			}
		});
		btnNgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNgonNgu.setBounds(604, 99, 111, 27);
		contentPane.add(btnNgonNgu);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DuLieuKhac.main(un);
			}
		});
		btnNewButton_2_1_1.setBounds(483, 0, 111, 75);
		contentPane.add(btnNewButton_2_1_1);
		
		lblDuLieuKhac = new JLabel("Dữ liệu từ ĐV khác");
		lblDuLieuKhac.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuLieuKhac.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDuLieuKhac.setBounds(483, 74, 111, 24);
		contentPane.add(lblDuLieuKhac);
		getLocalTime.showTime();
		getLocalTime.showDate();
		btnDoiMatKhau.setVisible(false);
		btnDangXuat.setVisible(false);
		btnNgonNgu.setVisible(false);
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
