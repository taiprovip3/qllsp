package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import connectDB.Database;
import connectDB.testDatabase;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;

public class BangChamCong_danhsach extends JFrame {

	private JPanel contentPane;
	private JTable tblBangChamCong;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangChamCong_danhsach frame = new BangChamCong_danhsach();
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
	public BangChamCong_danhsach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quay l\u1EA1i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyBangChamCong.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 407, 105, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chuy\u1EC3n t\u1EDBi CRUD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tblBangChamCong.getSelectedRow();
				if(a != -1)
				{
					String maPXPre = tblBangChamCong.getValueAt(a,1).toString();
					BangChamCong_chitiet.main(maPXPre);
					dispose();
				}else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn dòng cần CRUD");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(648, 407, 178, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch C\u00E1c b\u1EA3ng ch\u1EA5m c\u00F4ng \u0111\u00E3 L\u01B0u");
		lblNewLabel.setForeground(new Color(60, 179, 113));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 816, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 816, 349);
		contentPane.add(scrollPane);
		
		tblBangChamCong = new JTable();
		tblBangChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblBangChamCong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 BCC", "M\u00E3 Ph\u00E2n x\u01B0\u1EDFng", "Nghi\u1EC7p v\u1EE5", "V\u1ECB tr\u00ED", "S\u1ED1 l\u01B0\u1EE3ng C\u00F4ng nh\u00E2n", "Ng\u01B0\u1EDDi \u0111\u1EA1i di\u1EC7n", "Ng\u00E0y ch\u1EA5m c\u00F4ng"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblBangChamCong.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tblBangChamCong);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(148, 399, 117, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTime.setBounds(6, 11, 105, 14);
		panel.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(6, 31, 105, 14);
		panel.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSearch.setBounds(294, 407, 222, 37);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((DefaultTableModel) tblBangChamCong.getModel());
				sorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
				tblBangChamCong.setRowSorter(sorter);
			}
		});
		btnSearch.setBounds(526, 409, 109, 37);
		contentPane.add(btnSearch);
		
		//Codey tay
		loadDataFromCSDL();
	}

	private void loadDataFromCSDL() {
		Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String query = "select * from DanhSachBangChamCong";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DefaultTableModel tableModel = (DefaultTableModel) tblBangChamCong.getModel(); 
                tableModel.addRow(new Object[] {
                		rs.getString("maBangChamCong"),
                		rs.getString("maPhanXuong"),
                		rs.getString("nghiepVu"),
                		rs.getString("viTri"),
                		rs.getInt("soLuongCongNhan"),
                		rs.getString("nguoiDaiDien"),
                		rs.getTimestamp("ngayChamCong")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
