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
import javax.swing.JTextArea;

public class ThongKe_hopdong extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(final int subMonth) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe_hopdong frame = new ThongKe_hopdong(subMonth);
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
	public ThongKe_hopdong(int subMonth) {
		setTitle("SalaryForm > th\u1ED1ng k\u00EA > H\u1EE3p \u0111\u1ED3ng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 173);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u00E1ng", "T\u1ED5ng ti\u1EC1n H\u1EE3p \u0111\u1ED3ng"
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
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADn x\u00E9t:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 195, 664, 20);
		contentPane.add(lblNewLabel);
		
		ta = new JTextArea();
		ta.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ta.setEditable(false);
		ta.setBounds(10, 226, 664, 75);
		contentPane.add(ta);
		getLocalTime.showTime();
		getLocalTime.showDate();
		
		calCulateHopDong(subMonth);
	}
	
	private void calCulateHopDong(int subMonth) {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
        	Locale locale = new Locale("vi", "VN");
        	NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        	DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
            tblModel.setRowCount(0);
            stmt = conn.createStatement();
            String query = "select sum(tienHopDong) as Tong_Tien from HopDong where month(ngayKyHopDong) = "+subMonth+"";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            	Float tt =rs.getFloat("Tong_Tien");
            	tblModel.addRow(new Object[] {
                		subMonth,nf.format(tt)
                });
            subMonth = subMonth -1;
            query = "select sum(tienHopDong) as Tong_Tien from HopDong where month(ngayKyHopDong) = "+subMonth+"";
            rs = stmt.executeQuery(query);
            rs.next();
            float tt2 = rs.getFloat("Tong_Tien");
            ta.append("Tổng tiền hợp đồng tháng trước: "+nf.format(tt2)+"\n");
        	ta.append("Tổng tiền hợp đồng tháng này: "+nf.format(tt)+"\n");
            if(tt > tt2) {
            	float nhieuhon =tt-tt2;
            	ta.append("=> Doanh thu tháng này > tháng trước: "+nf.format(nhieuhon)+"\n");
            } else {
            	if(tt == tt2)
                	ta.append("=> Doanh thu tháng này = tháng trước!\n");
            	else {
            		float ithon =tt2 - tt;
            		ta.append("=> Doanh thu tháng này < tháng trước: "+nf.format(ithon)+"\n");
            	}
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
