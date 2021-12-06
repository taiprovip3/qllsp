/**
 * PHAN TẤN TÀI - 19524791
 * Lưu trữ thuộc tính của nhân viên hành chính và kế thừa thuộc tính chung từ lớp NhanVien
 */
package entity;

import java.util.Date;

public class NhanVienHanhChinh extends NhanVien{
	private PhongBan phongBan;

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public NhanVienHanhChinh() {
		super();
	}

	public NhanVienHanhChinh(String maNhanVien, String tenNhanVien, int namSinh, String gioiTinh, Date ngayKhoiCong,
			String soDienThoai, PhongBan phongBan) {
		super(maNhanVien, tenNhanVien, namSinh, gioiTinh, ngayKhoiCong, soDienThoai);
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return "NhanVienHanhChinh [getPhongBan()=" + getPhongBan() + ", getMaNhanVien()=" + getMaNhanVien()
				+ ", getTenNhanVien()=" + getTenNhanVien() + ", getNamSinh()=" + getNamSinh() + ", getGioiTinh()="
				+ getGioiTinh() + ", getNgayKhoiCong()=" + getNgayKhoiCong() + ", getSoDienThoai()=" + getSoDienThoai()
				+ "]";
	}
}
