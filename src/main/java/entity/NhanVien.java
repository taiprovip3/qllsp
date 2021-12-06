/**
 * PHAN TẤN TÀI - 19524791
 * Là thuộc tính của nhân viên chung. Nhân viên gồm 2 loại là congnhan va nhanvienhanhchinh
 */
package entity;

import java.util.Date;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private int namSinh;
	private String gioiTinh;
	private Date ngayKhoiCong;
	private String soDienThoai;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	public void setNgayKhoiCong(Date ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien, String tenNhanVien, int namSinh, String gioiTinh, Date ngayKhoiCong,
			String soDienThoai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.ngayKhoiCong = ngayKhoiCong;
		this.soDienThoai = soDienThoai;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", namSinh=" + namSinh
				+ ", gioiTinh=" + gioiTinh + ", ngayKhoiCong=" + ngayKhoiCong + ", soDienThoai=" + soDienThoai + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
}
