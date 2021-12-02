package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import connectDB.Database;
import connectDB.testDatabase;

public class QuanLyTinhLuong extends JFrame {

	private JPanel contentPane;
	private JTable tblCongNhan;
	private JTextField txtSearch;
	private JComboBox cbEntity;
	private JComboBox cbMonth;
	private JTable tblNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyTinhLuong frame = new QuanLyTinhLuong();
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
	public QuanLyTinhLuong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(941, 0, 98, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(6, 16, 86, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(6, 38, 86, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 127, 1039, 220);
		contentPane.add(scrollPane);
		
		tblCongNhan = new JTable();
		tblCongNhan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u00E1ng l\u01B0\u01A1ng", "M\u00E3 C.Nh\u00E2n", "H\u1ECD t\u00EAn", "S\u1ED1 l\u01B0\u1EE3ng SP", "Ti\u1EC1n SP", "Ph\u1EE5 c\u1EA5p", "S\u1ED1 ng\u00E0y ngh\u1EC9", "Ph\u00E1t sinh", "Ng\u00E0y in", "T\u1ED4NG NH\u1EACN"
			}
		));
		scrollPane.setViewportView(tblCongNhan);
		
		JLabel lblNewLabel_2 = new JLabel("Qu\u1EA3n l\u00FD t\u00EDnh l\u01B0\u01A1ng");
		lblNewLabel_2.setBackground(new Color(32, 178, 170));
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 0, 818, 31);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thanh t\u00E1c v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 38, 931, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnStart = new JButton("B\u1EAFt \u0111\u1EA7u");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entity=cbEntity.getSelectedItem().toString();
				String month =cbMonth.getSelectedItem().toString();
				Locale locale = new Locale("vi", "VN");
				NumberFormat numberFormat= NumberFormat.getCurrencyInstance(locale);
				if(entity.equals("Công nhân")) {
					Connection conn = Database.getConnection();
			        Statement stmt0 = null;
			        Statement stmt1 = null;
			        try {
			            stmt0 = conn.createStatement();
			            String query0 = "select * from congnhan";
			            ResultSet rs0 = stmt0.executeQuery(query0);
			            while(rs0.next()){
			            	String maCongNhan = rs0.getString("maCongNhan");//ma
			            	stmt1 = conn.createStatement();
			            	String query1 = "select sum(soLuong),sum(soLuong*donGia) from BangChamCong where maCongNhan = '"+maCongNhan+"' and MONTH(ngayChamCong) = "+month+"";
			            	ResultSet rs1 = stmt1.executeQuery(query1);
			            	rs1.next();
			            	int soLuongSanPham = rs1.getInt(1);//soLuong
			            	float tienSanPham =rs1.getFloat(2);//tienSP
			            	query1= "select count(maNhanVien) from DonXinNghi where maNhanVien = '"+maCongNhan+"' and MONTH(ngayNghi) = "+month+"";
			            	rs1=stmt1.executeQuery(query1);
			            	rs1.next();
			            	int soNgayNghi = rs1.getInt(1);//ngayNghi
			            	float phatSinh = (float) soNgayNghi*10000;//phatSinh
			            	Date d = new Date();
			            	String ngayIn = new SimpleDateFormat("dd/MM/yyyy").format(d);//ngayIn
			            	float tongNhan = tienSanPham - phatSinh;
			            	
			            	DefaultTableModel tableModelCN = (DefaultTableModel) tblCongNhan.getModel();
			            	tableModelCN.addRow(new Object[] {
			            		month,rs0.getString("maCongNhan"),rs0.getString("tenCongNhan"), soLuongSanPham,tienSanPham,0,soNgayNghi,phatSinh,ngayIn,numberFormat.format(tongNhan)
			            	});
			            }
			        } catch (SQLException ex) {
			            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
			        }
				}
			}
		});
		btnStart.setBackground(new Color(85, 107, 47));
		btnStart.setForeground(new Color(50, 205, 50));
		btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnStart.setBounds(331, 24, 117, 38);
		panel_1.add(btnStart);
		
		cbMonth = new JComboBox();
		cbMonth.setForeground(new Color(34, 139, 34));
		cbMonth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"Ch\u1ECDn th\u00E1ng", "1", "2", "3", "4", "5", "6", "7", "8", "10", "11", "12"}));
		cbMonth.setBounds(210, 28, 111, 30);
		panel_1.add(cbMonth);
		
		cbEntity = new JComboBox();
		cbEntity.setForeground(new Color(34, 139, 34));
		cbEntity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbEntity.setModel(new DefaultComboBoxModel(new String[] {"Ch\u1ECDn \u0111\u1ED1i t\u01B0\u1EE3ng", "C\u00F4ng nh\u00E2n", "Nh\u00E2n vi\u00EAn h\u00E0nh ch\u00EDnh"}));
		cbEntity.setBounds(10, 28, 190, 30);
		panel_1.add(cbEntity);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(673, 34, 179, 28);
		panel_1.add(txtSearch);
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSearch.setForeground(new Color(0, 0, 0));
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("T\u00ECm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((DefaultTableModel) tblCongNhan.getModel());
				sorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
				tblCongNhan.setRowSorter(sorter);
				
				TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>((DefaultTableModel) tblNhanVien.getModel());
				sorter2.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
				tblNhanVien.setRowSorter(sorter2);
			}
		});
		btnSearch.setBounds(862, 39, 59, 23);
		panel_1.add(btnSearch);
		btnSearch.setForeground(new Color(50, 205, 50));
		btnSearch.setBackground(new Color(0, 128, 128));
		
		JButton btnNewButton_2 = new JButton("Ghi file .txt");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(10, 637, 124, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("X\u00F3a r\u1ED7ng table");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModelCN=(DefaultTableModel) tblCongNhan.getModel();
				tableModelCN.setRowCount(0);
				DefaultTableModel tableModelNV=(DefaultTableModel) tblNhanVien.getModel();
				tableModelNV.setRowCount(0);
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1.setBounds(446, 637, 153, 41);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Danh s\u00E1ch phi\u1EBFu l\u01B0\u01A1ng C\u00F4ng nh\u00E2n:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(0, 112, 203, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Danh s\u00E1ch phi\u1EBFu l\u01B0\u01A1ng NVHC:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(0, 344, 203, 23);
		contentPane.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 367, 1039, 275);
		contentPane.add(scrollPane_1);
		
		tblNhanVien = new JTable();
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u00E1ng l\u01B0\u01A1ng", "M\u00E3 N.Vi\u00EAn", "T\u00EAn", "P.Ban", "Ng\u00E0y c\u00F4ng", "Ti\u1EC1n l\u01B0\u01A1ng", "Gi\u1EDD T.Ca", "Ti\u1EC1n T.Ca", "Ph\u1EE5 c\u1EA5p", "Ng\u00E0y ngh\u1EC9", "Ph\u00E1t sinh", "Ng\u00E0y in", "T\u1ED4NG NH\u1EACN"
			}
		));
		scrollPane_1.setViewportView(tblNhanVien);
		
		JButton btnQuayLai = new JButton("Quay l\u1EA1i");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu.main(null);
				dispose();
			}
		});
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnQuayLai.setBounds(931, 647, 98, 31);
		contentPane.add(btnQuayLai);

		//codey tay
	}
}