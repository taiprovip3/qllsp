package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class DoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtPWcu;
	private JPasswordField txtPWmoi;
	private JPasswordField txtPWmoi2;
	private JCheckBox chkShowPW;

	/**
	 * Launch the application.
	 */
	public static void main(final String un) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau frame = new DoiMatKhau(un);
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
	public DoiMatKhau(final String un) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangChu.main(un);
			}
		});
		btnNewButton.setIcon(new ImageIcon("F:\\Hoc ki 3\\Java Phan Tan\\Project-Ptud\\qllsp\\n11_qllsp\\data\\icon\\back.png"));
		btnNewButton.setBounds(790, 249, 52, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 216, 20);
		contentPane.add(lblNewLabel);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setEditable(false);
		txtTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenDangNhap.setBounds(10, 32, 216, 30);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		JLabel lblMtKhuC = new JLabel("M\u1EADt kh\u1EA9u c\u0169:");
		lblMtKhuC.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMtKhuC.setBounds(10, 67, 216, 20);
		contentPane.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi:");
		lblMtKhuMi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMtKhuMi.setBounds(10, 123, 216, 20);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u m\u1EDBi:");
		lblNhpLiMt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNhpLiMt.setBounds(10, 176, 216, 20);
		contentPane.add(lblNhpLiMt);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = Database.getConnection();
		        Statement stmt = null;
		        PreparedStatement preStmt = null;
		        try {
		            stmt = conn.createStatement();
		            String query = "select * from NguoiDung where tenDangNhap = '"+un+"'";
		            ResultSet rs = stmt.executeQuery(query);
		            rs.next();
		            String password = rs.getString("matKhau");
		            if(password.equals(txtPWcu.getText()))
            		{
		            	if(txtPWmoi.getText().equals(txtPWmoi2.getText()))
		            	{
		            		if(txtPWmoi.getText().length() >= 1)
		            		{
		            			String sql = "update NguoiDung set matKhau = ? where tenDangNhap = ?";
		            			preStmt = conn.prepareCall(sql);
		            			preStmt.setString(1, txtPWmoi.getText());
		            			preStmt.setString(2, un);
		            			preStmt.execute();
		            			JOptionPane.showMessageDialog(contentPane, "Đổi pass thành công!");
		            			dispose();
		            			TrangChu.main(un);
		            		}else
		            			JOptionPane.showMessageDialog(contentPane, "Mật khẩu mới ít nhất 8 kí tự!");
		            	}else
		            		JOptionPane.showMessageDialog(contentPane, "Nhập lại mật khẩu ko trùng khớp");
            		}else
            			JOptionPane.showMessageDialog(contentPane, "Sai mật khẩu cũ!");
		        } catch (SQLException ex) {
		            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 238, 146, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(735, 11, 97, 14);
		contentPane.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(735, 27, 97, 14);
		contentPane.add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(391, 11, 16, 268);
		contentPane.add(separator);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"- M\u1EADt kh\u1EA9u m\u1EDBi kh\u00F4ng \u0111\u01B0\u1EE3c tr\u00F9ng m\u1EADt kh\u1EA9u c\u0169", "- M\u1EADt kh\u1EA9u m\u1EDBi \u00EDt nh\u1EA5t l\u00E0 8 k\u00ED t\u1EF1", "- Kh\u00F4ng b\u1ECF tr\u1ED1ng m\u1EADt kh\u1EA9u (not space)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(435, 51, 344, 187);
		contentPane.add(list);
		
		txtPWcu = new JPasswordField();
		txtPWcu.setBounds(10, 90, 216, 30);
		contentPane.add(txtPWcu);
		
		txtPWmoi = new JPasswordField();
		txtPWmoi.setBounds(10, 146, 216, 30);
		contentPane.add(txtPWmoi);
		
		txtPWmoi2 = new JPasswordField();
		txtPWmoi2.setBounds(10, 197, 216, 30);
		contentPane.add(txtPWmoi2);
		
		chkShowPW = new JCheckBox("Hiện mật khẩu");
		chkShowPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkShowPW.isSelected())
				{
					txtPWcu.setEchoChar((char)0);
					txtPWmoi.setEchoChar((char)0);
					txtPWmoi2.setEchoChar((char)0);
				}
				else{
					txtPWcu.setEchoChar('*');
					txtPWmoi.setEchoChar('*');
					txtPWmoi2.setEchoChar('*');
				}
			}
		});
		chkShowPW.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chkShowPW.setBounds(159, 242, 140, 30);
		contentPane.add(chkShowPW);
		
		//Code tay
		txtTenDangNhap.setText(un);
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
	}
}
