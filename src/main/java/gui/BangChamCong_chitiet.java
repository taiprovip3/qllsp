package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class BangChamCong_chitiet extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable tblBangChamCong;
	private static BangChamCong_chitiet frame;
	private JLabel lblPhanXuongPre;

	/**
	 * Launch the application.
	 */
	public static void main(final String maPXPre) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BangChamCong_chitiet(maPXPre);
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
	public BangChamCong_chitiet(final String maPXPre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(-6, 380, 112, 54);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnQuayLai = new JButton("Quay l\u1EA1i");
		btnQuayLai.setBounds(6, 16, 100, 32);
		panel_3.add(btnQuayLai);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangChu.main("admin");
			}
		});
		btnQuayLai.setBackground(new Color(0, 100, 0));
		btnQuayLai.setForeground(new Color(0, 255, 0));
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(727, 360, 112, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 100, 20);
		panel.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 37, 100, 20);
		panel.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "V\u00F9ng d\u1EEF li\u1EC7u:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 64, 839, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 819, 242);
		panel_1.add(scrollPane);
		
		tblBangChamCong = new JTable();
		tblBangChamCong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 c\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "M\u00E3 ph\u00E2n x\u01B0\u1EDFng"
			}
		));
		tblBangChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(tblBangChamCong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm (textsearch):", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(518, 0, 325, 63);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSearch = new JButton("T\u00ECm ki\u1EBFm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((DefaultTableModel) tblBangChamCong.getModel());
				sorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
				tblBangChamCong.setRowSorter(sorter);
			}
		});
		btnSearch.setBackground(new Color(60, 179, 113));
		btnSearch.setForeground(new Color(127, 255, 0));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSearch.setBounds(220, 22, 95, 27);
		panel_2.add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 22, 200, 30);
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Qu\u1EA3n l\u00FD b\u1EA3ng ch\u1EA5m c\u00F4ng (chi ti\u1EBFt)");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(10, 0, 346, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ch\u1EA5m c\u00F4ng cho \u0111\u1ED1i t\u01B0\u1EE3ng c\u00F4ng nh\u00E2n trong ng\u00E0y");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 39, 282, 19);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maPXPre = lblPhanXuongPre.getText();
				BangChamCong_chitiet_them.main(maPXPre);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setForeground(new Color(0, 255, 127));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(111, 373, 144, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("S\u1EEDa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = tblBangChamCong.getSelectedRow();
				if(a != -1)
				{
					int cf = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc muốn sửa?");
					if(cf==JOptionPane.YES_OPTION)
					{
						String macn=tblBangChamCong.getValueAt(a, 0).toString();
						String tencn=tblBangChamCong.getValueAt(a, 1).toString();
						String masp=tblBangChamCong.getValueAt(a, 2).toString();
						String sl=tblBangChamCong.getValueAt(a, 3).toString();
						String dg=tblBangChamCong.getValueAt(a, 4).toString();
						String ncc=tblBangChamCong.getValueAt(a, 5).toString();
						String mapx=tblBangChamCong.getValueAt(a, 6).toString();
						BangChamCong_chitiet_sua quanLyBangChamCong_sua = new BangChamCong_chitiet_sua();
						BangChamCong_chitiet_sua.main(macn, tencn, masp, sl, dg, ncc, mapx);
					}
				}else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng cần sửa!");
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 255, 127));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1_1.setBounds(265, 373, 144, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("X\u00F3a");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tblBangChamCong.getSelectedRow();
				if(a!=-1)
				{
					String maCN=tblBangChamCong.getValueAt(a,0).toString();
					String maSP=tblBangChamCong.getValueAt(a,2).toString();
					Connection conn = Database.getConnection();
					PreparedStatement stmt = null;
			        try {
			            String query = "delete from BangChamCong where maCongNhan = ? and maSanPham = ?";
			            stmt = conn.prepareCall(query);
			            stmt.setString(1, maCN);
			            stmt.setString(2, maSP);
			            stmt.execute();
			            int cf= JOptionPane.showConfirmDialog(contentPane, "Xóa thành công, cần tải lại?");
		                if(cf==JOptionPane.YES_OPTION) {
		                	BangChamCong_chitiet.taiLai(maPXPre);
							dispose();
		                }
			        } catch (SQLException ex) {
			            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
			        }
				}else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng cần xóa");
			}
		});
		btnNewButton_1_2.setForeground(new Color(0, 255, 127));
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1_2.setBackground(new Color(0, 128, 128));
		btnNewButton_1_2.setBounds(419, 375, 144, 48);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("L\u01B0u b\u1EA3ng");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = Database.getConnection();
				PreparedStatement preStmt = null;
				Statement stmt = null;
		        try {
		        	stmt = conn.createStatement();
		        	String query0="select top 1 stt from DanhSachBangChamCong order by stt desc";
		        	ResultSet rs0 = stmt.executeQuery(query0);
		        	rs0.next();
		        	int stt = rs0.getInt(1) +1;
		        	String maBangChamCong = "BCC"+stt; //1
		        	query0="select * from phanxuong where maPhanXuong = '"+lblPhanXuongPre.getText()+"'";
		        	rs0=stmt.executeQuery(query0);
		        	rs0.next();
		        	String nghiepVu = rs0.getString("nghiepVu");//2
		        	String viTri = rs0.getString("viTri");//3
		        	int soLuongCongNhan =rs0.getInt("soLuongCongNhan");//4
		        	String nguoiDaiDien =rs0.getString("nguoiDaiDien");//5
		        	Timestamp ngayChamCong = Timestamp.valueOf(tblBangChamCong.getValueAt(0,5).toString());//6
		        	
		            String query = "insert into DanhSachBangChamCong values (?,?,?,?,?,?,?,?)";
		            preStmt = conn.prepareCall(query);
		            preStmt.setString(1, maBangChamCong);
		            preStmt.setString(2, lblPhanXuongPre.getText());
		            preStmt.setString(3, nghiepVu);
		            preStmt.setString(4, viTri);
		            preStmt.setInt(5, soLuongCongNhan);
		            preStmt.setString(6, nguoiDaiDien);
		            preStmt.setTimestamp(7, ngayChamCong);
		            preStmt.setInt(8, stt);
		            preStmt.execute();
		            	JOptionPane.showMessageDialog(contentPane, "Lưu lại thành công");
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(contentPane, "Bảng chấm công này đã tồn tại!");
		        }
			}
		});
		btnNewButton_1_3.setForeground(new Color(0, 255, 127));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1_3.setBackground(new Color(0, 128, 128));
		btnNewButton_1_3.setBounds(573, 375, 144, 48);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblNewLabel = new JLabel("Của phân xưởng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(386, 23, 122, 19);
		contentPane.add(lblNewLabel);
		
		lblPhanXuongPre = new JLabel("New label");
		lblPhanXuongPre.setForeground(new Color(0, 250, 154));
		lblPhanXuongPre.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhanXuongPre.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanXuongPre.setBounds(386, 39, 122, 23);
		contentPane.add(lblPhanXuongPre);
		lblPhanXuongPre.setText(maPXPre);
		
		JButton btnNewButton = new JButton("Đổ dữ liệu vào = script");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				StringBuilder stringBuilder = new StringBuilder();
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						Connection conn = Database.getConnection();
						Statement stmt = null;
						File file = fileChooser.getSelectedFile();
						BufferedReader br = new BufferedReader(new FileReader(file));
						String line;
						while((line = br.readLine()) != null) {
				            stmt = conn.createStatement();
				            stmt.execute(line);
						}
						int cf= JOptionPane.showConfirmDialog(contentPane, "Đổ dữ liệu thành công, tải lại?");
						if(cf==JOptionPane.YES_OPTION)
							BangChamCong_chitiet.taiLai(maPXPre);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else
					stringBuilder.append("No file selected");
			}
		});
		btnNewButton.setBounds(10, 333, 245, 29);
		contentPane.add(btnNewButton);
		
		//Code tay
		loadDataFromCSDL();
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}

	private void loadDataFromCSDL() {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String query = "select * from BangChamCong where maPhanXuong = '"+lblPhanXuongPre.getText()+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DefaultTableModel tableModel = (DefaultTableModel) tblBangChamCong.getModel(); 
                tableModel.addRow(new Object[] {
                		rs.getString("maCongNhan"),
                		rs.getString("tenCongNhan"),
                		rs.getString("maSanPham"),
                		rs.getInt("soLuong"),
                		rs.getFloat("donGia"),
                		rs.getTimestamp("ngayChamCong"),
                		rs.getString("maPhanXuong")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public static void taiLai(String maPXPre) {
		SwingUtilities.updateComponentTreeUI(frame);
		frame.dispose();
		main(maPXPre);
	}
}
