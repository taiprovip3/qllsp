package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QuanLyDonNghi extends JFrame {

	private JPanel contentPane;
	private JTable tblDonNghi;
	private JTextField txtMaDN;
	private JTextField txtTenNV;
	private JTextField txtSearch;
	private JComboBox cbLoaiNV;
	private JDateChooser dcNgayNghi;
	private JComboBox cbLyDo;
	private JComboBox cbLoaiNghi;
	private JComboBox cbMaNV;
	private JCheckBox chkKhoaNhap;
	private static QuanLyDonNghi frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new QuanLyDonNghi();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyDonNghi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1398, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 385, 1284, 350);
		contentPane.add(scrollPane);
		
		tblDonNghi = new JTable();
		tblDonNghi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
				int a=tblDonNghi.getSelectedRow();
				txtMaDN.setText(tblDonNghi.getValueAt(a, 0).toString());
				cbMaNV.setSelectedItem(tblDonNghi.getValueAt(a, 1).toString());
				txtTenNV.setText(tblDonNghi.getValueAt(a, 2).toString());
				cbLoaiNV.setSelectedItem(tblDonNghi.getValueAt(a, 3).toString());
				Date d =new Date();
					d= new SimpleDateFormat("yyyy-MM-dd").parse(tblDonNghi.getValueAt(a, 4).toString());
				dcNgayNghi.setDate(d);
				cbLyDo.setSelectedItem(tblDonNghi.getValueAt(a, 5).toString());
				cbLoaiNghi.setSelectedItem(tblDonNghi.getValueAt(a, 6).toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		tblDonNghi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblDonNghi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u01A1n ngh\u1EC9", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Lo\u1EA1i nh\u00E2n vi\u00EAn", "Ng\u00E0y ngh\u1EC9", "L\u00FD do", "C\u00F3 ph\u00E9p"
			}
		));
		scrollPane.setViewportView(tblDonNghi);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\home.png"));
		btnNewButton.setBounds(10, 11, 77, 76);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\bcc.png"));
		btnNewButton_1.setBounds(116, 11, 77, 76);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\option.png"));
		btnNewButton_3.setBounds(1197, 11, 77, 76);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 90, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQunLBcc = new JLabel("Qu\u1EA3n l\u00FD BCC");
		lblQunLBcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLBcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQunLBcc.setBounds(107, 90, 96, 14);
		contentPane.add(lblQunLBcc);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\setting.png"));
		btnNewButton_3_1.setBounds(1091, 11, 77, 76);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblTyChn = new JLabel("T\u00F9y ch\u1ECDn");
		lblTyChn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTyChn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTyChn.setBounds(1276, 91, 96, 14);
		contentPane.add(lblTyChn);
		
		JLabel lblCit = new JLabel("T\u00F9y ch\u1ECDn");
		lblCit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCit.setBounds(1197, 90, 77, 14);
		contentPane.add(lblCit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(60, 179, 113)));
		panel.setBounds(651, 0, 108, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 96, 22);
		panel.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 39, 96, 22);
		panel.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 115, 1382, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 \u0111\u01A1n ngh\u1EC9:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 134, 96, 30);
		contentPane.add(lblNewLabel_2);
		
		txtMaDN = new JTextField();
		txtMaDN.setEditable(false);
		txtMaDN.setBounds(116, 136, 247, 30);
		contentPane.add(txtMaDN);
		txtMaDN.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 175, 103, 30);
		contentPane.add(lblNewLabel_2_1);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(494, 136, 253, 30);
		contentPane.add(txtTenNV);
		
		cbMaNV = new JComboBox();
		cbMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMaNV.setModel(new DefaultComboBoxModel(new String[] {"NV1", "NV2", "NV3", "NV4", "NV5", "NV6", "NV7", "NV8", "NV9", "NV10"}));
		cbMaNV.setBounds(116, 175, 247, 30);
		contentPane.add(cbMaNV);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(373, 134, 111, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Lo\u1EA1i nh\u00E2n vi\u00EAn:");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(373, 175, 111, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		cbLoaiNV = new JComboBox();
		cbLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbLoaiNV.setModel(new DefaultComboBoxModel(new String[] {"C\u00F4ng nh\u00E2n", "Nh\u00E2n vi\u00EAn h\u00E0nh ch\u00EDnh"}));
		cbLoaiNV.setBounds(494, 177, 253, 30);
		contentPane.add(cbLoaiNV);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Ng\u00E0y ngh\u1EC9:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(757, 132, 77, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("L\u00FD do:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1.setBounds(757, 173, 47, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		cbLyDo = new JComboBox();
		cbLyDo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbLyDo.setModel(new DefaultComboBoxModel(new String[] {"B\u1EC7nh t\u1EADt", "C\u00F3 \u0111\u00E1m", "H\u01B0 xe", "Ho\u00E0n c\u1EA3nh gia \u0111\u00ECnh", "Thai s\u1EA3n", "B\u1ECB \u0111\u00ECnh ch\u1EC9", "\u0110i h\u1ECDc", "Kh\u00E1c"}));
		cbLyDo.setBounds(837, 175, 234, 30);
		contentPane.add(cbLyDo);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Lo\u1EA1i ngh\u1EC9:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(1081, 175, 77, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		cbLoaiNghi = new JComboBox();
		cbLoaiNghi.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3 ph\u00E9p", "Kh\u00F4ng ph\u00E9p"}));
		cbLoaiNghi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbLoaiNghi.setBounds(1161, 175, 113, 30);
		contentPane.add(cbLoaiNghi);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maDonNghi = txtMaDN.getText();
				String maNhanVien=cbMaNV.getSelectedItem().toString();
				String tenNhanVien=txtTenNV.getText();
				String loaiNhanVien=cbLoaiNV.getSelectedItem().toString();
				Date ngayNghi=new Date();
				ngayNghi=dcNgayNghi.getDate();
				String lyDoNghi=cbLyDo.getSelectedItem().toString();
				String loaiNghi=cbLoaiNghi.getSelectedItem().toString();
				
				Connection conn = Database.getConnection();
		        PreparedStatement stmt = null;
		        Statement stm =null;
		        try {
		        	stm=conn.createStatement();
		        	String query = "select top 1 stt from DonXinNghi order by stt desc";
		        	ResultSet rs = stm.executeQuery(query);
		        	rs.next();
		        	int stt = rs.getInt(1) +1;
		            query = "insert into DonXinNghi values (?,?,?,?,?,?,?,?)";
		            stmt=conn.prepareCall(query);
		            stmt.setString(1, maDonNghi);
		            stmt.setString(2, maNhanVien);
		            stmt.setString(3, tenNhanVien);
		            stmt.setString(4, loaiNhanVien);
		            stmt.setString(5, lyDoNghi);
		            stmt.setDate(6, new java.sql.Date(ngayNghi.getTime()));
		            stmt.setString(7, loaiNghi);
		            stmt.setInt(8, stt);
		            stmt.execute();
		            int cf = JOptionPane.showConfirmDialog(contentPane, "Thêm thành công, vui lòng tải lại bảng!");
		            if(cf == JOptionPane.YES_OPTION)
					{
						taiLai();
						dispose();
					}
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(contentPane, "Lỗi kxd, nhìn console để biết chi tiết!");
		        }
				
			}
		});
		btnThem.setForeground(new Color(60, 179, 113));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThem.setBounds(10, 336, 138, 37);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("S\u1EEDa ch\u1ECDn");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tblDonNghi.getSelectedRow();
				if(a==-1)
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng còn sửa dưới bảng");
				else {
					int cf0 = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc muốn sửa ko ?");
					if(cf0 == JOptionPane.YES_OPTION)
					{
						String madn=tblDonNghi.getValueAt(a, 0).toString();
						String manv=cbMaNV.getSelectedItem().toString();
						String tennv=txtTenNV.getText();
						String loainv=cbLoaiNV.getSelectedItem().toString();
						Date ngaynghi=new Date();
						ngaynghi=dcNgayNghi.getDate();
						String lydo=cbLyDo.getSelectedItem().toString();
						String loainghi=cbLoaiNghi.getSelectedItem().toString();
						
						Connection conn = Database.getConnection();
				        PreparedStatement preStmt = null;
				        try {
				            String query = "update DonXinNghi set maNhanVien = ?, tenNhanVien = ?, loaiNhanVien = ?, lyDoNghi = ?, ngayNghi = ?, loaiNghi = ? where maDonNghi = ?";
				            preStmt = conn.prepareCall(query);
				            preStmt.setString(1, manv);
				            preStmt.setString(2, tennv);
				            preStmt.setString(3, loainv);
				            preStmt.setString(4, lydo);
				            preStmt.setDate(5, new java.sql.Date(ngaynghi.getTime()));
				            preStmt.setString(6, loainghi);
				            preStmt.setString(7, madn);
				            preStmt.execute();
				            int cf = JOptionPane.showConfirmDialog(contentPane, "Sửa thành công, vui lòng tải lại bảng!");
				            if(cf == JOptionPane.YES_OPTION)
							{
								taiLai();
								dispose();
							}
				        } catch (SQLException ex) {
				            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
				            JOptionPane.showMessageDialog(contentPane, "Lỗi kxd, nhìn console để biết chi tiết!");
				        }
					}
				}//End else
			}
		});
		btnSua.setForeground(new Color(60, 179, 113));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSua.setBounds(158, 336, 138, 37);
		contentPane.add(btnSua);
		
		JButton btnXoaRong = new JButton("X\u00F3a r\u1ED7ng");
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbMaNV.setSelectedIndex(0);
				txtTenNV.setText("");
				cbLoaiNV.setSelectedIndex(0);
				Date date = new Date();
				dcNgayNghi.setDate(date);
				cbLyDo.setSelectedIndex(0);
				cbLoaiNghi.setSelectedIndex(0);
				txtSearch.setText("");
			}
		});
		btnXoaRong.setForeground(new Color(60, 179, 113));
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXoaRong.setBounds(306, 336, 138, 37);
		contentPane.add(btnXoaRong);
		
		JButton btnXoa = new JButton("X\u00F3a ch\u1ECDn");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tblDonNghi.getSelectedRow();
				if(a==-1)
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng cần xóa dưới bảng");
				else {
					int confirm=JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc muốn xóa");
					if(confirm==JOptionPane.YES_OPTION)
					{
						Connection conn = Database.getConnection();
				        Statement stmt = null;
				        try {
				            stmt = conn.createStatement();
				            String query = "delete from DonXinNghi where maDonNghi = '"+tblDonNghi.getValueAt(a,0)+"'";
				            stmt.execute(query);
				            DefaultTableModel tableModel = (DefaultTableModel) tblDonNghi.getModel();
				            tableModel.removeRow(a);
				            JOptionPane.showMessageDialog(contentPane, "Xóa thành công, ko cần tải lại!");
				        } catch (SQLException ex) {
				            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
				            JOptionPane.showMessageDialog(contentPane, "Lỗi kxd, nhìn console để biết chi tiết!");
				        }
					}
				}
			}
		});
		btnXoa.setForeground(new Color(60, 179, 113));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXoa.setBounds(454, 336, 138, 37);
		contentPane.add(btnXoa);
		
		chkKhoaNhap = new JCheckBox("Kh\u00F3a nh\u1EADp");
		chkKhoaNhap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		chkKhoaNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkKhoaNhap.isSelected())
				{
					txtMaDN.setEditable(false);
					cbMaNV.setEnabled(false);
					txtTenNV.setEditable(false);
					cbLoaiNV.setEnabled(false);
					dcNgayNghi.setEnabled(false);
					cbLyDo.setEnabled(false);
					cbLoaiNghi.setEnabled(false);
				}else {
					txtMaDN.setEditable(true);
					cbMaNV.setEnabled(true);
					txtTenNV.setEditable(true);
					cbLoaiNV.setEnabled(true);
					dcNgayNghi.setEnabled(true);
					cbLyDo.setEnabled(true);
					cbLoaiNghi.setEnabled(true);
				}
			}
		});
		chkKhoaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chkKhoaNhap.setBounds(746, 343, 108, 30);
		contentPane.add(chkKhoaNhap);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(959, 337, 209, 37);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("T\u00ECm ki\u1EBFm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((DefaultTableModel) tblDonNghi.getModel());
				sorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
				tblDonNghi.setRowSorter(sorter);
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearch.setBounds(1178, 337, 96, 37);
		contentPane.add(btnSearch);
		
		JButton btnIn = new JButton("In b\u1EA3ng .txt");
		btnIn.setForeground(new Color(60, 179, 113));
		btnIn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnIn.setBounds(602, 336, 138, 37);
		contentPane.add(btnIn);
		
		JLabel lblCit_1 = new JLabel("C\u00E0i \u0111\u1EB7t");
		lblCit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCit_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCit_1.setBounds(1101, 91, 67, 14);
		contentPane.add(lblCit_1);
		
		dcNgayNghi = new JDateChooser();
		dcNgayNghi.setBounds(837, 134, 234, 30);
		contentPane.add(dcNgayNghi);
		
		JButton btnScript = new JButton("\u0110\u1ED5 d\u1EEF li\u1EC7u = script");
		btnScript.setForeground(new Color(60, 179, 113));
		btnScript.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnScript.setBounds(10, 288, 286, 37);
		contentPane.add(btnScript);
		
		//Codey tay
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
            String query = "select * from DonXinNghi";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DefaultTableModel tableModel = (DefaultTableModel) tblDonNghi.getModel(); 
                tableModel.addRow(new Object[] {
                		rs.getString("maDonNghi"),
                		rs.getString("maNhanVien"),
                		rs.getString("tenNhanVien"),
                		rs.getString("loaiNhanVien"),
                		rs.getDate("ngayNghi"),
                		rs.getString("lyDoNghi"),
                		rs.getString("loaiNghi")
                });
            }
            query = "select top 1 stt from DonXinNghi order by stt desc";
            rs=stmt.executeQuery(query);
            rs.next();
            int stt=rs.getInt(1) +1;
            txtMaDN.setText("DN"+stt);
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public static void taiLai() {
		SwingUtilities.updateComponentTreeUI(frame);
		frame.dispose();
		main(null);
	}
}
