/**
 * PHAN TẤN TÀI - 19524791
 * Lớp Công nhân kế thừa thuộc tính chung từ NhanVien và có thuộc tính riêng là maPhanXuong.
 */
package entity;

import java.util.Date;

public class CongNhan extends NhanVien{
	private PhanXuong phanXuong;

	public PhanXuong getPhanXuong() {
		return phanXuong;
	}

	public void setPhanXuong(PhanXuong phanXuong) {
		this.phanXuong = phanXuong;
	}

	public CongNhan() {
	}

	public CongNhan(String maNhanVien, String tenNhanVien, int namSinh, String gioiTinh, Date ngayKhoiCong,
			String soDienThoai, PhanXuong phanXuong) {
		super(maNhanVien, tenNhanVien, namSinh, gioiTinh, ngayKhoiCong, soDienThoai);
		this.phanXuong = phanXuong;
	}

	@Override
	public String toString() {
		return "CongNhan [getPhanXuong()=" + getPhanXuong() + ", toString()=" + super.toString() + "]";
	}
}
