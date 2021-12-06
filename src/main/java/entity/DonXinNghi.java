/**
 * PHAN TẤN TÀI - 19524791
 * Lưu trữ danh sách nhân viên gồm CN và NVHC xin nghỉ trong ngày!
 */
package entity;

import java.util.Date;

public class DonXinNghi {
	private String maDonNghi;
	private String maNhanVien;
	private String tenNhanVien;
	private String loaiNhanVien;
	private Date ngayNghi;
	private String lyDoNghi;
	private String loaiNghi;
	
	public String getMaDonNghi() {
		return maDonNghi;
	}
	public void setMaDonNghi(String maDonNghi) {
		this.maDonNghi = maDonNghi;
	}
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
	public String getLoaiNhanVien() {
		return loaiNhanVien;
	}
	public void setLoaiNhanVien(String loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}
	public Date getNgayNghi() {
		return ngayNghi;
	}
	public void setNgayNghi(Date ngayNghi) {
		this.ngayNghi = ngayNghi;
	}
	public String getLyDoNghi() {
		return lyDoNghi;
	}
	public void setLyDoNghi(String lyDoNghi) {
		this.lyDoNghi = lyDoNghi;
	}
	public String getLoaiNghi() {
		return loaiNghi;
	}
	public void setLoaiNghi(String loaiNghi) {
		this.loaiNghi = loaiNghi;
	}
	public DonXinNghi() {
		super();
	}
	public DonXinNghi(String maDonNghi, String maNhanVien, String tenNhanVien, String loaiNhanVien, Date ngayNghi,
			String lyDoNghi, String loaiNghi) {
		super();
		this.maDonNghi = maDonNghi;
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.loaiNhanVien = loaiNhanVien;
		this.ngayNghi = ngayNghi;
		this.lyDoNghi = lyDoNghi;
		this.loaiNghi = loaiNghi;
	}
	@Override
	public String toString() {
		return "DonXinNghi [maDonNghi=" + maDonNghi + ", maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien
				+ ", loaiNhanVien=" + loaiNhanVien + ", ngayNghi=" + ngayNghi + ", lyDoNghi=" + lyDoNghi + ", loaiNghi="
				+ loaiNghi + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDonNghi == null) ? 0 : maDonNghi.hashCode());
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
		DonXinNghi other = (DonXinNghi) obj;
		if (maDonNghi == null) {
			if (other.maDonNghi != null)
				return false;
		} else if (!maDonNghi.equals(other.maDonNghi))
			return false;
		return true;
	}
}
