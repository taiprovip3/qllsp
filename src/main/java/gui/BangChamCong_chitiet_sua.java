package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BangChamCong_chitiet_sua extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtMaSanPham;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtPhanXuong;
	private JTable tblBangChamCong;
	private static DefaultTableModel tableModel;
	private JComboBox cbMa;
	private JComboBox cbMaSanPham;
	private JComboBox cbSoLuong;
	private JComboBox cbNgay;
	private JComboBox cbPhanXuong;
	private JDateChooser dcNgay;

	/**
	 * Launch the application.
	 */
	public static void main(final String macn, final String tencn, final String masp, final String sl, final String dg, final String ncc, final String mapx) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangChamCong_chitiet_sua frame = new BangChamCong_chitiet_sua();
					frame.setVisible(true);
					loadDuLieuCanSua(macn, tencn, masp, sl, dg, ncc, mapx);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BangChamCong_chitiet_sua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EEDa d\u1EEF li\u1EC7u th\u00E0nh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 80, 699, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã công nhân:");
		lblNewLabel.setBounds(6, 16, 118, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cbMa = new JComboBox();
		cbMa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbMa.getSelectedItem().toString().equals("Nhập tay")) {
					txtMa.setEditable(true);
				}else {
					txtMa.setEditable(false);
					txtMa.setText("");
				}
				if(cbMa.getSelectedItem().toString().equals("Tùy chọn"))
				{
					cbMa.setSelectedIndex(2);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa các chọn bên dưới");
				}
			}
		});
		cbMa.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Nhập tay", "CN1", "CN2", "CN3", "CN4", "CN5", "CN6", "CN7", "CN8", "CN9", "CN10"}));
		cbMa.setBounds(6, 44, 188, 28);
		panel.add(cbMa);
		cbMa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtMa = new JTextField();
		txtMa.setBounds(204, 44, 265, 28);
		panel.add(txtMa);
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMa.setEditable(false);
		txtMa.setColumns(10);
		
		JLabel lblTnCngNhn = new JLabel("Tên công nhân:");
		lblTnCngNhn.setBounds(6, 67, 118, 28);
		panel.add(lblTnCngNhn);
		lblTnCngNhn.setForeground(new Color(47, 79, 79));
		lblTnCngNhn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtTen = new JTextField();
		txtTen.setBounds(6, 95, 463, 28);
		panel.add(txtTen);
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen.setColumns(10);
		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setBounds(6, 120, 118, 28);
		panel.add(lblMSnPhm);
		lblMSnPhm.setForeground(new Color(47, 79, 79));
		lblMSnPhm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cbMaSanPham = new JComboBox();
		cbMaSanPham.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbMaSanPham.getSelectedItem().toString().equals("Nhập tay")) {
					txtMaSanPham.setEditable(true);
				}else {
					txtMaSanPham.setEditable(false);
					txtMaSanPham.setText("");
				}
				if(cbMaSanPham.getSelectedItem().toString().equals("Tùy chọn"))
				{
					cbMaSanPham.setSelectedIndex(2);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa các chọn bên dưới");
				}
			}
		});
		cbMaSanPham.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Nhập tay", "SP1", "SP2", "SP3", "SP4", "SP5", "SP6", "SP7", "SP8", "SP9", "SP10"}));
		cbMaSanPham.setBounds(6, 146, 188, 28);
		panel.add(cbMaSanPham);
		cbMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setBounds(204, 147, 265, 28);
		panel.add(txtMaSanPham);
		txtMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaSanPham.setEditable(false);
		txtMaSanPham.setColumns(10);
		
		JLabel lblSLngSn = new JLabel("Số lượng sản phẩm:");
		lblSLngSn.setBounds(6, 173, 143, 28);
		panel.add(lblSLngSn);
		lblSLngSn.setForeground(new Color(47, 79, 79));
		lblSLngSn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cbSoLuong = new JComboBox();
		cbSoLuong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbSoLuong.getSelectedItem().toString().equals("Nhập tay")) {
					txtSoLuong.setEditable(true);
				}else {
					txtSoLuong.setEditable(false);
					txtSoLuong.setText("");
				}
				if(cbSoLuong.getSelectedItem().toString().equals("Tùy chọn"))
				{
					cbSoLuong.setSelectedIndex(2);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa các chọn bên dưới");
				}
			}
		});
		cbSoLuong.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Nhập tay", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50"}));
		cbSoLuong.setBounds(6, 201, 188, 28);
		panel.add(cbSoLuong);
		cbSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(204, 201, 265, 28);
		panel.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		
		JLabel lblNhpnGi = new JLabel("Nhập đơn giá:");
		lblNhpnGi.setBounds(6, 225, 101, 28);
		panel.add(lblNhpnGi);
		lblNhpnGi.setForeground(new Color(47, 79, 79));
		lblNhpnGi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Không thêm \".\" hay \",\"");
		lblNewLabel_1.setBounds(132, 234, 150, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(6, 253, 276, 28);
		panel.add(txtDonGia);
		txtDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGia.setColumns(10);
		
		JLabel lblChnNgyChm = new JLabel("Chọn ngày chấm công:");
		lblChnNgyChm.setBounds(6, 276, 276, 28);
		panel.add(lblChnNgyChm);
		lblChnNgyChm.setForeground(new Color(47, 79, 79));
		lblChnNgyChm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cbNgay = new JComboBox();
		cbNgay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbNgay.getSelectedItem().toString().equals("Chọn tay")) {
					dcNgay.setEnabled(true);
				}else {
					dcNgay.setEnabled(false);
					Date d =new Date(); 
					dcNgay.setDate(d);
				}
				if(cbNgay.getSelectedItem().toString().equals("Tùy chọn"))
				{
					cbSoLuong.setSelectedIndex(2);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa các chọn bên dưới");
				}
			}
		});
		cbNgay.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Chọn tay", "Tự động now()"}));
		cbNgay.setBounds(6, 305, 188, 28);
		panel.add(cbNgay);
		cbNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		dcNgay = new JDateChooser();
		dcNgay.setBounds(204, 305, 265, 28);
		panel.add(dcNgay);
		dcNgay.setEnabled(false);
		
		JLabel lblThucPhnXng = new JLabel("Thuộc phân xưởng:");
		lblThucPhnXng.setBounds(6, 333, 276, 28);
		panel.add(lblThucPhnXng);
		lblThucPhnXng.setForeground(new Color(47, 79, 79));
		lblThucPhnXng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cbPhanXuong = new JComboBox();
		cbPhanXuong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbPhanXuong.getSelectedItem().toString().equals("Nhập tay")) {
					txtPhanXuong.setEditable(true);
				}else {
					txtPhanXuong.setEditable(false);
					txtPhanXuong.setText("");
				}
				if(cbPhanXuong.getSelectedItem().toString().equals("Tùy chọn"))
				{
					cbPhanXuong.setSelectedIndex(2);
					JOptionPane.showMessageDialog(contentPane, "Vui lòng lựa các chọn bên dưới");
				}
			}
		});
		cbPhanXuong.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Nhập tay", "PX1", "PX2", "PX3", "PX4", "PX5", "PX6", "PX7", "PX8", "PX9", "PX10"}));
		cbPhanXuong.setBounds(6, 357, 188, 28);
		panel.add(cbPhanXuong);
		cbPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtPhanXuong = new JTextField();
		txtPhanXuong.setBounds(204, 357, 265, 28);
		panel.add(txtPhanXuong);
		txtPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPhanXuong.setEditable(false);
		txtPhanXuong.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u v\u1EEBa ch\u1ECDn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, -3, 827, 75);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 815, 53);
		panel_1.add(scrollPane);
		
		tblBangChamCong = new JTable();
		tblBangChamCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					txtMa.setText(tblBangChamCong.getValueAt(0,0).toString());
					txtTen.setText(tblBangChamCong.getValueAt(0,1).toString());
					txtMaSanPham.setText(tblBangChamCong.getValueAt(0,2).toString());
					txtSoLuong.setText(tblBangChamCong.getValueAt(0,3).toString());
					txtDonGia.setText(tblBangChamCong.getValueAt(0,4).toString());
					Timestamp ts = Timestamp.valueOf(tblBangChamCong.getValueAt(0,5).toString());
					Date date=new Date(ts.getTime());
					dcNgay.setDate(date);
					txtPhanXuong.setText(tblBangChamCong.getValueAt(0,6).toString());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		tblBangChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblBangChamCong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 c\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "M\u00E3 ph\u00E2n x\u01B0\u1EDFng"
			}
		));
		scrollPane.setViewportView(tblBangChamCong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel_2.setBounds(713, 416, 112, 63);
		contentPane.add(panel_2);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 100, 20);
		panel_2.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 37, 100, 20);
		panel_2.add(lblDate);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCN;
				String tenCN =txtTen.getText();
				String maSP;
				int sl;
				float dg=Float.parseFloat(txtDonGia.getText());
				Timestamp ngayCC;
				String maPX;
				String a = cbMa.getSelectedItem().toString();
				if(a.equals("Nhập tay"))
					maCN = txtMa.getText();
				else
					maCN = a;
				a = cbMaSanPham.getSelectedItem().toString();
				if(a.equals("Nhập tay"))
					maSP = txtMaSanPham.getText();
				else 
					maSP =a;
				a= cbSoLuong.getSelectedItem().toString();
				if(a.equals("Nhập tay"))
					sl=Integer.parseInt(txtSoLuong.getText());
				else
					sl=Integer.parseInt(a);
				a=cbNgay.getSelectedItem().toString();
				if(a.equals("Chọn tay"))
					ngayCC=new Timestamp(dcNgay.getDate().getTime());
				else {
					Date d = new Date();
					ngayCC = new Timestamp(d.getTime());
				}
				a=cbPhanXuong.getSelectedItem().toString();
				if(a.equals("Nhập tay"))
					maPX=txtPhanXuong.getText();
				else
					maPX=a;
				Connection conn = Database.getConnection();
				PreparedStatement stmt = null;
		        try {
		        	String query = "update BangChamCong set maCongNhan = ?, tenCongNhan = ?, maSanPham = ?,soLuong = ?, donGia = ?,ngayChamCong =?, maPhanXuong = ? where maSanPham = ?";
		            stmt = conn.prepareCall(query);
		            stmt.setString(1, maCN);
		            stmt.setString(2, tenCN);
		            stmt.setString(3, maSP);
		            stmt.setInt(4, sl);
		            stmt.setFloat(5, dg);
		            stmt.setTimestamp(6, ngayCC);
		            stmt.setString(7, maPX);
		            stmt.setString(8, tblBangChamCong.getValueAt(0, 2).toString());
		            stmt.execute();
	                int cf= JOptionPane.showConfirmDialog(contentPane, "Sửa thành công, cần tải lại?");
	                if(cf==JOptionPane.YES_OPTION) {
	                	BangChamCong_chitiet.taiLai(tblBangChamCong.getValueAt(0,6).toString());
						dispose();
	                }
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(6, 490, 118, 34);
		contentPane.add(btnNewButton);
		
		JButton btnXaRng = new JButton("Xóa rỗng");
		btnXaRng.setBackground(new Color(60, 179, 113));
		btnXaRng.setForeground(new Color(0, 255, 0));
		btnXaRng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXaRng.setBounds(132, 490, 118, 34);
		contentPane.add(btnXaRng);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setForeground(new Color(255, 0, 0));
		btnThot.setBackground(new Color(128, 0, 0));
		btnThot.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThot.setBounds(707, 490, 118, 34);
		contentPane.add(btnThot);
		
		//Code tay
		tableModel = (DefaultTableModel) tblBangChamCong.getModel();
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
	public static void loadDuLieuCanSua(String macn, String tencn, String masp, String sl, String dg, String ncc, String mapx) {
		tableModel.addRow(new Object[] {
				macn,tencn,masp,sl,dg,ncc,mapx
		});
	}
}
