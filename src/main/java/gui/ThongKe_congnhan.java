package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;
import connectDB.testDatabase;
import util.GetLocalTime;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongKe_congnhan extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(final String sign, final int subMonth) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe_congnhan frame = new ThongKe_congnhan(sign,subMonth);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongKe_congnhan(String sign, int subMonth) {
		setTitle("SalaryForm > th\u1ED1ng k\u00EA > C\u00F4ng Nh\u00E2n EAGER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				" M\u00E3 C\u00F4ng Nh\u00E2n", "Th\u00E1ng", "T\u1ED5ng ti\u1EC1n S\u1EA3n Ph\u1EA9m"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u0110\u00F3ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(734, 265, 99, 36);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47, 79, 79)));
		panel_1.setBounds(736, 11, 97, 55);
		contentPane.add(panel_1);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 16, 85, 17);
		panel_1.add(lblTime);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 32, 85, 17);
		panel_1.add(lblDate);
		
		//Code tay
		GetLocalTime getLocalTime = new GetLocalTime(lblDate, lblTime);
		getLocalTime.showTime();
		getLocalTime.showDate();
		
		if(sign.equalsIgnoreCase("chamchi")) {
			calCulateChamChi(subMonth);
		} else {
			calCulateLuoiBieng(subMonth);
		}
	}
	
	private void calCulateChamChi(int subMonth) {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
        	Locale locale = new Locale("vi", "VN");
        	NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
            stmt = conn.createStatement();
            String query = "select maCongNhan,sum(soLuong*donGia) as TONG_TIEN_SAN_PHAM from BangChamCong where month(ngayChamCong) = "+subMonth+" group by maCongNhan order by TONG_TIEN_SAN_PHAM desc";
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
            tblModel.setRowCount(0);
            while(rs.next()){
            	tblModel.addRow(new Object[] {
                		rs.getString("maCongNhan"),subMonth,nf.format(rs.getFloat("TONG_TIEN_SAN_PHAM"))
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private void calCulateLuoiBieng(int subMonth) {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
        	Locale locale = new Locale("vi", "VN");
        	NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
            stmt = conn.createStatement();
            String query = "select maCongNhan,sum(soLuong*donGia) as TONG_TIEN_SAN_PHAM from BangChamCong where month(ngayChamCong) = "+subMonth+" group by maCongNhan order by TONG_TIEN_SAN_PHAM";
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
            tblModel.setRowCount(0);
            while(rs.next()){
            	tblModel.addRow(new Object[] {
                		rs.getString("maCongNhan"),subMonth,nf.format(rs.getFloat("TONG_TIEN_SAN_PHAM"))
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
