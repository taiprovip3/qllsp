package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ItemEvent;

public class BangChamCong_chitiet_them extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtPhanXuong;
	private JComboBox cbMa;
	private JComboBox cbSoLuong;
	private JComboBox cbNgay;
	private JDateChooser dcNgay;
	private int signMa = 0, signMaSanPham = 0, signSoLuong = 0, signNgay = 0;
	private JTextField txtMaSanPham;
	private JComboBox cbMaSanPham;

	/**
	 * Launch the application.
	 */
	public static void main(final String maPXPre) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangChamCong_chitiet_them frame = new BangChamCong_chitiet_them(maPXPre);
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
	public BangChamCong_chitiet_them(final String maPXPre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 c\u00F4ng nh\u00E2n:");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 0, 118, 28);
		contentPane.add(lblNewLabel);
		
		cbMa = new JComboBox();
		cbMa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbMa.getSelectedIndex() > 0)
				{
					String getMa = cbMa.getSelectedItem().toString();
					if(getMa.equals("Nhập tay"))
					{
						txtMa.setEditable(true);
						signMa = 1;
					}else {
						txtMa.setEditable(false);
						txtMa.setText("");
						signMa = 0;
					}
				}else 
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn các tùy chọn bên dưới");
			}
		});
		cbMa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMa.setModel(new DefaultComboBoxModel(new String[] {"T\u00F9y ch\u1ECDn", "Nh\u1EADp tay", "CN1", "CN2", "CN3", "CN4", "CN5", "CN6", "CN7", "CN8", "CN9", "CN10"}));
		cbMa.setBounds(10, 28, 188, 28);
		contentPane.add(cbMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMa.setEditable(false);
		txtMa.setBounds(208, 28, 265, 28);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblTnCngNhn = new JLabel("T\u00EAn c\u00F4ng nh\u00E2n:");
		lblTnCngNhn.setForeground(new Color(47, 79, 79));
		lblTnCngNhn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnCngNhn.setBounds(10, 51, 118, 28);
		contentPane.add(lblTnCngNhn);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen.setColumns(10);
		txtTen.setBounds(10, 79, 463, 28);
		contentPane.add(txtTen);
		
		JLabel lblSLngSn = new JLabel("S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m:");
		lblSLngSn.setForeground(new Color(47, 79, 79));
		lblSLngSn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSLngSn.setBounds(10, 157, 143, 28);
		contentPane.add(lblSLngSn);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(208, 185, 265, 28);
		contentPane.add(txtSoLuong);
		
		cbSoLuong = new JComboBox();
		cbSoLuong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbSoLuong.getSelectedIndex() > 0)
				{
					String getsoLuong = cbSoLuong.getSelectedItem().toString();
					if(getsoLuong.equals("Nhập tay"))
					{
						txtSoLuong.setEditable(true);
						signSoLuong = 1;
					}else {
						txtSoLuong.setEditable(false);
						txtSoLuong.setText("");
						signSoLuong = 0;
					}
				} else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn các tùy chọn bên dưới");
			}
		});
		cbSoLuong.setModel(new DefaultComboBoxModel(new String[] {"T\u00F9y ch\u1ECDn", "Nh\u1EADp tay", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"}));
		cbSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbSoLuong.setBounds(10, 185, 188, 28);
		contentPane.add(cbSoLuong);
		
		JLabel lblNhpnGi = new JLabel("Nh\u1EADp \u0111\u01A1n gi\u00E1:");
		lblNhpnGi.setForeground(new Color(47, 79, 79));
		lblNhpnGi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNhpnGi.setBounds(10, 209, 101, 28);
		contentPane.add(lblNhpnGi);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(10, 237, 276, 28);
		contentPane.add(txtDonGia);
		
		JLabel lblNewLabel_1 = new JLabel("Kh\u00F4ng th\u00EAm \".\" hay \",\"");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(136, 218, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblChnNgyChm = new JLabel("Ch\u1ECDn ng\u00E0y ch\u1EA5m c\u00F4ng:");
		lblChnNgyChm.setForeground(new Color(47, 79, 79));
		lblChnNgyChm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChnNgyChm.setBounds(10, 260, 276, 28);
		contentPane.add(lblChnNgyChm);
		
		dcNgay = new JDateChooser();
		dcNgay.setBounds(208, 289, 265, 28);
		contentPane.add(dcNgay);
		dcNgay.setEnabled(false);
		
		cbNgay = new JComboBox();
		cbNgay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbNgay.getSelectedIndex() > 0)
				{
					String getNgay = cbNgay.getSelectedItem().toString();
					if(getNgay.equals("Chọn tay"))
					{
						signNgay = 1;
						dcNgay.setEnabled(true);
					}else {
						dcNgay.setEnabled(false);
						Date d = new Date();
						dcNgay.setDate(d);
						signNgay = 0;
					}
				} else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn các tùy chọn bên dưới");
			}
		});
		cbNgay.setModel(new DefaultComboBoxModel(new String[] {"T\u00F9y ch\u1ECDn", "Ch\u1ECDn tay", "Ch\u1ECDn now()"}));
		cbNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbNgay.setBounds(10, 289, 188, 28);
		contentPane.add(cbNgay);
		
		JLabel lblThucPhnXng = new JLabel("Thu\u1ED9c ph\u00E2n x\u01B0\u1EDFng:");
		lblThucPhnXng.setForeground(new Color(47, 79, 79));
		lblThucPhnXng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblThucPhnXng.setBounds(10, 317, 276, 28);
		contentPane.add(lblThucPhnXng);
		
		txtPhanXuong = new JTextField();
		txtPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPhanXuong.setEditable(false);
		txtPhanXuong.setColumns(10);
		txtPhanXuong.setBounds(10, 341, 265, 28);
		contentPane.add(txtPhanXuong);
		txtPhanXuong.setText(maPXPre);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma;
				String ten = txtTen.getText();
				String masp;
				int sl;
				float dg = Float.parseFloat(txtDonGia.getText());
				Timestamp ngay;
				String mapx =maPXPre;

				if(signMa == 0)
					ma = cbMa.getSelectedItem().toString();
				else
					ma = txtMa.getText();
				if(signMaSanPham == 0)
					masp = cbMaSanPham.getSelectedItem().toString();
				else
					masp = txtMaSanPham.getText();
				if(signSoLuong == 0)
					sl = Integer.parseInt(cbSoLuong.getSelectedItem().toString());
				else
					sl = Integer.parseInt(txtSoLuong.getText());
				if(signNgay == 0)
				{
					Date date = new Date();
					ngay = new Timestamp(date.getTime());
				}else
					ngay = new Timestamp(dcNgay.getDate().getTime());
				Connection conn = Database.getConnection();
		        PreparedStatement stmt = null;
		        try {
		            String query = "insert into BangChamCong values (?,?,?,?,?,?,?)";
		            stmt = conn.prepareCall(query);
		            stmt.setString(1, ma);
		            stmt.setString(2, ten);
		            stmt.setString(3, masp);
		            stmt.setInt(4, sl);
		            stmt.setFloat(5, dg);
		            stmt.setTimestamp(6, ngay);
		            stmt.setString(7, mapx);
		            stmt.execute();
		            int cf = JOptionPane.showConfirmDialog(contentPane, "Thêm thành công, vui lòng tải lại bảng!");
		            if(cf == JOptionPane.YES_OPTION)
					{
						BangChamCong_chitiet.taiLai(maPXPre);
						dispose();
					}
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setForeground(Color.GREEN);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnThem.setBounds(-1, 380, 129, 40);
		contentPane.add(btnThem);
		
		JButton btnXoaRong = new JButton("X\u00F3a r\u1ED7ng");
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnXoaRong.setForeground(Color.GREEN);
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnXoaRong.setBackground(new Color(0, 128, 0));
		btnXoaRong.setBounds(344, 380, 129, 40);
		contentPane.add(btnXoaRong);
		
		JButton btnDong = new JButton("Thoát");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDong.setForeground(new Color(255, 0, 0));
		btnDong.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnDong.setBackground(new Color(139, 0, 0));
		btnDong.setBounds(734, 392, 101, 28);
		contentPane.add(btnDong);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(723, 0, 112, 63);
		contentPane.add(panel);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 100, 20);
		panel.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 37, 100, 20);
		panel.add(lblDate);
		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setForeground(new Color(47, 79, 79));
		lblMSnPhm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMSnPhm.setBounds(10, 104, 118, 28);
		contentPane.add(lblMSnPhm);
		
		cbMaSanPham = new JComboBox();
		cbMaSanPham.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbMaSanPham.getSelectedIndex() > 0)
				{
					String maSanPham = cbMaSanPham.getSelectedItem().toString();
					if(maSanPham.equals("Nhập tay"))
					{
						signMaSanPham = 1;
						txtMaSanPham.setEditable(true);
					}else{
						signMaSanPham = 0;
						txtMaSanPham.setEditable(false);
						txtMaSanPham.setText("");
					}
				}else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn các tùy chọn bên dưới");
			}
		});
		cbMaSanPham.setModel(new DefaultComboBoxModel(new String[] {"Tùy chọn", "Nhập tay", "SP1", "SP2", "SP3", "SP4", "SP5", "SP6", "SP7", "SP8", "SP9", "SP10"}));
		cbMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbMaSanPham.setBounds(10, 130, 188, 28);
		contentPane.add(cbMaSanPham);
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaSanPham.setEditable(false);
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(208, 131, 265, 28);
		contentPane.add(txtMaSanPham);
		
		//Codey tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
	private void xoaRong() {
		txtMa.setText("");
		cbMa.setSelectedIndex(0);
		txtTen.setText("");
		cbSoLuong.setSelectedIndex(0);
		txtSoLuong.setText("");
		txtDonGia.setText("");
		cbNgay.setSelectedIndex(0);
		Date date = new Date();
		dcNgay.setDate(date);
		txtPhanXuong.setText("");
	}
}
